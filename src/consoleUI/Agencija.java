package consoleUI;

import java.util.ArrayList;
import java.util.List;


import classes.Flight;
import classes.RegisteredUser;
import classes.Role;
import classes.User;

public class Agencija {

	private static Agencija instance;
	private List<User> users;
	private List<Flight> flights;
	private List<Airport> airports;
	
	

	//private List<Device> devices;
	//private List<Receit> receits;
	public Agencija() {
		users = new ArrayList();
	}
	
	public static Agencija getInstance() {
		if (instance == null) {
			instance = new Agencija();
		} 		return instance;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public static void setInstance(Agencija instance) {
		Agencija.instance = instance;
	}
	
	
	public boolean addUser(String firstName, String lastName, String username, String password, String email) { 
		User user = checkIfUserExists(username);
		if(user != null)  {
				
				return false; 
			}		
		
		users.add(new RegisteredUser(username, password, firstName, lastName, email));
		
		return true;
			
	}

	
	
	

	private User checkIfUserExists(String username) {
		
	for (User userFromList : this.users) {
		if(userFromList.getUsername().equals(username)) {
			
			return userFromList;
		}
	}
	
	return null;
	}
	
	public boolean addFlight(String flightID, String destination1, String destination2, double price, int numberOfSeats, String description) { 
		Flight flight = checkIfFlightExists(flightID);
		if(flight != null)  {
				
				return false; 
			}		
		
		flights.add(new Flight(flightID, destination1, destination2, price, numberOfSeats, description));
		
		return true;
			
	}
	
	private Flight checkIfFlightExists(String flightID) {
		
		for (Flight flightFromList : this.flights) {
			if(flightFromList.getFlightID().equals(flightID)) {
				
				return flightFromList;
			}
		}
		
		return null;
		}
	
	public boolean addAirpot(String name) { 
		Airport airport = checkIfAirportExists(name);
		if(airport != null)  {
				
				return false; 
			}		
		
		airports.add(new Airport(name));
		
		return true;
			
	}
	
	public Airport checkIfAirportExists(String name) {
		
		for (Airport airportFromList : this.airports) {
			if(airportFromList.getName().equals(name)) {
				
				return airportFromList;
			}
		}
		
		return null;
		}
	
}
