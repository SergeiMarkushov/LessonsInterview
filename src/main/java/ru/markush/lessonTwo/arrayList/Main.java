package ru.markush.lessonTwo.arrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> strings = new CustomArrayList<>();

        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        strings.add("Four");
        strings.add("Five");
        strings.add("Six");

        printCustomArray(strings);
        System.out.println(strings.size());
        System.out.println("---------------");
        strings.remove(1);
        strings.remove(2);
        strings.remove(3);
        printCustomArray(strings);
        System.out.println("----------------");
        System.out.println(strings.get(2));
        System.out.println("----------------");
        System.out.println(strings.size());

    }

    public static void printCustomArray(CustomArrayList list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
