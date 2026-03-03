# object-assigment-2Name: Namig Amralizada Student ID: 14042 # object-assigment-2
# Ring Buffer (Single Writer, Multiple Readers)

## Overview

This project implements a thread-safe **Ring Buffer** in Java that supports:

- Single Writer
- Multiple Readers
- Independent reader positions
- Overwriting of oldest data when full

Each reader maintains its own read position. Reading by one reader does not remove data for other readers. If the buffer becomes full, the writer overwrites the oldest data, and slow readers may miss items.

---

## Design

### RingBuffer<T>
Responsible for:
- Managing fixed-size storage
- Handling write operations
- Maintaining global write sequence
- Registering readers
- Controlling synchronization

### Reader<T>
Responsible for:
- Maintaining its own read position
- Reading data independently
- Detecting and handling overwritten data

---

## UML Diagrams

The project includes:

- UML Class Diagram  
- UML Sequence Diagram for `write()`  
- UML Sequence Diagram for `read()`

---

## How to Compile

From the root directory:

javac buffer/.java demo/.java

## How to Run
java demo.Main
---

## Key Features

- Fixed capacity buffer
- Overwrite-on-full behavior
- Independent multi-reader support
- Clean object-oriented design
- Thread-safe write operation