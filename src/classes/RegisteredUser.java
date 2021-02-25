package classes;

public class RegisteredUser extends User{
	
	public RegisteredUser(String username, String password, String firstName, String lastName, String email) {
		super(username, password, firstName, lastName, email, Role.REGISTERED_USER);
	
	}

}
