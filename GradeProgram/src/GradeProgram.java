import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GradeProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer nbrStudents = 0;  //holds number of students to grade
		String studentName = "";  //holds name of student
		String studentGrades = "";  //holds grades for that student
		Map<String, String> mapStudentGrades = new HashMap();  //holds map of students and their grades

		GetNumberOfStudents();  //gets number of students
		Scanner reader = new Scanner(System.in);
		nbrStudents = Integer.parseInt(reader.nextLine());

		for (int i = 1; i <= nbrStudents; i++) {
		//loop to get input for the each of the students request.
			
			GetStudentName(i);
			studentName = reader.nextLine();

			GetStudentGradesList(studentName);
			studentGrades = reader.nextLine();

			mapStudentGrades.put(studentName, studentGrades); //add student and their grades to the map
		}
		
		PrintStudentAverage(mapStudentGrades); //routine that prints out the student average
		
	
		reader.close(); //closes scanner

	}

	public static void GetNumberOfStudents() {

		System.out.println("Welcome to the Grade Program!");
		System.out.println("How many students and grades will you be evaluating?");
	}

	public static void GetStudentName(int nextStudent) {
		//prints request for input to the scrren

		if (nextStudent == 1) {
			System.out.println("What is the name of the student?");
		} else {
			//if more than one student add the word next
			System.out.println("What is the name of the next student?");
		}
	}

	public static void GetStudentGradesList(String studentName) {
		//prints request for the grades to the screen

		System.out.println("Enter the grades for " + studentName + " in a comma-delimited list:");

	}

	public static void PrintStudentAverage(Map<String, String> myMap) {
		//prints the student name and average to the screen
		//after calling routing that calculates it
		
		Double average;
		String studentName = "";
		Map<String, Double> mapStudentGradesAverages = new HashMap(); //map to hold student + average

		mapStudentGradesAverages = CalculateStudentAverage(myMap);
		//calls method that calculates the average
		
		ArrayList<String> names = new ArrayList<String>(mapStudentGradesAverages.keySet());
		//gets the key list for the map of grade averages

		for (int i = 0; i < names.size(); i++) {
			//loop for each student in array
			studentName = names.get(i);  //gets student name
			average = mapStudentGradesAverages.get(studentName);  //gets average for the student
			// average = myMap.get(studentName);
			System.out.println(studentName + "'s average is: " + average);
		}

	}

	public static Map<String, Double> CalculateStudentAverage(Map<String, String> myMap) {
		//calculates the average for each student and returns the average and student name in a map.
		Double average;
		String studentName = "";
		ArrayList<String> names = new ArrayList<String>(myMap.keySet());
		Map<String, Double> mapStudentGradeAverages = new HashMap();

		for (int i = 0; i < names.size(); i++) {
			//loops through the map of students and grade to get student name and average.
			//assigns name an avergage to another Map
			studentName = names.get(i);
			average = GetAverage(myMap.get(studentName));
			mapStudentGradeAverages.put(studentName, average);
		}

		return mapStudentGradeAverages;

	}

	public static double GetAverage(String myGrades) {
		//changes a string of grades to an array of doubles
		//calculates the average of the grades
		Double[] arraydblGrades;
		String[] strGrades;
		double dblAverage = 0;

		myGrades.replace(" ", ""); //removes any spaces in the string.
		

		strGrades = myGrades.split(",");  //splits the string into an array of strings for each grade

		arraydblGrades = new Double[strGrades.length]; //creates double array size of string array. 

		for (int i = 0; i < strGrades.length; i++) {
			//loops through string to add grade to double array.

			arraydblGrades[i] = Double.parseDouble(strGrades[i]);

		}

		dblAverage = average(arraydblGrades); //calls method that calculates the average. 
		return dblAverage;
	}

	public static double average(Double[] myDblArray) {
		//calculates the average for an array of numbers. 

		double dblAverage = 0;

		for (int i = 0; i < myDblArray.length; i++) {

			dblAverage = dblAverage + myDblArray[i];
		}

		return (dblAverage / myDblArray.length);
	}

}
