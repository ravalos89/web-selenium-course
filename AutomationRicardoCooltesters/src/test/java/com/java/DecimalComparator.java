package com.java;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double decimal1, double decimal2){

        decimal1= decimal1 * 1000;
        decimal2= decimal2 * 1000;

        int converterD1 = (int) decimal1;
        int converterD2 = (int) decimal2;

        if(converterD1==converterD2) {
            return true;
        }else{
            return false;
        }
    }
}