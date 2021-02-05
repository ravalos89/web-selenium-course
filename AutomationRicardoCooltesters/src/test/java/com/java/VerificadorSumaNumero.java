package com.java;

public class VerificadorSumaNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("La suma de num1 y num2 es igual a num3? = "+hasEqualSum(1,1,1));

	}
	
	public static boolean hasEqualSum(int num1, int num2, int num3) {
		return (num1 + num2 == num3) ? true : false;
	}

}
