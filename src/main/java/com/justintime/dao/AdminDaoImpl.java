/**
 * 
 */
package com.justintime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.justintime.client.Admin;
import com.justintime.db.dbConnect;

/**
 * @author Sagnik
 *
 */
public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin login(String u, String P) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from administrator where userName = ? and pass = ?");
			ps.setString(1, u);
			ps.setString(2, P);
			ResultSet r = ps.executeQuery();
			if(r.next()) {
				Admin a = new Admin(r.getInt(1),r.getString(2),r.getString(3),r.getString(4));
				return a;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNew(String u, String P, String n) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into administrator(userName,pass,adminName) "
					+ "values(?,?,?)");
			ps.setString(1, u);
			ps.setString(2, P);
			ps.setString(3, n);
			return ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
