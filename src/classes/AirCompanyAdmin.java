package classes;

public class AirCompanyAdmin extends User{

	public AirCompanyAdmin(String username, String password, String firstName, String lastName, String email) {
		super(username, password, firstName, lastName, email, Role.AIRCOMPANY_ADMIN);
	}
	
	
}
