package com.justintime.service;

import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Logger;

import com.justintime.client.CustomerImpl;
import com.justintime.client.RestaurantsImpl;
import com.justintime.dao.loginDao;

/**
 * @author Sagnik
 *
 */
public class Login {
	
	private static final Logger logger = Logger.getLogger("Login.class");
	String email;
	String password;
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		logger.info("Within Login page");
		System.out.println("Welcome!");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Who are you?");
			System.out.println("1. Customer");
			System.out.println("2. Resturant Owner");
			System.out.println("3. System Admin");
			
			int c = Integer.parseInt(sc.nextLine());
			
			switch(c) {
			case 1:
				Login cs = new Login();
				logger.info("Customer Login initiated");
				cs.getId();
				loginDao lc = new loginDao();
				ResultSet rs = lc.customerCheck(cs.email,cs.password);
				if(rs.next()) {
					String name = rs.getString("userName");
					String address = rs.getString("userAddress");
					int number = rs.getInt("userNumber");
					CustomerImpl cst = new CustomerImpl(name,address,number);
					logger.info("Going in to CustomerImpl.Java file");
					cst.welcome();
				}
				else {
					logger.info("Wrong password entered by Customer");
					System.out.println("Wrong  Email and/or Password");
				}
				break;
			case 2:
				Login res = new Login();
				logger.info("Resturant Login initiated");
				res.getId();
				loginDao lr = new loginDao();
				ResultSet rr = lr.restaurantCheck(res.email,res.password);
				if(rr.next()) {
					int resId = rr.getInt("resId");
					String name = rr.getString("resName");
					String regNo = rr.getString("resRegNo");
					String status = rr.getString("resStatus");
					String address = rr.getString("resAddress");
					String email = rr.getString("resEmail");
					String pass = rr.getString("resPassword");
					RestaurantsImpl rst = new RestaurantsImpl(resId,name,regNo,status,address,email,pass);
					rst.welcome();
					
				}
				else {
					logger.info("Wrong password entered by Restaurant");
					System.out.println("Wrong  Email and/or Password");
				}
			}
				
			
		}
		
	}
	
	private void getId() {
		logger.info("Getting email and password");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email: ");
		this.email = sc.nextLine();
		System.out.println("Enter your Password: ");
		this.password = sc.nextLine();
		logger.info("Got email and password. Now validating details");
	}

}
