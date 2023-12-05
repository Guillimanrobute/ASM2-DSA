package org.example;

public class CustomStack {
    private static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }
    private Node top;
    public CustomStack() {
        this.top = null;
    }
    public void push(String message) {
        Node newNode = new Node(message);
        newNode.next = top;
        top = newNode;
    }
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        String message = top.data;
        top = top.next;
        return message;
    }
    public boolean isEmpty() {
        return top == null;
    }
}
