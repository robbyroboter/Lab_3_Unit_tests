package com.example;

public class Strings {
    public static void main(String[] argv){
        String name="John";
        String surname="Jameson";
        System.out.println(unite(name,surname));
        System.out.println(reverse(name,surname));
    }

    public static String unite(String name, String surname){
        return name+" "+surname;
    }

    public static String reverse(String name, String surname){
        String rev=name+" "+surname;
        return new StringBuilder(rev).reverse().toString();
    }

}
