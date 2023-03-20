package ru.markush.lessonTwo.linkedList;

public class Node {
    public int data;
    public Node nextNode;
    public Node prevNode;


    Node(int dataInput) {
        data = dataInput;
        nextNode = null;
        prevNode = null;
    }
}