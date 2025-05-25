import java.util.Scanner;

public class StudentGradeTracker {

	public static void main(String[] args) {
		
		System.out.println("Enter the number of students: ");
		Scanner sc=new Scanner(System.in);
		int numOfStudents=sc.nextInt();
		
		double [] grades= new double[numOfStudents];
		
		
		for(int i=0;i<numOfStudents;i++) {
			System.out.println("Enter grade for student "+(i+1)+":");
			 grades[i]=sc.nextDouble();
		}
		double sum=0;
		for(double grade:grades ) {
			sum+=grade;
		}
		double avg=average(sum,numOfStudents);
		double highest=highestGrade(grades,numOfStudents);
		double lowest=lowestGrade(grades,numOfStudents);
		System.out.println("---Student Results---");
		System.out.println("Average grade: "+avg);
		System.out.println("Highest grade: "+highest);
		System.out.println("Lowest grade: "+lowest);
	}
	

public static double average(double sum,int nbOfStudents) {
	return sum/nbOfStudents;
}
public static double highestGrade(double []grades,int nb) {
	double highest=grades[0];
	for(int i=0;i<nb;i++) {
		if(grades[i]>highest) {
			highest=grades[i];
		}
	}
	return highest;
}
public static double lowestGrade(double []grades,int nb) {
	double lowest=grades[0];
	for(int i=0;i<nb;i++) {
		if(grades[i]<lowest) {
			lowest=grades[i];
		}
	}
	return lowest;
}
}
