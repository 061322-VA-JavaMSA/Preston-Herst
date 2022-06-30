package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.DBConnection;

public class SystemPostgres {

	public static void updateToOwned(int carsid, int customerid) throws SQLException {
		
		Connection conn = DBConnection.getSQLConnection();
		PreparedStatement ps;
		String user = OffersPostgres.retrieveOfferUsername(carsid, customerid);
		String ownedCar = "INSERT INTO carsowned VALUES(?, ?)";
		
		ps = conn.prepareStatement(ownedCar);
		ps.setString(1, user);
		ps.setInt(2, carsid);
		ps.execute();
	}
	
	public static void rejectOtherOffers(int carsid, int customerid) throws SQLException {
		
		String user = OffersPostgres.retrieveOfferUsername(carsid, customerid); 
		String reject = "UPDATE offers set status = (?) where carid = (?) and username != (?)";
		
		Connection conn = DBConnection.getSQLConnection();
		PreparedStatement ps = conn.prepareStatement(reject);
		ps.setString(1, "Rejected");
		ps.setInt(2, carsid);
		ps.setString(3, user);
		ps.execute();
	}
	
}
