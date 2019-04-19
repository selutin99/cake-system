package com.cake.system.views;

import com.cake.system.controllers.*;
import com.cake.system.entity.CakesBases;

import java.util.Iterator;
import java.util.Scanner;

public class CakeOrderView {
    private static int customerID;
    private static int cakeID;

    private Scanner sc;

    //Controllers
    private CakesController cakes;
    private CustomersController customer;

    private DecorationsController decorations;
    private CharacteristicsController characteristics;

    //Associations controllers
    private CakesDecorationsController cakesDecor;
    private CakesCharacteristicsController cakesChar;
    private DecorationsCharacteristicsController decorChar;

    private CakesBasesController cakesBases;

    public CakeOrderView(Scanner scanner){
        cakes = new CakesController();
        customer = new CustomersController();

        decorations = new DecorationsController();
        characteristics = new CharacteristicsController();

        cakesDecor = new CakesDecorationsController();
        cakesChar = new CakesCharacteristicsController();
        decorChar = new DecorationsCharacteristicsController();

        cakesBases = new CakesBasesController();

        sc = scanner;

        header();

        int choise;
        do {
            menu();
            System.out.println(":::Введите необходимое действие:::");
            choise = Integer.parseInt(sc.next());

            switch (choise) {
                case 0:
                    break;
                case 1:
                    makeOrder();
                    break;
                default:
                    System.out.println("Введите корректное действие");
            }
        } while(choise!=0);
        new MainMenu();
    }

    private void header(){
        System.out.println("Выдача торта");
        System.out.println("==============================\n");
    }

    private void menu(){
        System.out.println("1 - оформить заказ");
        System.out.println("0 - в главное меню\n");
    }

    private void makeOrder() {
        System.out.println("Добавляем клиента");
        addCustomer();
        System.out.println("Клиент успешно добавлен\n");

        System.out.println("Введите название торта");
        String name = sc.next();

        System.out.println("Выберите основу торта");
        int cakeBaseID = addCakeBase();
        System.out.println("Основа успешно добавлена");

        System.out.println("Выберите украшение торта");
        int decorID = addDecor();
        System.out.println("Украшение успешно добавлена");

        System.out.println("Выберите характеристику торта");
        int charID = addCharacteristics();
        System.out.println("Характеристика успешно добавлена");


    }

    private void addCustomer(){
        System.out.println("Введите имя получателя");
        String name = sc.next();

        System.out.println("Введите фамилию получателя");
        String lastName = sc.next();

        customer.add(++customerID, name, lastName);
    }

    private int addCakeBase(){
        System.out.println("Выберите id основы");

        Iterator iterator = cakesBases.getAll().iterator();
        itera(iterator);
        int id = Integer.parseInt(sc.next());
        return id;
    }

    private int addDecor(){
        System.out.println("Выберите id украшения");

        Iterator iterator = decorations.getAll().iterator();
        itera(iterator);
        int id = Integer.parseInt(sc.next());
        return id;
    }

    private int addCharacteristics(){
        System.out.println("Выберите id характеристики");

        Iterator iterator = decorations.getAll().iterator();
        itera(iterator);
        int id = Integer.parseInt(sc.next());
        return id;
    }

    private void itera(Iterator iterator){
        System.out.println("==============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }
}
