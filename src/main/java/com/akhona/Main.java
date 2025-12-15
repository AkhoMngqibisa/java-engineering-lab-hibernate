package com.akhona;

import com.akhona.entity.*;

public class Main {

    public Developer buildDeveloper() {
        Laptop laptop = new Laptop();
        laptop.setBrand("Lenovo");
        laptop.setModel("i7");
        laptop.setRam(16);

        Developer developer = new Developer();
        developer.setFirstName("Akhona");
        developer.setLastName("Mngqibisa");
        developer.setTechnology("Java");
        developer.setLaptop(laptop);

        return developer;
    }

    public static void main(String[] args) {

    }
}