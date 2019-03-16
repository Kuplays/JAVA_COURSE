package Linker;

import java.sql.*;
import java.util.*;

public class Base {
	private static List<Link> links;

	public Base() {
		this.links = new ArrayList<Link>();
	}

	public static List<Link> getLinks() {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:base.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Links");

			while(rs.next()) {
				String date = rs.getString("linkDate");
				System.out.println(date);
				String actualLink = rs.getString("linkActualLink");
				String author = rs.getString("linkAuthor");

				links.add(new Link(date, actualLink, author));
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception ex) {
			System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
			System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
		}

		return links;
	}
}