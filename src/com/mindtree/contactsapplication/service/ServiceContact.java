package com.mindtree.contactsapplication.service;

import com.mindtree.contactsapplication.entity.Student;

public class ServiceContact {

	public Student[] sortContacts(Student[] contact) {
		for (int i = 0; i < contact.length - 1; i++) {
			for (int j = 0; j < contact.length - 1; j++) {
				if (contact[j].getName().compareTo(contact[j + 1].getName()) > 0) {
					int tempId = contact[j].getId();
					String tempName = contact[j].getName();
					long tempNumber = contact[j].getNumber();
					contact[j].setId(contact[j + 1].getId());
					contact[j].setName(contact[j + 1].getName());
					contact[j].setNumber(contact[j + 1].getNumber());
					contact[j + 1].setId(tempId);
					contact[j + 1].setName(tempName);
					contact[j + 1].setNumber(tempNumber);
				}
			}
		}
		return contact;
	}

	public int searchToFindPosition(Student[] cont, String name) {
		Student[] contacts = sortContacts(cont);
		int low = 0, high = contacts.length - 1;
		while (high >= 1) {
			int mid = low + (high - low) / 2;
			int res = name.compareTo(contacts[mid].getName());
			if (res == 0) {
				return mid;
			}
			if (res > 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public Student[] updateContactNumber(Student[] contacts, int id, long number) {
		for (int i = 0; i < contacts.length; i++) {
			if (id == contacts[i].getId()) {
				contacts[i].setNumber(number);
			}
		}
		return contacts;
	}
}
