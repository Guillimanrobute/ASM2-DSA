package org.example;
import java.util.Scanner;
public class CustomStackQueueDemo {
    public static void main(String[] args) {
        CustomQueue incomingQueue = new CustomQueue();
        CustomStack sentStack = new CustomStack();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Enqueue message to incoming queue");
            System.out.println("2. Dequeue message from incoming queue");
            System.out.println("3. Push message to sent stack");
            System.out.println("4. Pop message from sent stack");
            System.out.println("5. View incoming messages");
            System.out.println("6. View sent messages");
            System.out.println("7. Send messages from incoming queue to sent stack");
            System.out.println("8. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter message to enqueue: ");
                    String enqueueMessage = scanner.nextLine();
                    incomingQueue.enqueue(enqueueMessage);
                    System.out.println("Message enqueued.");
                    break;
                case 2:
                    try {
                        String dequeueMessage = incomingQueue.dequeue();
                        System.out.println("Dequeued message: " + dequeueMessage);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter message to push: ");
                    String pushMessage = scanner.nextLine();
                    sentStack.push(pushMessage);
                    System.out.println("Message pushed.");
                    break;
                case 4:
                    try {
                        String popMessage = sentStack.pop();
                        System.out.println("Popped message: " + popMessage);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\nIncoming Messages:");
                    while (!incomingQueue.isEmpty()) {
                        System.out.println(incomingQueue.dequeue());
                    }
                    break;
                case 6:
                    System.out.println("\nSent Messages:");
                    while (!sentStack.isEmpty()) {
                        System.out.println(sentStack.pop());
                    }
                    break;
                case 7:
                    System.out.println("\nSending messages from incoming queue to sent stack:");
                    while (!incomingQueue.isEmpty()) {
                        String message = incomingQueue.dequeue();
                        sentStack.push(message);
                        System.out.println("Sent: " + message);
                    }
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
