
public class Cat {
	public String color;
	public int ageInMonth;
	public String eyeColor;
	public String breed; 
	public Boolean isSleeping;
	public Boolean isPurring; 
	
	public Cat () {}
	
	
//	public Cat(String color, int ageInMonth, String eyeColor, String breed, Boolean isSleeping, Boolean isPurring) {
//		super();
//		this.color = color;
//		this.ageInMonth = ageInMonth;
//		this.eyeColor = eyeColor;
//		this.breed = breed;
//		this.isSleeping = isSleeping;
//		this.isPurring = isPurring;
//	}


	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAgeInMonth() {
		return ageInMonth;
	}
	public void setAgeInMonth(int ageInMonth) {
		this.ageInMonth = ageInMonth;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Boolean getIsSleeping() {
		return isSleeping;
	}
	public void setIsSleeping(Boolean isSleeping) {
		this.isSleeping = isSleeping;
	}
	public Boolean getIsPurring() {
		return isPurring;
	}
	public void setIsPurring(Boolean isPurring) {
		this.isPurring = isPurring;
	}
	
	public void petTheCat () {
		setIsPurring (true);
		setIsSleeping(true);
	}
	
	public void pokeTheCat() {
		setIsSleeping(false);
		
	}
	
	public void feedTheCat( ) {
		setIsPurring(true);
		setIsSleeping(false);
		
	}
	
	public void harassTheCat() {
		setIsPurring(false);
		setIsSleeping(false);
	}
	
	
	

}
