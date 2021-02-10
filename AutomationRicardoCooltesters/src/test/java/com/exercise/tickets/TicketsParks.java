package com.exercise.tickets;

public abstract class TicketsParks {
	
	String welcomeMessage;
	
	public TicketsParks() {
		this.welcomeMessage = "Welcome Cooltesters Park - ";
	}
	
	public String welcomeMessageString() {
		return this.welcomeMessage;
	}
	
	public abstract double getTicketPrice();
	public abstract void printPriceDay();
	public abstract void printPriceDay(String keyManagerAuth, String priceDay);

}
