/**
 * 
 */
package com.justintime.client;

import java.util.Scanner;
import java.util.logging.Logger;

import com.justintime.dao.AdminDao;
import com.justintime.dao.AdminDaoImpl;
import com.justintime.model.Administrator;

/**
 * @author Sagnik
 *
 */
public class Admin extends Administrator {
	private static final Logger logger = Logger.getLogger("Admin.class");
	/**
	 * @param id
	 * @param uName
	 * @param pass
	 * @param name
	 */
	public Admin(int id, String uName, String pass, String name) {
		super(id, uName, pass, name);
		// TODO Auto-generated constructor stub
	}
	Scanner sc = new Scanner(System.in);
	public void welcome() {
		logger.info("Welcome to Admin page!");
		System.out.println("Hello! " + this.getName());
		while(true) {
			System.out.println("What do you wanna do Today?");
			System.out.println("1. Add New Admin");
			
			int ch = Integer.parseInt(sc.nextLine());
			AdminDao ad  = new AdminDaoImpl();
			switch(ch) {
			case 1:
				System.out.println("Enter details of new Admin");
				System.out.println("Enter Name");
				String n = sc.nextLine();
				System.out.println("Enter Email");
				String e = sc.nextLine();
				System.out.println("Enter Password");
				String p = sc.nextLine();
				if(ad.addNew(e, p, n)) {
					logger.info("New Admin added Successfully");
					System.out.println("Success!");
				}
				else {
					logger.info("Error while adding New Admin");
					System.out.println("Sorry! Please try again later");
				}
				break;
			default:
				logger.info("Logging out");
				System.out.println("Thank You! Logging you out");
				return;
				
			}
		}
	}

}
