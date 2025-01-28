package com.yagyik.productservicedec24.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String s) {
        System.out.println(s);
    }
}
