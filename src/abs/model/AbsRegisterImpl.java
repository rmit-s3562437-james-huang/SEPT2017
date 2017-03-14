package abs.model;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;

public class AbsRegisterImpl{
	
	//Name
	//username
	//password
	//address
	//phone

	private static final String FILENAME = "file path";
	
	public static void main(String[] args){
	
		
	System.out.println ("Enter enter your Name, username, password, address, phone number");
	Scanner sc = new Scanner(System.in);
	
	String name = sc.next(), username = sc.next(), password = sc.next(), address = sc.next(), phone = sc.next();
	
	
		//reader
	
	try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
		
		String sCurrentLine;
		
		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
		}
		
	} catch (IOException e) {
		e.printStackTrace();	
	
	//BufferedReader br = null;
	//FileReader fr = null;
	
		//writer
	FileOutputStream fop = null;
	File file;
	//String x = "customer x";
	
	try {
		file = new File("c:/customerInfo.txt");
		fop = new FileOutputStream(file);
		
		//create new file if !=0
		if (!file.exists()){
			file.createNewFile();
		}
		
		byte[] contentInBytes = content.getBytes();
		
		fop.write(contentInBytes);
		fop.flush();
		fop.close();
		
		System.out.println("Accepted");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
		//validation
	
	
	
	/*try {
		
		fr = new FileReader("file address");
		br = new BufferedReader(fr);
		
		String sCurrentLine;
		
		br = new BufferedReader(new FileReader(customerinfo.txt));
		
		//readfile
		while ((sCurrentLine = br.readLine() != null)) {
			System.out.println(scurrentLine);
		}
		
		
	} catch (IOException e){
		
		
		
	}*/	
	
	}
	
}