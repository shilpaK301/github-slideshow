package management_system;

import java.util.Scanner;

public class StudentDatabaseApp {
	public static void main(String[] args) {
		System.out.print("Enter number of new Student to Enroll : ");
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = sc.nextInt();
		Student[] students = new Student[numberOfStudents]; 
		for (int i=0; i< numberOfStudents ; i++){
			Student s= new Student();
			s.enroll();
			s.payTuition();
			students[i] = s;
		}
		
		System.out.println(students[0].toString());
	}

}
package management_system;

import java.util.Scanner;

public class Student {
	public enum Courses{
		History, Maths, Biology, Statistics, Geography,
		Accounts, BusinessStudies, Economics, ComputerScience, 
		BioTechnology
	}
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courseID;
	private String courses ;
	private int  tuitionBalance = 1000;
	private int costOfCourse = 600;
	private static int id=1000;
	
	
	//Constructor : prompts user to enter student name year
	public Student(){
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter Student's First Name : ");
		this.firstName= sc.nextLine();
		
		System.out.print("Enter Student's Last Name : ");
		this.lastName= sc.nextLine();
		
		System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter Student class level : ");
		this.gradeYear= sc.nextInt();
				
		setStudentID();
	}
	//generate an ID
	private void setStudentID(){
		id++;
		this.studentID = gradeYear+""+id;
	}
	
			
	//		enroll in courses
	public void enroll(){
		int a=1;
		
		while(a==1){
		Scanner sc =  new Scanner(System.in);
			System.out.print("Enter course to enroll (Q to quit) : ");
			String course = sc.nextLine();
			if(!course.equals("Q") ){
				courses = courses +"\n "+course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}else break;
		}
	}
	//  View balance
	public void viewBalance() {
		System.out.println("Your Balance is $: "+ tuitionBalance);
	}
	
	//  Pay tuition
	public void payTuition(){
		viewBalance();
		System.out.print("Enter your payment $: ");
		Scanner sc = new Scanner(System.in);
		int payment = sc.nextInt();
		if(payment>tuitionBalance)
			System.out.println("Please pay "+tuitionBalance);
		else
			tuitionBalance =tuitionBalance -payment;
		viewBalance();
	}
//			Show status
	public String toString () {
		return "Name :" + firstName +" "+ lastName +
				"\nGrade Level"+ gradeYear+
				"\nStudent ID"+ studentID+
				"\nCourses Enrolled" + courses+
				"\nBalance $"+ tuitionBalance;
	}
}
