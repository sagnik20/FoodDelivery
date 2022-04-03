/**
 * 
 */
package com.justintime.dao;

import com.justintime.model.Customer;
import com.justintime.model.Restaurants;

/**
 * @author Sagnik
 *
 */
public interface SignUpDao {
	public boolean customer(Customer c);
	public boolean restaurant(Restaurants r);
}
