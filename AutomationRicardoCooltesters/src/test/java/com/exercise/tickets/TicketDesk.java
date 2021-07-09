package com.exercise.tickets;

public class TicketDesk {

	public static void main(String[] args) {
		
		// Inputs	
		double price = 100;
		int age = 20;
		boolean isStudent = true;
		
		// Cool Park
		TicketsParks ticket = new CoolParkTicket(price, age, isStudent);
		ticket.printPriceDay();
		double coolPrice = ticket.getTicketPrice();
		
		// Testers Park
		ticket = new TestersParkTicket(price, age, isStudent, 20);
		ticket.printPriceDay();
		double testersPrice = ticket.getTicketPrice();
		
		//Sum parks
		System.out.println("El Total de los tickets es: $"+sumPark(coolPrice, testersPrice));
		
		// Arreglar el error ya que solo se debe aplicar un descuento y no puede ser estudiante o niño
		// Agregar un constructor en ambas clases donde se aplique un descuento especial
		// Hacer un metodo para obtener la suma de ambos tickets		

	}
	
	//HW
	public static double sumPark(double park1, double park2) {
		return park1 + park2;
	}

}
