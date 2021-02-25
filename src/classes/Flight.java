package classes;

public class Flight {
	
	private String flightID;
	private String destination1;
	private String destination2;
	private double price;
	private int numberOfSeats;
	private String description;
	//private Category category;
	
	public Flight() {}
	
	public Flight(String flightID, String destination1, String destination2, double price, int numberOfSeats, String description) {
		super();
		this.flightID = flightID;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.price = price;
		this.numberOfSeats = numberOfSeats;
		this.description = description;
		
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public String getDestination1() {
		return destination1;
	}

	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}

	public String getDestination2() {
		return destination2;
	}

	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
