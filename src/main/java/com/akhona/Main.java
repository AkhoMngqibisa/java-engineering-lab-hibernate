package com.akhona;

import com.akhona.entity.Developer;
import com.akhona.entity.Laptop;
import com.akhona.service.DeveloperService;

public class Main {

    private DeveloperService developerService;

    public void createDeveloper() {
        Laptop laptop = new Laptop();
        laptop.setBrand("Lenovo");
        laptop.setModel("i7");
        laptop.setRam(16);

        Developer developer = new Developer();
        developer.setFirstName("Akhona");
        developer.setLastName("Mngqibisa");
        developer.setTechnology("Java");
        developer.setLaptop(laptop);

        developerService.createDeveloper(developer);
        developerService.getSession().persist(developer);
        developerService.getTransaction().commit();

        developerService.getSession().close();
        developerService.getSessionFactory().close();

        System.out.println("Developer created successfully");
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.createDeveloper();
    }
}