package com.java;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] dias = {"L", "M", "Mi", "J", "V", "S","D"};
		
		System.out.println(dias[2]);
		
		String diaSemana = dias[2];
		System.out.println("Variable "+diaSemana);
		
		for(int i =0; i < 7; i++) {
			System.out.println(dias[i]);
		}
		
		String [][]amigo = new String[2][2];
		
		amigo[0][0]="Ricardo";
		amigo[0][1]="Leonardo";
		amigo[1][0]="Carlos";
		amigo[1][1]="Alex";
		amigo[2][1]="Alan";
		
		System.out.println(amigo[2][1]);
	}
	
	public static void metodo() {
		
		System.out.println("Este es mi metodo");
		
	}
	
	public static String frases(String frase, String frase2, int numero) {
		return frase + " "+frase2 + " "+numero ;
	}
	
	public static void wrapperMethod() {
		metodo();
		suma(1,2);
	}
	
	
	public static int suma(int x, int y) {
		return x+y;
	}
	
	public static int suma(int x, int y, int z) {
		return x+y+z;
	}
	
	public static int suma(int x, int y, int z, int a) {
		return x+y+z+a;
	}

}


