package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.DBConnection;
import com.revature.BaseModels.Offers;

public class OffersPostgres {

	public static List<Offers> offers = null;
	public static List<Offers> listOfOffers() throws SQLException {
		
		Connection cc = DBConnection.getSQLConnection();
		PreparedStatement view;
		offers = new ArrayList<Offers>();
		Offers of = null;
		
		try {
			String viewPending = "SELECT offers.username, customers.employeeid, offers.carid, items.make, items.model, offers.offer, offers.status "
				+ "FROM ((offers INNER JOIN items ON offers.carid = items.carid) INNER JOIN customers ON offers.username = customers.username) ";
			
			view = cc.prepareStatement(viewPending);
			ResultSet rs = view.executeQuery();
			
			while(rs.next()) {
				of = new Offers();
				of.setUsername(rs.getString("username"));
				of.setEmployeeid((rs.getInt("employeeid")));
				of.setCarid(rs.getInt("carid"));
				of.setMake(rs.getString("make"));
				of.setModel(rs.getString("model"));
				of.setOffer(rs.getInt("offer"));
				of.setStatus(rs.getString("status"));
				
				offers.add(of);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
		}
	
	public static void viewAllOffers() throws SQLException {
		Connection c = DBConnection.getSQLConnection();
		offers = listOfOffers();
		for(int i = 0; i< offers.size(); i++) {
			System.out.println(offers.get(i));
		}	
	}
	public static void addOffer(String user, int carid, int customeroffer) throws SQLException {
		
		Connection c = DBConnection.getSQLConnection();
		String status = "Pending";
		PreparedStatement ps;
		String newOffer = "insert into offers(username, carid, offer, status) values (?, ?, ?, ?)";
		
		ps = c.prepareStatement(newOffer);
		ps.setString(1,user);
		ps.setInt(2, carid);
		ps.setInt(3, customeroffer);
		ps.setString(4, status);
		ps.execute();	
	}
}
