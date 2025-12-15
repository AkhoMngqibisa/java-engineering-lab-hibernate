package com.akhona;

import com.akhona.entity.Developer;
import com.akhona.entity.Laptop;
import com.akhona.service.DeveloperService;

public class Main {

    public static Developer buildDeveloper() {
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
        DeveloperService developerService = new DeveloperService();

        developerService.setSessionFactory();
        developerService.setSession();
        developerService.setTransaction();

        developerService.createDeveloper(buildDeveloper());
    }
}