package com.java;

public class LeapYear {

    public static boolean isLeapYear(int year){
        if(year>=1 && year<=9999){
            int divisible = year % 4;
            if( divisible == 0){
                divisible = year % 100;
                if(divisible == 0) {
                    divisible = year %400;
                    if(divisible==0){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
