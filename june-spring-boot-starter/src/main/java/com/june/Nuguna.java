package com.june;

public class Nuguna {
    String name;
    int howLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }

    @Override
    public String toString() {
        return "nuguna{" +
                "name='" + name + '\'' +
                ", howLong=" + howLong +
                "}";
    }
}
