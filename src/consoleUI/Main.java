package consoleUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import classes.Role;
import classes.User;






public class Main{

	public static Scanner scanner = new Scanner(System.in);
	public static Agencija company;
	
	public static void main(String[] args) {
		
		company = Agencija.getInstance();
		LoginOrRegister();
		

	}
	
	public static void LoginOrRegister() {
		String option = null;
		do {
			System.out.println("Ispis menija za unos");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("x za izlaz");
			
			
			option = scanner.nextLine();
			
			switch (option) {
			case "1":
				login();
				break;
			case "2":
				register();
				break;
			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
				break;
			} 
			
		} while(!option.equals("x"));
	}
	public static void login() {
		boolean logedIn = false;
		do {
			System.out.println("Unesi korisnicko ime: ");
			String username = scanner.nextLine();
			System.out.println("Unesi lozinku: ");
			String password = scanner.nextLine();
			for (User user : company.getUsers()) {
				if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
					if (user.getRole().equals(Role.REGISTERED_USER)) {
						logedIn = true;
						printRegisteredUserMenu();
						
					} else if  (user.getRole().equals(Role.AIRCOMPANY_ADMIN)) {
						logedIn = true;
						printAirCompanyAdminMenu();
							
							
					} else if  (user.getRole().equals(Role.HOTEL_ADMIN)) {
						logedIn = true;
						printHotelAdminMenu();
								
					} else if  (user.getRole().equals(Role.SYS_ADMIN)) {
						logedIn = true;
						printSysAdminMenu();
								
					}
					
					
					break;
				}	
			}
		}  while(!logedIn);
		
	}
	
	
	public static void register() {
		
		System.out.println("Unesi ime");
		String username = scanner.nextLine();
		System.out.println("Unesi prezime");
		String firstName = scanner.nextLine();
		System.out.println("Unesi korisnicko ime");
		String lastName = scanner.nextLine();
		System.out.println("Unesi sifru");
		String password = scanner.nextLine();
		System.out.println("Unesi email");
		String email = scanner.nextLine();
		
		if(company.addUser(username, firstName, lastName, password, email)) {
			System.out.println("Uspesno izvedeno");
		}
		else {
			System.out.println("Neuspesno izvedeno");
		}
		
	
		
	}
	private static void printRegisteredUserMenu() {
		String option = null;
		do {
			System.out.println("Ispis menija za unos");
			System.out.println("1. Rezervisati avionsku kartu");
			System.out.println("2. Otkazati rezervisan let");
			System.out.println("3. Rezervisati hotelski smestaj");
			System.out.println("x za izlaz");
			
			
			option = scanner.nextLine();
			
			switch (option) {
			case "1":
				flightCardReservation();
				break;
			case "2":
				cancelPlaneCardReservation();
				break;
			case "3":
				hotelReservation();
				break;
			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
				break;
			} 
			
		} while(!option.equals("x"));
	}

	private static void flightCardReservation() {
		
		String option = null;
		do {
			System.out.println("Ispis menija za unos");
			System.out.println("1. Rezervisati avionsku kartu");
			System.out.println("x za izlaz");
			
			//treba da ide display flights, i onda na osnovu tih, odabere jedan
			//kad odabere jedan, treba da vidi prvo koliko ima SLOBODNIH mesta na letu, i kada rezervise odredjen broj karata, za toliko da se broj mesta smanji
			//
			option = scanner.nextLine();

			
			
		} while(!option.equals("x"));
		
	}
	
	private static void cancelPlaneCardReservation() {
		// TODO Auto-generated method stub
		
	}

	private static void hotelReservation() {
		// TODO Auto-generated method stub
		
	}
	

	private static void printAirCompanyAdminMenu() {
		String option = null;
		do {
			System.out.println("Ispis menija za unos");
			System.out.println("1. Aerodromi");
			System.out.println("2. Novi letovi");
			System.out.println("3. Cene karata");
			System.out.println("4. Izvestaj o prodatim kartama");
			System.out.println("5. Ocene korisnika");
			System.out.println("6. Prihod"); //nedeljni, mesecni, godisnji
			System.out.println("x za izlaz");
			
			
			option = scanner.nextLine();
			
			switch (option) {
			case "1":
				addAirports();
				break;
			case "2":
				newFlights();
				break;
			case "3":
				cardPrices();
				break;
			case "4":
				//soldCardsReport();
				break;
			case "5":
				//userBackfeed();
				break;
			case "6":
				//prihod();
				break;
			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
				break;
			} 
			
		} while(!option.equals("x"));
	}
	
	
	

	private static void addAirports() {
		
		System.out.println("Unesi ime aerodroma");
		String name = scanner.nextLine();
		
		
		if(company.addAirpot(name)) {
			System.out.println("Uspesno izvedeno");
		}
		else {
			System.out.println("Neuspesno izvedeno");
		}
		
	}
	
	private static void newFlights() {
		String airport1 = "";
		String airport2 = "";
		double price = 0;
		int numberOfSeats;
		System.out.println("Unesi ID leta ime");
		String flightID = scanner.nextLine();
		System.out.println("Unesi polaznu destinaciju");
		String tempDestination = scanner.nextLine();
		if (company.checkIfAirportExists(tempDestination).equals(null)) { //mnogo finije resenje bi bilo ako bih imao metodu za svako od polja u praksi, mesto da ga konstantno vraca al jbg
			System.out.println("Uneti aerodrom ne postoji u bazi");
			newFlights();
		}
		airport1 = tempDestination;
		System.out.println("Unesi krajnju destinaciju");
		tempDestination = scanner.nextLine();
		if (company.checkIfAirportExists(tempDestination).equals(null) || !tempDestination.equals(airport1) ) {
			System.out.println("Uneti aerodrom ne postoji u bazi ili je pocetna destinacija");
			newFlights();
		}
		airport2 = tempDestination;
		System.out.println("Unesi cenu");
		String tempPrice = scanner.nextLine();
		if (Double.parseDouble(tempPrice) > -0.5) {
			price = Double.parseDouble(tempPrice);
		} else {
			System.out.println("Pogresan unos, uneti broj");
			newFlights();
		}
		System.out.println("Unesi broj sedista");
		String tempNumbOfSeats = scanner.nextLine();
		if (Integer.parseInt(tempNumbOfSeats) > 0) {
			numberOfSeats = Integer.parseInt(tempNumbOfSeats);
		} else {
			System.out.println("Pogresan unos, uneti broj");
			newFlights();
		}
		numberOfSeats = Integer.parseInt(scanner.nextLine());
		System.out.println("Uneti opis");
		String description = scanner.nextLine();
		
		
			if(company.addFlight(flightID, airport1, airport2, price, numberOfSeats, description)) {
				System.out.println("Uspesno izvedeno");
			}
			else {
				System.out.println("Neuspesno izvedeno");
			}
			
		}
	
	private static void cardPrices() {
		// TODO Auto-generated method stub
		
	}	

	private static void printHotelAdminMenu() {
		String option = null;
		do {
			System.out.println("Ispis menija za unos");
			System.out.println("1. Cenovnik");//pansion, polupansion, transfer od/do hotela
			System.out.println("2. Sobe"); //zauzete ili ne na koji period
			System.out.println("3. Ocene korisnika");
			System.out.println("4. Izvestaj o prodatim kartama");
			System.out.println("5. Prihod"); //nedeljni, mesecni, godisnji
			System.out.println("x za izlaz");
			
			
			option = scanner.nextLine();
			
			switch (option) {
			case "1":
				cenovnik();
				break;
			case "2":
				sobe();
				break;
			case "3":
				ocene();
				break;
			case "4":
				izvestaj();
				break;
			case "5":
				prihod();
				break;
			
			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
				break;
			} 
			
		} while(!option.equals("x"));
	}

	

	
	private static void printSysAdminMenu() {
		String option = null;
		do {//interfejs u ovom kontekstu?
			System.out.println("Ispis menija za unos");
			System.out.println("1.Registrovati aviokompaniju");
			System.out.println("2. Registrovati hotel");
			System.out.println("3. Registrovati rent-a-car");
			System.out.println("4. Registrovati novog korisnika");
			System.out.println("x za izlaz");
			
			
			option = scanner.nextLine();
			
			switch (option) {
			case "1":
				//registerAirCompany();
				break;
			case "2":
				//registerHotel();
				break;
			case "3":
				//registerRentACar();
				break;
			case "4":
				//registerNewUser();
				break;
			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
				break;
			} 
			
		} while(!option.equals("x"));
	}

	

	private static void cenovnik() {
		{
			String option = null;
			do {
				System.out.println("Ispis menija za unos");
				System.out.println("1. Nocenje");
				System.out.println("2. Polupansion");
				System.out.println("3. Pun Pansion");
				System.out.println("4. Transfer");
				
				
				option = scanner.nextLine();
				
				switch (option) {
				case "1":
					nocenje();
					break;
				case "2":
					polupansion();
					break;
				case "3":
					punPansion();
					break;
				case "4":
					transfer();
					break;
			
				case "x":
					break;
				default:
					System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
					break;
				} 
				
			} while(!option.equals("x"));
		}
		
	}
	
	private static void nocenje() {
			// TODO Auto-generated method stub
			
		}
	private static void polupansion() {
		// TODO Auto-generated method stub
		
	}
	private static void punPansion() {
		// TODO Auto-generated method stub
		
	}
	private static void transfer() {
			// TODO Auto-generated method stub
			
		}
	

	

	private static void prihod() {
		{
			{
				String option = null;
				do {
					System.out.println("Ispis menija za unos");
					System.out.println("1. Nedeljni");
					System.out.println("2. Mesecni");
					System.out.println("3. Godisnji");
					
					
					
					option = scanner.nextLine();
					
					switch (option) {
					case "1":
						//NedeljniPrihod();
						break;
					case "2":
						//MesecniPrihod();
						break;
					case "3":
						//GodisnjiPrihod();
						break;
					
				
					case "x":
						break;
					default:
						System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
						break;
					} 
					
				} while(!option.equals("x"));
			}
			
		}
		
	}

	private static void izvestaj() {
		// TODO Auto-generated method stub
		
	}

	private static void ocene() {
		// TODO Auto-generated method stub
		
	}

	private static void sobe() {
		// TODO Auto-generated method stub
		
	}

}
