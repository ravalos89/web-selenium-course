package com.exercise.tickets;

public class TestersParkTicket extends TicketsParks{
	
	double adultTicket, childTicket, studentTicket;
	int age;
	boolean student = false;
	String priceDay, park;
	
	// Constructor
	public TestersParkTicket(double price, int personAge, boolean studentID) {
		super();
		adultTicket = price;
		childTicket = price * (.90);
		studentTicket = price * (.60);
		age = personAge;
		student = studentID;
		priceDay = "Normal Day Price";
		park = "Testers Park - ";
	}
	
	public TestersParkTicket(double price, int personAge, boolean studentID, int discont) {
		super();
		adultTicket = price - discont;
		childTicket = (price * (.90)) -  discont;
		studentTicket = (price * (.60)) - discont;
		age = personAge;
		student = studentID;
		priceDay = "Normal Day Price";
		park = "Testers Park - ";
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
		if(age>=18 && !student) {
			priceTicket=adultTicket;
			System.out.println("Adult Price: $"+adultTicket);		
		}else if(age>=18 && student) {
			priceTicket = studentTicket;
			System.out.println("Student Price (50% applied): $"+studentTicket);		
		}else if(age<18 && student) {
			priceTicket = studentTicket * (0.8);
			System.out.println("Child & Student Special Price : $"+priceTicket);	
		}else {
			priceTicket = childTicket;
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
