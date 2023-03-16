package ru.markush.lessonOne.firstSolution;
import lombok.Data;

@Data
public class Person {
    private String firstname;
    private String LastName;
    private String middleName;
    private String country;
    private String address;
    private int age;
    private String gender;
    private String phone;

    private Person(Builder builder) {
        firstname = builder.firstname;
        LastName = builder.LastName;
        middleName = builder.middleName;
        country = builder.country;
        address = builder.address;
        age = builder.age;
        gender = builder.gender;
        phone = builder.phone;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Person copy) {
        Builder builder = new Builder();
        builder.firstname = copy.getFirstname();
        builder.LastName = copy.getLastName();
        builder.middleName = copy.getMiddleName();
        builder.country = copy.getCountry();
        builder.address = copy.getAddress();
        builder.age = copy.getAge();
        builder.gender = copy.getGender();
        builder.phone = copy.getPhone();
        return builder;
    }


    public static final class Builder {
        private String firstname;
        private String LastName;
        private String middleName;
        private String country;
        private String address;
        private int age;
        private String gender;
        private String phone;

        private Builder() {
        }


        public Builder withFirstname(String val) {
            firstname = val;
            return this;
        }

        public Builder withLastName(String val) {
            LastName = val;
            return this;
        }

        public Builder withMiddleName(String val) {
            middleName = val;
            return this;
        }

        public Builder withCountry(String val) {
            country = val;
            return this;
        }

        public Builder withAddress(String val) {
            address = val;
            return this;
        }

        public Builder withAge(int val) {
            age = val;
            return this;
        }

        public Builder withGender(String val) {
            gender = val;
            return this;
        }
        public Builder withPhone(String val) {
            phone = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
