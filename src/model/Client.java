package src.model;

public class Client {

	// Atributos de la clase:
	private String name, first_last_name, second_last_name, address, email, birthdate;
	
	public Client() {}

	public Client(String name, String first_last_name, String second_last_name, String address, String email) {
		this.name = name;
		this.first_last_name = first_last_name;
		this.second_last_name = second_last_name;
		this.address = address;
		this.email = email;
		this.birthdate = null;
	}
	
	public Client(String name, String first_last_name, String second_last_name, String address, String email, String birthdate) {
		this.name = name;
		this.first_last_name = first_last_name;
		this.second_last_name = second_last_name;
		this.address = address;
		this.email = email;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public String getFirst_last_name() {
		return first_last_name;
	}

	public String getSecond_last_name() {
		return second_last_name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}
	
	public String getBirthdate() {
		return birthdate;
	}

	@Override
	public String toString() {
		return name + ", " + first_last_name + ", " + second_last_name + ", " + address + ", " + email + ", " + birthdate;
	}

	
	
	
	
}
