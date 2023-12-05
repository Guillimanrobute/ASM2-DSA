package org.example;

public class CustomQueue {
    private static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }
    private Node front;
    private Node rear;

    public CustomQueue() {
        this.front = null;
        this.rear = null;
    }
    public void enqueue(String message) {
        Node newNode = new Node(message);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        String message = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return message;
    }
    public boolean isEmpty() {
        return front == null;
    }
}
