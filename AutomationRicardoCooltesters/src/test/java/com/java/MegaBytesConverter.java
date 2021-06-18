package com.java;

public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes<0){
            System.out.println("Invalid Value");
        }else{
            int conversionMBtoKB = kiloBytes / 1024;
            int remainingMBtoKB =  kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + conversionMBtoKB + " MB and " + remainingMBtoKB + " KB" );
        }
    }
}
