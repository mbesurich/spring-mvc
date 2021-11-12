package web.model;

import org.springframework.stereotype.Component;

public class Car {

    private String brand;
    private int age;
    private int power;

    public Car() {
    }

    public Car(String brand, int age, int power) {
        this.brand = brand;
        this.age = age;
        this.power = power;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", age=" + age +
                ", power=" + power +
                '}';
    }
}
