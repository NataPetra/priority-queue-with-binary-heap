# Priority Queue with Min-Heap

This repository contains a Java implementation of a Priority Queue using Min-Heap. Priority Queues are data structures that allow you to efficiently manage elements with priority or order. This project provides a Min-Priority Queue implementation, along with custom dynamic array support.

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [API Overview](#api-overview)
- [Usage](#usage)

## Introduction

A Priority Queue is a fundamental data structure used in various algorithms and applications. This project provides a versatile Java implementation of a Priority Queue based on Min-Heap data structure. It is designed to work with generic elements.

## Project Structure

The project is organized into the following classes and interfaces:

- `PriorityQueue` Interface: Defines the core methods for working with Priority Queues. It offers a common API for different implementations.
- `MinHeap` Class: Implements the Min-Priority Queue using a Min-Heap data structure. This class allows you to manage elements with the lowest priority at the top.
- `CustomArrayList` Class: A custom dynamic array for internal use in the `MinHeap` class. It is used to manage the elements within the heap.

## API Overview

### MinHeap Class

The `MinHeap` class implements the Min-Priority Queue. It offers methods for managing elements with the lowest priority at the top:

- `add(T item)`: Insert an element with lower priority.
- `peek()`: Get the element with the lowest priority.
- `poll()`: Remove and return the element with the lowest priority.
- `isEmpty()`: Check if the Min-Priority Queue is empty.

## Usage

You can use this Min-Priority Queue in your Java applications to manage elements with lower priority efficiently.

Here's an example of how to use the Min-Priority Queue:

```java
MinHeap<Integer> minQueue = new MinHeap<>();
minQueue.add(5);
minQueue.add(10);
minQueue.add(2);

System.out.println(minQueue.peek()); // Output: 2
System.out.println(minQueue.poll()); // Output: 2