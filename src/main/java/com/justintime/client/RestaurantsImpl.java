/**
 * 
 */
package com.justintime.client;

import com.justintime.model.Restaurants;

/**
 * @author Sagnik
 *
 */
public class RestaurantsImpl extends Restaurants {

	/**
	 * @param resId
	 * @param resName
	 * @param regNo
	 * @param status
	 * @param address
	 * @param email
	 * @param password
	 */
	public RestaurantsImpl(int resId, String resName, String regNo, String status, String address, String email,
			String password) {
		super(resId, resName, regNo, status, address, email, password);
		// TODO Auto-generated constructor stub
	}
	
	public void welcome() {
		
	}

}
