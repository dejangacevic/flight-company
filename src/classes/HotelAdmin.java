package classes;

public class HotelAdmin extends User{
	
	public HotelAdmin(String username, String password, String firstName, String lastName, String email) {
		super(username, password, firstName, lastName, email, Role.HOTEL_ADMIN);
	}

}
