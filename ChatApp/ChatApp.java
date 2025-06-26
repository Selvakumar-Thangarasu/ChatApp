package ChatApp;
import java.time.LocalDateTime;
import java.util.*;

class Message {
    String sender;
    String receiver;
    String content;
    LocalDateTime timestamp;

    Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + " to " + receiver + ": " + content;
    }
}

public class ChatApp {
    static Scanner scanner = new Scanner(System.in);
    static Set<String> users = new HashSet<>();
    static Map<String, LinkedList<Message>> chatHistory = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Register User\n2. Send Message\n3. View Chat History\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> sendMessage();
                case 3 -> viewChatHistory();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void registerUser() {
        System.out.print("Enter username: ");
        String name = scanner.nextLine();
        if (users.contains(name)) {
            System.out.println("User already exists.");
        } else {
            users.add(name);
            System.out.println("User registered.");
        }
    }

    static void sendMessage() {
        System.out.print("Sender name: ");
        String sender = scanner.nextLine();
        System.out.print("Receiver name: ");
        String receiver = scanner.nextLine();

        if (!users.contains(sender) || !users.contains(receiver)) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.print("Enter message: ");
        String content = scanner.nextLine();

        Message msg = new Message(sender, receiver, content);
        String key1 = sender + "-" + receiver;
        String key2 = receiver + "-" + sender;

        chatHistory.putIfAbsent(key1, new LinkedList<>());
        chatHistory.get(key1).add(msg);

        chatHistory.putIfAbsent(key2, new LinkedList<>());
        chatHistory.get(key2).add(msg); // storing both sides
        System.out.println("Message sent.");
    }

    static void viewChatHistory() {
        System.out.print("Enter first user: ");
        String user1 = scanner.nextLine();
        System.out.print("Enter second user: ");
        String user2 = scanner.nextLine();

        String key = user1 + "-" + user2;
        if (!chatHistory.containsKey(key)) {
            System.out.println("No chat history found.");
            return;
        }

        System.out.println("\nChat between " + user1 + " and " + user2 + ":");
        for (Message msg : chatHistory.get(key)) {
            System.out.println(msg);
        }
    }
}

