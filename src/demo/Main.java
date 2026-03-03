package demo;

import buffer.RingBuffer;
import buffer.Reader;

public class Main {

    public static void main(String[] args) {
//First Check
        RingBuffer<String> buffer = new RingBuffer<>(5);

        Reader<String> reader1 = buffer.registerReader("Reader1");
        Reader<String> reader2 = buffer.registerReader("Reader2");

        buffer.write("A");
        buffer.write("B");
        buffer.write("C");

        System.out.println("Reader1: " + reader1.read());
        System.out.println("Reader2: " + reader2.read());

        buffer.write("D");
        buffer.write("E");
        buffer.write("F"); // overwrites oldest

        System.out.println("Reader1: " + reader1.read());
        System.out.println("Reader1: " + reader1.read());
        System.out.println("Reader1: " + reader1.read());

        System.out.println("Reader2: " + reader2.read());
// Second check
//        RingBuffer<String> buffer = new RingBuffer<>(3);
//
//        Reader<String> r1 = buffer.registerReader("R1");
//
//        buffer.write("A");
//        buffer.write("B");
//        buffer.write("C");
//        buffer.write("D"); // This should overwrite A
//
//        System.out.println(r1.read());
//        System.out.println(r1.read());
//        System.out.println(r1.read());
//Third check
//        RingBuffer<String> buffer = new RingBuffer<>(3);
//
//        Reader<String> r1 = buffer.registerReader("R1");
//        Reader<String> r2 = buffer.registerReader("R2");
//
//        buffer.write("A");
//        buffer.write("B");
//
//        System.out.println("R1: " + r1.read());
//        System.out.println("R2: " + r2.read());
    }
}