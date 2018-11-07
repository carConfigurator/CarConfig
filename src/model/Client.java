package model;

public class Client {

	// Atributos de la clase:
	private String name, first_last_name, second_last_name, address, email, gender, birthdate;
	
	public Client(String name, String first_last_name, String second_last_name, String address, String email, String gender) {
		this.name = name;
		this.first_last_name = first_last_name;
		this.second_last_name = second_last_name;
		this.address = address;
		this.email = email;
		this.gender = gender;
		this.birthdate = null;
	}

	public Client(String name, String first_last_name, String second_last_name, String address, String email, String gender, String birthdate) {
		this.name = name;
		this.first_last_name = first_last_name;
		this.second_last_name = second_last_name;
		this.address = address;
		this.email = email;
		this.gender = gender;
		this.birthdate = birthdate;
	}
	
	public Client() {
		this.name = "";
		this.first_last_name = "";
		this.second_last_name = "";
		this.address = "";
		this.email = "";
		this.gender = "Desconocido";
		this.birthdate = null;
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
	
	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return name + ", " + first_last_name + ", " + second_last_name + ", " + address + ", " + email + ", " + gender + ", " + birthdate;
	}

	
	
	
	
}
