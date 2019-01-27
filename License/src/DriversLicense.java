
public class DriversLicense {
	//this attributes and methods for the class DriversLicense
	
	//list of attributes
	public String firstName;
	public String lastName;
	public String DOB;
	public float heightInInches;
	public Gender gender;
	
	
	//this is the constructor fir the class
	public DriversLicense()
	{
		
	}
	
	//setters and getters for the class
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public float getHeightInInches() {
		return heightInInches;
	}


	public void setHeightInInches(float heightInInches) {
		this.heightInInches = heightInInches;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender myGender) {
		gender = myGender;
	}


	//method for the class
	public String getFullName ()
	{ 
		//method returns concatenated  first and last name
		return (firstName.trim() + " " + lastName.trim());
	}
	
	public int getAge ()
	{
		//method returns age  age based on birth date

		 
		
		return calculateAge(); 
	}
	
	public int calculateAge () {
		int Age = 21;
		
		return Age;

		
	}
	
	
	
}
