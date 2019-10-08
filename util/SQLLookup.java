package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SQLLookup {

	private String server;
	private String username;
	private String password;
	
	public SQLLookup(String server, String username, String password) {
		this.server = server;
		this.username = username;
		this.password = password;
	}
	
	public void getWeapon(String s) {
		try {
			Connection con = DriverManager.getConnection(server,username,password);
			Statement stmt = con.createStatement();
			s = "'" + s + "'";
			String query = "select * from weapon where Name = " + s;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			System.out.println(rs.getString("Name"));
			System.out.println(rs.getInt("Damage"));
			System.out.println(rs.getBoolean("DualWield"));
			con.close();
		}catch(Exception e){System.out.println(e);}
	}

	public void addWeapon(String s, int damage, int speed, boolean dualWield){
		try {
			Connection con = DriverManager.getConnection(server,username,password);
			Statement stmt = con.createStatement();
			String query = "Insert Into Weapon Values('" + s + "'," + damage + "," + speed + "," + dualWield + ")";
			stmt.executeUpdate(query);
		}catch(Exception e){System.out.println(e);}
	}
	
	public void removeWeapon(String s){
		try {
			Connection con = DriverManager.getConnection(server,username,password);
			Statement stmt = con.createStatement();
			String query = "Delete from Weapon where name = '" + s + "'";
			stmt.executeUpdate(query);
		}catch(Exception e){System.out.println(e);}
	}
	
	public void getArmor(String s) {
		try {
			Connection con = DriverManager.getConnection(server,username,password);
			Statement stmt = con.createStatement();
			s = "'" + s + "'";
			String query = "select * from armor where Name = " + s;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			System.out.println(rs.getString("Name"));
			System.out.println(rs.getInt("Def"));
			System.out.println(rs.getInt("Agi"));
			System.out.println(rs.getString("type"));
			con.close();
		}catch(Exception e){System.out.println(e);}
	}
	
	public void addArmor(String s, int def, int agi, String type){
		try {
			Connection con = DriverManager.getConnection(server,username,password);
			Statement stmt = con.createStatement();
			String query = "Insert Into armor Values('" + s + "'," + def + "," + agi + ",'" + type + "')";
			stmt.executeUpdate(query);
		}catch(Exception e){System.out.println(e);}
	}
	
	public void removeArmor(String s){
		try {
			Connection con = DriverManager.getConnection(server,username,password);
			Statement stmt = con.createStatement();
			String query = "Delete from armor where name = '" + s + "'";
			stmt.executeUpdate(query);
		}catch(Exception e){System.out.println(e);}
	}
	
	
	
}
