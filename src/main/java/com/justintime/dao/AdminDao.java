/**
 * 
 */
package com.justintime.dao;

import com.justintime.client.Admin;

/**
 * @author Sagnik
 *
 */
public interface AdminDao {
	public Admin login(String u,String P);
	public boolean addNew(String u,String P,String n);
}
