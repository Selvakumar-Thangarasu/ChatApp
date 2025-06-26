# 💬 Chat Application Simulator (Console-Based)

A simple console-based chat simulation using Java Collections Framework. It allows users to register, send messages, and view chat history.

## 🚀 Features
- Register users
- Send messages between users
- View chat history (bi-directional)
- Timestamps for each message
- Stores history using `HashMap` and `LinkedList`

## 🛠️ Technologies Used
- Java 8+
- Collections Framework: `HashMap`, `LinkedList`, `Set`
- `LocalDateTime` for timestamps

## 🧱 Data Structure
```java
Map<String, LinkedList<Message>> chatHistory;
Set<String> users;
