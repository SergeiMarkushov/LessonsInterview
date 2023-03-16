package ru.markush.lessonTwo.linkedList;
public class Main {
    public static void main(String[] args) {

        CustomLikedList list = new SinglyLinkedList(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.printList();
        System.out.println(list.getLength());
        System.out.println(list.getItemAt(4));
        System.out.println(list.getHead());
        System.out.println(list.getTail());
        list.remove(5);
        System.out.println("-------------------------");

    }
}
