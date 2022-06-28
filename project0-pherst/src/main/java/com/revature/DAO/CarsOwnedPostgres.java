package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.DBConnection;
import com.revature.BaseModels.CarsOwned;

public class CarsOwnedPostgres {

	public static List<CarsOwned> owned = null;
	
	public static void listOfCarsOwned(String username) throws SQLException{
		

		Connection cc = DBConnection.getSQLConnection();
		PreparedStatement view;
		owned = new ArrayList<CarsOwned>();
		CarsOwned co = null;
		
		try {
			String viewCarsOwned = "select customers.employeeid, carsowned.customeruser, items.caryear, items.make, items.model "
					+"FROM ((carsowned INNER JOIN customers ON carsowned.customerid = customers.employeeid) INNER JOIN items ON carsowned.carid = items.carid) "
					+ "WHERE customers.username = (?)";
			
			view = cc.prepareStatement(viewCarsOwned);
			view.setString(1, username);
			view.execute();
			
			ResultSet rs = view.executeQuery();
			
			while(rs.next()) {
				co = new CarsOwned();
				co.setCustomerid(rs.getInt("employeeid"));
				co.setUsername(rs.getString("customeruser"));
				co.setYear(rs.getString("caryear"));
				co.setMake(rs.getString("make"));
				co.setModel(rs.getString("model"));
				
				owned.add(co);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		for(int i = 0; i< owned.size(); i++) {
			System.out.println(owned.get(i));	
		}
		
		System.out.println();
		try {
			Thread.sleep(2000);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
