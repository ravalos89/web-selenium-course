package com.java;

public class DosEnDos {

	public static void main(String[] args) {
		
		count();
	}
	
	public static void count() {
		int count = 0;
		
		while(count<=100) {
			System.out.println("Number: "+ count);
			count += 2;
		}
	}

}
