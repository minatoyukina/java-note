package lambda.option;

import java.util.Optional;

public class Person {
    private Car car;

    public Person(Car car) {
        this.car = car;
    }

    public Person() {
    }

    public Car getCar() {
        return car;
    }

    public static String getCarInsuranceName(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }

    public static void main(String[] args) {
        Insurance insurance=new Insurance("aaa");
        Car car=new Car(insurance);
        Person person = new Person(car);
//        Person person = new Person();
        String s = getCarInsuranceName(person);
        System.out.println(s);
    }
}

class Car {
    private Insurance insurance;

    public Car(Insurance insurance) {
        this.insurance = insurance;
    }

    public Car() {
    }

    public Insurance getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name;

    public Insurance(String name) {
        this.name = name;
    }


    public Insurance() {
    }

    public String getName() {
        return name;
    }
}
