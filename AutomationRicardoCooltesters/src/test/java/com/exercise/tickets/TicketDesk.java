package com.exercise.tickets;

public class TicketDesk {

	public static void main(String[] args) {
		
		// Inputs	
		double price = 100;
		int age = 10;
		boolean isStudent = true;
		
		// Cool Park
		TicketsParks ticket = new CoolParkTicket(price, age, isStudent);
		ticket.printPriceDay();
		ticket.getTicketPrice();
		
		// Testers Park
		ticket = new TestersParkTicket(price, age, isStudent);
		ticket.printPriceDay();
		ticket.getTicketPrice();
		
		// Arreglar el error ya que solo se debe aplicar un descuento y no puede ser estudiante o niño
		// Agregar un constructor en ambas clases donde se aplique un descuento especial
		// Hacer un metodo para obtener la suma de ambos tickets

	}

}
