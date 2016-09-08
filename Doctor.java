/*
*@file_Name: Doctor.java
*@Author: Shwetali
*@Date: 07-09-2016
*@purpose:  Creating Doctor class for clinic management.
*/

package com.bridgelabz.clinic;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Doctor{
	Scanner sc = new Scanner(System.in);
	String name,specialization,availability;
	int id;
	public Doctor(){}//default Constructor
	//Parameterised constructor
	public Doctor(String name, int id, String specialization, String availability)
	{
		this.name = name;
		this.id = id;
		this.specialization = specialization;
		this.availability = availability;
	}
	//displaying info for single doctor
	public void printDoctor(Doctor d)
	{
		System.out.println("Name : "+d.name);
		System.out.println("ID : "+d.id);
		System.out.println("Specialization : "+d.specialization);
		System.out.println("Availability : "+d.availability +"\n");
	}

	//Displaying List of Doctors
	public void listOfDoctors(ArrayList<Doctor> doctors)
	{
		for(Doctor info : doctors)
		{
			System.out.println("Name : "+info.name);
			System.out.println("ID : "+info.id);
			System.out.println("Specialization : "+info.specialization);
			System.out.println("Availability : "+info.availability +"\n");
		}
	}

	
	//search method for Doctor
	public void searchDoctor(ArrayList<Doctor> doctors){
		System.out.println("1.Name\n2.ID\n3.Specilization\n4.Availability");
		int choice = sc.nextInt();
		switch(choice){
			case 1:{
				System.out.print("Please enter Name to Search: ");
				String nameSearch = sc.next();
				this.searchByName(doctors,nameSearch);
				break;
			}
			case 2:{
				System.out.print("Please Enter ID: ");
				int idSearch = sc.nextInt();
				this.searchById(doctors,idSearch);
				break;
			}
			case 3:{
				System.out.print("Please Enter Specilization for search: ");
				String spSearch = sc.next();
				this.searchBySpecilization(doctors,spSearch);
				break;
			}
			case 4:{
				System.out.print("Please Enter Morning or Evening: ");
				String available = sc.next();
				this.searchByAvailability(doctors,available);
				break;
			}
			default:{
				System.out.println("Entered Wrong Choice");
			}
		}//end of switch	
	}//end of searchDoctor

	//search by name
	public void searchByName(ArrayList<Doctor> doctors,String name){
		int count=0;
		for(Doctor doctor : doctors){
			if(name.equals(doctor.name)){
				this.printDoctor(doctor);
				count++;
			}
		}
		if(count==0)
			System.out.println("Sorry Doctor for given name not found");
	}

	//searching doctor by id
	public void searchById(ArrayList<Doctor> doctors,int id){
		int count=0;
		for(Doctor doctor : doctors){
			if(id == doctor.id){
				this.printDoctor(doctor);
				count++;
			}
		}
		if(count==0)
			System.out.println("Sorry Doctor for given id not found");

	}

	//searching Doctor by specilization
	public void searchBySpecilization(ArrayList<Doctor> doctors,String specialization){
		int count=0;
		for(Doctor doctor : doctors){
			if(specialization.equals(doctor.specialization)){
				this.printDoctor(doctor);
				count++;
			}
		}
		if(count==0)
			System.out.println("Sorry Doctor for given specialization not found");
	}

	//searching Doctor by availability
	public void searchByAvailability(ArrayList<Doctor> doctors,String availability){
		int count=0;
		for(Doctor doctor : doctors){
			if(availability.equals(doctor.availability)){
				this.printDoctor(doctor);
				count++;
			}
		}
		if(count==0)
			System.out.println("Sorry Doctor for given availability not found");
	}
	//To search popular doctor
	public void popularDoctor(ArrayList<Doctor> doctors){
		Random r = new Random();
		int num = r.nextInt(5);
		System.out.println("Popular Doctor in Clinic:");
		this.searchById(doctors,(num+1));
	}
}