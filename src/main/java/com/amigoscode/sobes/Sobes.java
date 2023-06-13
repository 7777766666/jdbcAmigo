package com.amigoscode.sobes;

public class Sobes {

    public static void main(String[] args) {

        Sobes sobes = new Sobes();

        int x = 7;
        int y = 5;
        System.out.println(sobes.method(x, y));
        System.out.println(y);

    }

    protected final Integer method(Integer x, final Integer y){
        return (y != 0) ? x + (method(x, y - 1)) : 0;
    }

}
