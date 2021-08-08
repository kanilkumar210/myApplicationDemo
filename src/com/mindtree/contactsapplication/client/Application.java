package com.mindtree.contactsapplication.client;

import java.util.Scanner;

import com.mindtree.contactsapplication.entity.Student;
import com.mindtree.contactsapplication.service.ServiceContact;

public class Application {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of Contacts");
		int noOfContacts = sc.nextInt();
		Student[] contacts = new Student[noOfContacts];
		for (int i = 0; i < noOfContacts; i++) {
			System.out.println("Enter the Contact Id");
			int id = sc.nextInt();
			System.out.println("Enter the Contact Name");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Enter the Contact Number");
			long number = sc.nextLong();
			contacts[i] = new Student(id, name, number);
		}

		int choice = 0;
		ServiceContact service = new ServiceContact();
		do {
			displayMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				displayContacts(contacts);
				break;
			case 2:
				Student[] sortedContacts = service.sortContacts(contacts);
				displaySortedContacts(sortedContacts);
				break;
			case 3:
				System.out.println("Enter Name of Contact");
				sc.nextLine();
				String name = sc.nextLine();
				int position = service.searchToFindPosition(contacts, name);
				if (position >= 0)
					System.out.println("Element Position is :" + position);
				else
					System.out.println("Element not found");
				break;
			case 4:
				System.out.println("Enter the Contact Id");
				int id = sc.nextInt();
				System.out.println("Enter the new Contact number");
				long number = sc.nextLong();
				service.updateContactNumber(contacts, id, number);
				break;
			case 5:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid Operation");
			}

		} while (choice != 5);

	}

	private static void displayMenu() {
		System.out.println("1 :Display all the contacts");
		System.out.println("2 :Display Sorted Contacts");
		System.out.println("3 :Display Position of Contact");
		System.out.println("4 :Update the Contact Number");
		System.out.println("5 :Exit");
		System.out.println("Enter the choice!!!");
	}

	private static void displaySortedContacts(Student[] sortedContacts) {
		for (int i = 0; i < sortedContacts.length; i++) {
			System.out.println("Contact Id :" + sortedContacts[i].getId() + ", Contact Name :"
					+ sortedContacts[i].getName() + ", Contact Number :" + sortedContacts[i].getNumber());
		}

	}

	private static void displayContacts(Student[] contacts) {
		for (int i = 0; i < contacts.length; i++) {
			System.out.println("Contact Id :" + contacts[i].getId() + ", Contact Name :" + contacts[i].getName()
					+ ", Contact Number :" + contacts[i].getNumber());
		}
	}
}
