/**
 * 
 */
package com.justintime.dao;

import java.sql.ResultSet;

import com.justintime.model.Menu;

/**
 * @author Sagnik
 *
 */
public interface FoodDao {
	public int search(String name);
	public boolean add(String name);
	public boolean addmenu(Menu m);
	public ResultSet currentMenu(int id);

}
