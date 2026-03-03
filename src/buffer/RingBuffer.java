package buffer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class RingBuffer<T> {

    private final Object[] buffer;
    private final int capacity;

    private long writeSequence = 0;
    private final Map<String, Reader<T>> readers = new ConcurrentHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public RingBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.buffer = new Object[capacity];
    }

    public void write(T item) {
        lock.lock();
        try {
            long index = writeSequence % capacity;
            buffer[(int) index] = item;
            writeSequence++;
        } finally {
            lock.unlock();
        }
    }

    public Reader<T> registerReader(String readerId) {
        Reader<T> reader = new Reader<>(readerId, this, writeSequence);
        readers.put(readerId, reader);
        return reader;
    }

    protected T readAt(long sequence) {
        long index = sequence % capacity;
        return (T) buffer[(int) index];
    }

    protected long getWriteSequence() {
        return writeSequence;
    }

    protected int getCapacity() {
        return capacity;
    }
}