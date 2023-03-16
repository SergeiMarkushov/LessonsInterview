package ru.markush.lessonOne.secondSolution;

public class LightWeightCar extends Car implements Moveable, Stopable{
    @Override
    public void open() {
        System.out.println("Car is open");
    }
    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
}
