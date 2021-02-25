package classes;

public class SysAdmin extends User{

	public SysAdmin(String username, String password, String firstName, String lastName, String email) {
		super(username, password, firstName, lastName, email, Role.SYS_ADMIN);
	
	}
}
