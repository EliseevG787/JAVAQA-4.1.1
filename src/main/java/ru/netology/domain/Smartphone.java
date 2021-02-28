package ru.netology.domain;

public class Smartphone extends Product {

    private String fabricator;

    public Smartphone(int id, String name, int price, String fabricator) {
        super(id, name, price);
        this.fabricator = fabricator;
    }

    public String getFabricator() {
        return fabricator;
    }
}
