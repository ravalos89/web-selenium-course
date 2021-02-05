package com.exercise.tickets;

public class CoolParkTicket extends TicketsParks{
	
	double adultTicket, childTicket, studentTicket;
	int age;
	boolean student = false;
	String priceDay, park;
	
	// Constructor
	public CoolParkTicket(double price, int personAge, boolean studentID) {
		super();
		adultTicket = price;
		childTicket = price * (.80);
		studentTicket = price * (.5);
		age = personAge;
		student = studentID;
		priceDay = "Normal Day Price";
		park = "Cool Park - ";
	}
	
	//Encapsulation (Setter/Getter)
	private void setPriceDay(String priceDay) {
		this.priceDay = priceDay;
	}
	
	private String getPriceDay(String priceDay) {
		return priceDay;
	}
	
	// Method Get Ticket Price
	@Override
	public double getTicketPrice() {
		
		double priceTicket;
		if (student == true) {
			priceTicket = studentTicket;
			System.out.println("Student Price (50% applied): $"+studentTicket);
		}else if(age>=18) {
			priceTicket=adultTicket;
			System.out.println("Adult Price: $"+adultTicket);
		}else {
			priceTicket=childTicket;
			System.out.println("Child Price (20% applied): $"+childTicket);
		}
		
		return priceTicket;
	}
	
	// Method print price day
	@Override
	public void printPriceDay() {
		System.out.println(welcomeMessageString() + park + getPriceDay(priceDay));
	}
	@Override
	public void printPriceDay(String keyManagerAuth, String priceDay) {
		setPriceDay(priceDay);
		System.out.println(welcomeMessageString() + park + getPriceDay(priceDay));
	}

}
