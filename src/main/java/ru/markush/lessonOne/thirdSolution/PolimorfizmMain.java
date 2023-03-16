package ru.markush.lessonOne.thirdSolution;

public class PolimorfizmMain {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        Animal someAnimal = new Animal();

        cat.say();
        dog.say();
        someAnimal.say();

    }
}
