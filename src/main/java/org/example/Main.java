package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("Second commit!");

        Cat firstCat = new Cat("Борис", 2, "бежевый");
        Cat secondCat = new Cat("Мурзик", 3, "черно-белый");
        System.out.println("Данные первого кота: " + firstCat.getName()
                + ", " + firstCat.getColor() + "," + firstCat.getAge());

        System.out.println("Данные второго кота: " + secondCat.getName()
                + ", " + secondCat.getColor() + "," + secondCat.getAge());
    }

}