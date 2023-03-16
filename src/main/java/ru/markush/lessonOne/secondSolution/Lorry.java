package ru.markush.lessonOne.secondSolution;

public class Lorry extends LightWeightCar{
    @Override
    public void move(){
        System.out.println("Car is moving");
    }
    @Override
    public void stop(){
        System.out.println("Car is stop");
    }


    @Override
    public void start() {
        System.out.println("Car is start");
    }

    @Override
    public void open() {
        System.out.println("Car is open");
    }
}

