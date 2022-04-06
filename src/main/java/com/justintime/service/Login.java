package com.justintime.service;

import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Logger;

import com.justintime.client.Admin;
import com.justintime.client.CustomerImpl;
import com.justintime.client.RestaurantsImpl;
import com.justintime.dao.SignUpDao;
import com.justintime.dao.SignUpDaoImpl;
import com.justintime.dao.AdminDao;
import com.justintime.dao.AdminDaoImpl;
import com.justintime.dao.LoginDao;
import com.justintime.model.Administrator;
import com.justintime.model.Customer;
import com.justintime.model.Restaurants;

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
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		
		logger.info("Within Login page");
		System.out.println("Welcome!");
		
		Login login = new Login();
		
		while(true) {
			System.out.println("Who are you?");
			System.out.println("1. Customer Sign in");
			System.out.println("2. Resturant Owner Sign in");
			System.out.println("3. New Customer Registration");
			System.out.println("4. New Registration Registration");
			System.out.println("5. System Admin");
			
			int c = Integer.parseInt(sc.nextLine());
			
			switch(c) {
			case 1:
				logger.info("Customer Login initiated");
				login.getId();
				LoginDao lc = new LoginDao();
				ResultSet rs = lc.customerCheck(login.email,login.password);
				if(rs.next()) {
					int id = rs.getInt("userId");
					String name = rs.getString("userName");
					String address = rs.getString("userAddress");
					int number = rs.getInt("userNumber");
					CustomerImpl cst = new CustomerImpl(id,name,address,number);
					logger.info("Going in to CustomerImpl.Java file");
					cst.welcome();
				}
				else {
					logger.info("Wrong password entered by Customer");
					System.out.println("Wrong  Email and/or Password");
				}
				break;
			case 2:
				logger.info("Resturant Login initiated");
				login.getId();
				LoginDao lr = new LoginDao();
				ResultSet rr = lr.restaurantCheck(login.email,login.password);
				if(rr.next()) {
					int resId = rr.getInt("resId");
					String name = rr.getString("resName");
					String regNo = rr.getString("resRegNo");
					String status = rr.getString("resStatus");
					String address = rr.getString("resAddress");
					String email = rr.getString("resEmail");
					String pass = rr.getString("resPassword");
					RestaurantsImpl rst = new RestaurantsImpl(resId,name,regNo,status,address,email,pass);
					logger.info("Going in to RestaurantsImpl.Java file");
					rst.welcome();
					
				}
				else {
					logger.info("Wrong password entered by Restaurant");
					System.out.println("Wrong  Email and/or Password");
				}
				break;
			case 3:
				logger.info("New Customer Creation initiated");
				Customer c1 = login.getCustomer();
				SignUpDao su = new SignUpDaoImpl();
				if(su.customer(c1)) {
					logger.info("Successfylly added new  Customer");
					System.out.println("Account created successfully! \nNow LogIn to access your account!");
				}
				else {
					logger.severe("Error occoured while Customer account creation");
					System.out.println("Sorry! We couldn't create your account now!\nTry again later");
				}
				break;
			case 4:
				logger.info("New Restaurant Creation initiated");
				Restaurants r1 = login.getRes();
				SignUpDao su1 = new SignUpDaoImpl();
				if(su1.restaurant(r1)) {
					logger.info("Successfylly added new  Restaurant");
					System.out.println("Account created successfully! \nNow LogIn to access your account!");
				}
				else {
					logger.severe("Error occoured while Restaurant account creation");
					System.out.println("Sorry! We couldn't create your account now!\nTry again later");
				}
				break;
			case 5:
				logger.info("Administrator Login initiated");
				Admin a = login.getAdm();
				System.out.println("This section is under Construction!");
				System.out.println("We will be open shortly!");
				break;
			default:
				sc.close();
				System.out.println("Thank you for using our Service!");
				System.exit(0);
				
			}
				
			
		}
		
	}
	
	private void getId() {
		logger.info("Getting email and password");
		System.out.println("Enter your Email: ");
		this.email = sc.nextLine();
		System.out.println("Enter your Password: ");
		this.password = sc.nextLine();
		logger.info("Got email and password. Now validating details");
	}
	
	private Customer getCustomer() {
		logger.info("Creating new Customer");
		System.out.println("Welcome to Food Delivery Services!");
		System.out.println("We deliver Hot and Fresh Foods from your fav Restaurants directly to your Doorstep");
		System.out.println("To use our services you need an account!");
		System.out.println("So first tell us who you are (Your Name)?");
		String name = sc.nextLine();
		System.out.println("Your Email address Please!");
		String email =sc.nextLine();
		System.out.println("Where should we deliver your Favourite food items (your address) ?");
		String address = sc.nextLine();
		System.out.println("Create a secret password for your account:");
		String pass = sc.nextLine();
		System.out.println("Your Phone number Please!");
		int number = sc.nextInt();
		System.out.println("How old are you? \nYou should be 13+ to use our services!");
		int age = sc.nextInt();
		
		Customer newCst = new Customer(0,age,name,address,email,pass,number);
		System.out.println("Thank you for choosing our Food Delivery System!");
		System.out.println("We are happy to have you on Board!");
		return newCst;
		
	}
	
	private Restaurants getRes() {
		logger.info("Creating new Restaurant");
		System.out.println("Welcome to Food Delivery Services!");
		System.out.println("We deliver Hot and Fresh Foods from Restaurants, like yours, directly to your Customers");
		System.out.println("This helps your bussiness to grow and reach a larger Customer range");
		System.out.println("To make use our services you need an account!");
		System.out.println("So first tell us what's Your Resturant Name?");
		String resName = sc.nextLine();
		System.out.println("Your Registration Number please!");
		String regNo = sc.nextLine();
		System.out.println("Your Restaurant location");
		String address = sc.nextLine();
		System.out.println("Enter your Email address");
		String email = sc.nextLine();
		System.out.println("Create a secure Password");
		String pass =sc.nextLine();
		
		Restaurants r = new Restaurants(0,resName,regNo,"active",address,email,pass);
		return r;
		
		
	}
	
	private Admin getAdm() {
		logger.info("Taking Admin details");
		System.out.println("Enter your User Name:");
		String u = sc.nextLine();
		System.out.println("Enter your Password");
		String p = sc.nextLine();
		AdminDao ad = new AdminDaoImpl();
		return ad.login(u, p);
	}

}
