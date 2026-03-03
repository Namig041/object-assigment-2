package buffer;

public class Reader<T> {

    private final String readerId;
    private final RingBuffer<T> buffer;
    private long readSequence;

    protected Reader(String readerId, RingBuffer<T> buffer, long initialSequence) {
        this.readerId = readerId;
        this.buffer = buffer;
        this.readSequence = initialSequence;
    }

    public T read() {
        long writeSequence = buffer.getWriteSequence();
        long capacity = buffer.getCapacity();

        // If no new data available
        if (readSequence >= writeSequence) {
            return null;
        }

        // If reader has fallen behind (data overwritten)
        long oldestAvailableSequence = writeSequence - capacity;
        if (readSequence < oldestAvailableSequence) {
            readSequence = oldestAvailableSequence;
        }

        T item = buffer.readAt(readSequence);
        readSequence++;

        return item;
    }

    public String getReaderId() {
        return readerId;
    }
}