package com.example.demo.model;

//Message.java
public class Message {
 private String content;
 private String sender;

 // Getters and Setters
 public String getContent() {
     return content;
 }

 public void setContent(String content) {
     this.content = content;
 }

 public String getSender() {
     return sender;
 }

 public void setSender(String sender) {
     this.sender = sender;
 }

 // ToString method
 @Override
 public String toString() {
     return "Message{" +
             "content='" + content + '\'' +
             ", sender='" + sender + '\'' +
             '}';
 }
}
