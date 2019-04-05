
public class LicenseProgram {

	public static void main(String[] args) {
		//this section is main driver of the program
		//it instantiates 3 objects of class DriversLicense
		
		DriversLicense dlMom  = new DriversLicense();
		DriversLicense dlDad = new DriversLicense();
		DriversLicense dlMe = new DriversLicense();
		
		//for each the 3 objects the attribute are set
		dlMom.firstName = "Janice";
		dlMom.lastName = "Parnell";
		dlMom.gender = Gender.FEMALE;  //uses fancy dancy enum
		dlMom.heightInInches = 63;
		dlMom.DOB = "03/17/1943";
		
		dlDad.firstName = "William";
		dlDad.lastName = "Parnell";
		dlDad.gender = Gender.MALE;
		dlDad.heightInInches = 74;
		dlDad.DOB = "01/05/1938";
		
		dlMe.firstName = "Patricia";
		dlMe.lastName = "Parnell";
		dlMe.gender = Gender.FEMALE;
		dlMe.heightInInches = 65;
		dlMe.DOB = "03/28/1968";
		
		//prints out each drivers license along with calculated age. 
		System.out.println("Name: " + dlMom.getFullName() + " Age: " + dlMom.getAge() );
		System.out.println("Name: " + dlDad.getFullName() + " Age: " + dlDad.getAge());
		System.out.println("Name: " + dlMe.getFullName() + " Age: " + dlMe.getAge());
		
		

	}

}
