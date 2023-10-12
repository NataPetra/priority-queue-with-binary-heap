# Priority Queue with Max-Heap and Min-Heap

This repository contains a Java implementation of a Priority Queue using Max-Heap and Min-Heap. Priority Queues are data structures that allow you to efficiently manage elements with priority or order. This project provides both Max-Priority Queue and Min-Priority Queue implementations, along with custom dynamic array support.

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [API Overview](#api-overview)
- [Usage](#usage)

## Introduction

A Priority Queue is a fundamental data structure used in various algorithms and applications. This project provides a versatile Java implementation of a Priority Queue based on Max-Heap and Min-Heap data structures. It is designed to work with generic elements that implement the `Comparable` interface.

## Project Structure

The project is organized into the following classes and interfaces:

- `PriorityQueue` Interface: Defines the core methods for working with Priority Queues. It offers a common API for different implementations, such as `MaxPriorityQueue` and `MinPriorityQueue`.
- `MaxPriorityQueue` Class: Implements the Max-Priority Queue using a Max-Heap data structure. This class allows you to manage elements with the highest priority at the top.
- `MinPriorityQueue` Class: Implements the Min-Priority Queue using a Min-Heap data structure. This class allows you to manage elements with the lowest priority at the top.
- `Heap` Interface: Defines the basic methods for inserting elements, peeking at the top element, and checking if the heap is empty. It is used by both `MaxPriorityQueue` and `MinPriorityQueue`.
- `CustomArrayList` Class: A custom dynamic array for internal use in the `MaxHeap` and `MinHeap` classes. It is used to manage the elements within the heaps.

## API Overview

### MaxPriorityQueue Class

The `MaxPriorityQueue` class implements the Max-Priority Queue. It provides methods for managing elements with the highest priority at the top:

- `insert(T item)`: Insert an element with higher priority.
- `peek()`: Get the element with the highest priority.
- `extractFirst()`: Remove and return the element with the highest priority.
- `isEmpty()`: Check if the Max-Priority Queue is empty.

### MinPriorityQueue Class

The `MinPriorityQueue` class implements the Min-Priority Queue. It offers methods for managing elements with the lowest priority at the top:

- `insert(T item)`: Insert an element with lower priority.
- `peek()`: Get the element with the lowest priority.
- `extractFirst()`: Remove and return the element with the lowest priority.
- `isEmpty()`: Check if the Min-Priority Queue is empty.

## Usage

You can use these Priority Queues in your Java applications to manage elements with priority or order efficiently. The provided `MaxPriorityQueue` and `MinPriorityQueue` classes allow you to work with the highest or lowest priority elements as needed.

Here's an example of how to use the Max-Priority Queue:

```java
MaxPriorityQueue<Integer> maxQueue = new MaxPriorityQueue<>();
maxQueue.insert(5);
maxQueue.insert(10);
maxQueue.insert(2);

System.out.println(maxQueue.peek()); // Output: 10
System.out.println(maxQueue.extractFirst()); // Output: 10