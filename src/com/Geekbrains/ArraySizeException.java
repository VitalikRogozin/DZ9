package com.Geekbrains;

public class ArraySizeException extends Exception {
    private int x,y;
    public ArraySizeException(String errMessage,int x,int y){
        super(errMessage);
        this.x = x;
        this.y = y;
    }
}
