package addressBook3;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Entry> addressBook = new ArrayList<>();
	
	public static void main(String[] args) {

		boolean start = true;
		
		
		while (start) {
			int choice = displayOptions();
			
			switch(choice) {
				case 1: 
					System.out.println(addEntry());
					break;
				case 2: 
					System.out.println(removeEntry());
					break; 
				case 3: 
					System.out.println(searchEntry());
					break;
				case 4: 
					printBook();
					break; 
				case 5: 
					deleteBook();
					break; 
				case 6:
					System.out.println("Bye bye");
					start = false;
					break;
				default: 
					System.out.println("The input did not match the one of the choices available");
					break;
				}
			}
		}
	public static int displayOptions() {
		
		System.out.println("What would you like to do with this address book?");
		System.out.println("1) Add an entry");
		System.out.println("2) Remove an entry");
		System.out.println("3) Search for a specific entry");
		System.out.println("4) Print Address Book");
		System.out.println("5) Delete Book");
		System.out.println("6) Quit");
		System.out.println("Please choose what you'd like to do with the database by entering the associated integer: ");
		

		int input = scan.nextInt(); 
		
		return input;
	}
	
	public static String addEntry() {
		
		System.out.print("First Name: ");
		String firstName = scan.next();
		
		System.out.print("Last Name: ");
		String lastName = scan.next();
		
		System.out.print("Phone Number: ");
		String phoneNumber = scan.next();
		
		System.out.print("Email Address: ");
		String emailAddress = scan.next();
		
		
		Entry newEntry = new Entry(firstName, lastName, phoneNumber, emailAddress);
		addressBook.add(newEntry);
		
		return "Added new entry: \n" + newEntry.toString();
	}
	
	public static String removeEntry() {
		System.out.println("Enter an email associated with the entry you wish to remove: ");
		String emailInput = scan.next();
		
		int i = 0;
		for(Entry entry : addressBook) {
			if (emailInput.equals(entry.getEmailAddress())) {
				addressBook.remove(i);
				return "Removed entry with email: \n" + emailInput;
			}
			i++;
		}
		return "Address not found";
		
	}
	
	public static String searchEntry() {
		System.out.println("1) Enter an email associated with an entry you would like to search: ");
		String search = scan.next();
		
		for(Entry entry : addressBook) {
			if (search.equals(entry.getEmailAddress())) {
				return entry.toString();
			}
		}
		return "Address not found";
		
	}
	
	public static void printBook() {
		int i = 0;
		if(!addressBook.isEmpty()) {
			for(i = 0; i < addressBook.size(); i++) {
				System.out.println(addressBook.get(i));
			}
		}
		else {
			System.out.println("Address book is empty");
		}
	}
	
	public static void deleteBook() {

		if(!addressBook.isEmpty()) {
			addressBook.clear();
			System.out.println("Address book was cleared");
				
		}
		else {
			System.out.println("Uh oh");
		}
		
	}
	
	
	

}
