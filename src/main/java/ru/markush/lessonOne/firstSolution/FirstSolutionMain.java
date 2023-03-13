package ru.markush.lessonOne.firstSolution;

public class FirstSolutionMain {
    public static void main(String[] args) {
        Person somePerson = Person.newBuilder()
                .withFirstname("John")
                .withLastName("Piters")
                .withMiddleName("")
                .withAge(28)
                .withGender("male")
                .withCountry("America")
                .withAddress("Washington DC, Some str. apt 1,")
                .withPhone("+3 335457")
                .build();

        System.out.println(somePerson);
    }
}
