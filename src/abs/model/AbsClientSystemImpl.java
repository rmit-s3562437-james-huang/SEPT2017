package abs.model;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

import abs.model.interfaces.ClientSystem;
import abs.model.users.Customer;
import abs.view.AbsTest;

public class AbsClientSystemImpl implements ClientSystem {
	
	Logger LOGGER = Logger.getLogger(AbsClientSystemImpl.class.getName());
	
	@Override
	public void registerCustomer(HashMap<String, Customer> map) {
		
		Scanner scan = new Scanner(System.in);
		String name, userName, password, address, phoneNumber;
		
		boolean valid = false;
		
		do {
			System.out.println("Please enter your desired username:");
			userName = scan.nextLine();
			if(map.containsKey(userName) || userName.equals("")) {
				System.out.println("That username has already been taken by another user.");
				System.out.println("Please enter another one");
				userName = "";
			}
			else {
				valid = true;
			}
		} while(valid == false);
		
		valid = false;
		
		do {
			System.out.println("Please enter your desired password:");
			password = scan.nextLine();
			
			if(validPassword(password)) {
				valid = true;
			}
			
		} while (valid == false);
		
		valid = false;
		
		do {
			System.out.println("Please enter your first name:");
			name = scan.nextLine();
			
			if(validName(name)) {
				valid = true;
			}
			
		} while (valid == false);
		
		valid = false;
		
		do {
			System.out.println("Please enter your address:");
			address = scan.nextLine();
			
			if(validAddress(address)) {
				valid = true;
			}
			
		} while(valid == false);
		
		valid = false;
		
		do {
			System.out.println("Please enter your phone number:");
			phoneNumber = scan.nextLine();
			
			if(validPhoneNumber(phoneNumber)) {
				valid = true;
			}
			
		} while(valid == false);
		
		Customer newCustomer = new Customer(name, userName, password, address, phoneNumber);
		
		map.put(newCustomer.getUserName(), newCustomer);
	}
	
	@Override
	public void changeCustomerPassword(String userName, HashMap<String, Customer> map) {
		String newPassword;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a new passord:");
		newPassword = scan.nextLine();
		
		if(validPassword(newPassword)){
			map.get(userName).setUserPassword(newPassword);
		}
	}
	
	@Override
	public void printCustomerMap(HashMap<String, Customer> map) {
		for(Customer customer : map.values()) {
			System.out.println("\n==========================");
			System.out.println(customer.toString());
			System.out.println("==========================\n");
		}
	}
	
	@Override
	public void editCustomerInformation(String userName, HashMap<String, Customer> map) {
		String newName, newUser, newPass, newAddress, newPhoneNumber;
		Scanner scan = new Scanner(System.in);
		
		boolean back = false;
		int selected;
		String input;
		
		do {
			input = scan.nextLine();
			if(input.matches("[0-9]+")){
				selected = Integer.parseInt(input);
			}
			else {
				selected = 0;
			}
			
			switch(selected) {
				case 1:
					System.out.print("\nEnter new Name: ");
					newName = scan.next();
					if(validName(newName)){
						map.get(userName).setName(newName);
						System.out.println("Name has been changed!");
					}
					back = true;
					break;
				case 2:
					System.out.print("\nEnter new Address: ");
					newAddress = scan.nextLine();
					if(validAddress(newAddress)){
						map.get(userName).setUserAddress(newAddress);
						System.out.println("Address has been changed!");
					}
					back = true;
					break;
				case 3:
					System.out.print("\nEnter new Phone number: ");
					newPhoneNumber = scan.next();
					if(validPhoneNumber(newPhoneNumber)){
						map.get(userName).setUserPhoneNumber(newPhoneNumber);
						System.out.println("Phone number has been changed!");
					}
					back = true;
					break;
				case 4:
					back = true;
					break;
				default:
					System.out.println("Please choose a valid option.");
			}
		} while (!back);
	}
	
	@Override
	public boolean validUserName(String userName){
		
		if(userName.equals("") == false)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean validPassword(String password){
		
		if(password.length() >= 6 && password.matches(".*\\s+.*") == false){
			return true;
		}
		else if(password.equals("")) {
			System.out.println("Password should not be an empty string!");
		}
		else if (password.length() < 6) {
			System.out.println("Password is too short. Your password should be at least 6 characters.");
		}
		else if(password.matches(".*\\s+.*") == true) {
			System.out.println("Password contains whitespace. Your password should not contain whitespaces.");
		}
		
		return false;
	}
	
	@Override
	public boolean validName(String name){
		
		if(name.equals("") == false && name.matches(".*\\d+.*") == false) {
			return true;
		}
		else if(name.equals("")) {
			System.out.println("Your name cannot be an empty string!");
		}
		else if(name.matches(".*\\d+.*")) {
			System.out.println("Your name should not contain a number.");
		}
		else if(name.matches(".*\\s+.*")) {
			System.out.println("Your name should not contain any white spaces!");
		}
		
		return false;
	}
	
	@Override
	public boolean validAddress(String address){
		
		if(address.equals("") == false) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean validPhoneNumber(String phoneNumber){
		
		if(phoneNumber.matches(".*[a-z][A-Z].*") == false && phoneNumber.length() == 10) {
			return true;
		}
		else if(phoneNumber.matches(".*[a-z][A-Z]+.*")) {
			System.out.println("Your phone number should not contain letters!");
		}
		else if(phoneNumber.length() != 10 || phoneNumber.matches(".*\\s+.*"))
		{
			System.out.println("Please enter your phone number as without spaces.");
			System.out.println("e.g '0412345678");
		}
		
		return false;
	}
}
