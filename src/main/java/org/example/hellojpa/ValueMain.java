package org.example.hellojpa;

public class ValueMain {

    public static void main(String[] args) {
        Integer a = Integer.valueOf(10);
        Integer b = a;

        Address address1 = new Address("city", "street", "10");

        Address address2 = new Address("city", "street", "10");

        System.out.println("address1 == address2 : " + (address1 == address2));
        System.out.println("address1.equals(address2) : " + (address1.equals(address2)));




//        int a = 10;
//        int b = a;
//
//        a = 20;
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
    }

}
