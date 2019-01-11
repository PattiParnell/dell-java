import java.util.Scanner;

public class Stats {

	public static void main(String[] args) {
		Double [] arraydblNbr ;
		String strNumbers = ""; 
		
		
		// TODO Auto-generated method stub
		System.out.println("Welcome to the statistical analysis calculator!");
		System.out.println("Enter in a list of numbers separated by a comma:  ");
		Scanner reader = new Scanner(System.in);
		
		strNumbers = reader.nextLine();
		
		arraydblNbr =  createMyDblArray(strNumbers);

		calculate(arraydblNbr);
				
		reader.close();

	}
	
	public static Double[] createMyDblArray(String myStrNumbers) {
		Double [] arraydblNbr ;
		String[] strStatsNbrs ;
		myStrNumbers.replace(" ", "");
		
		strStatsNbrs = myStrNumbers.split(",");
		
		arraydblNbr = new Double [strStatsNbrs.length];
		
		for (int i = 0; i < strStatsNbrs.length; i++) {
			
			arraydblNbr[i] = Double.parseDouble(strStatsNbrs[i]);
			//System.out.println("Your first number is: " + arraydblNbr[i]);
		}
		
		return arraydblNbr;
		}
	
	public static void calculate (Double[] myDblArray ) {
		
		double dblMin = 0.0;
		double dblMax = 0.0;
		double dblAverage = 0.0;
		double dblSum = 0.0;
		double dblCount = 0.0;
		
		dblMin = min(myDblArray);
		dblMax = max(myDblArray);
		dblAverage = average(myDblArray);
		dblSum = sum(myDblArray);
		dblCount = myDblArray.length;
		
		System.out.println("The mininum value is: " + dblMin);
		System.out.println("The max value is: " + dblMax);
		System.out.println("The average value is: " + dblAverage);
		System.out.println("The sum of the numbers entered is: " + dblSum);
		System.out.println("The number of values you entered is: " + dblCount);
		
	}
	public static double min (Double[] myDblArray) {
		double dblIsMin ;
				
		dblIsMin = 	myDblArray [0]; //setting it to first value of array to have a mark
				
		for (int i = 0 ; i < myDblArray.length; i++ ) {
			
			if ( dblIsMin > myDblArray[i]) {
				dblIsMin = myDblArray[i];
			}
		}
	
		
		return dblIsMin;
	}
	
	public static double max (Double[] myDblArray) {
		double dblIsMax ;
				
		dblIsMax = 	myDblArray [0]; //setting it to first value of array to have a mark
				
		for (int i = 0 ; i < myDblArray.length; i++ ) {
			
			if ( dblIsMax < myDblArray[i]) {
				dblIsMax = myDblArray[i];
			}
		}
	
		
		return dblIsMax;
	}
	
	public static double average (Double[] myDblArray) {

		double dblAverage = 0;
				
						
		for (int i = 0 ; i < myDblArray.length; i++ ) {
			
			dblAverage = dblAverage + myDblArray[i];
		}
	
		
		return (dblAverage/myDblArray.length);
	}

	public static double sum (Double[] myDblArray) {
		double dblSum = 0;
				
						
		for (int i = 0 ; i < myDblArray.length; i++ ) {
			
			dblSum = dblSum + myDblArray[i];
		}
	
		
		return dblSum;
	}
	
}
