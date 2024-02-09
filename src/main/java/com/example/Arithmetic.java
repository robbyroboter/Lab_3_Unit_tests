package com.example;

public class Arithmetic {
    public static void main(String[] argv){
        int a=2, b=3;
        System.out.println(add(a,b));
        System.out.println(subtract(a,b));
        System.out.println(multiply(a,b));
    }

    public static int add(int a, int b){
        int sum=a+b;
        return sum;
    }

    public static int subtract(int a, int b){
        int sub=a-b;
        return sub;
    }

    public static int multiply(int a, int b){
        int mul=a*b;
        return mul;
    }
}
