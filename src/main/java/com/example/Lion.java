package com.example;

import java.util.List;

public class Lion {

    Feline feline;
    boolean hasMane;

    public Lion(Feline feline, String sex) throws Exception {

        this.feline = feline;

        switch (sex) {
            case "Самец":
                this.hasMane = true;
                break;
            case "Самка":
                this.hasMane = false;
                break;
            default:
                throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }

    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
