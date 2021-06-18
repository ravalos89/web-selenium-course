package com.java;

public class NumberOfDaysInMonth {

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

    public static int getDaysInMonth(int month, int year){
        if((month<1 || month>12) || (year<1 || year>9999)){
            return -1;
        }

        boolean isLeapYear = isLeapYear(year);

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if(isLeapYear){
                    return 29;
                }else{
                    return 28;
                }
            default:
                return -1;
        }
    }
}

