package databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import fileutility.FileUtility;

public class DataBaseUtility {

	Connection conn = null;
	Statement stat = null;

	public void getDatabaseConnection() throws Throwable {
		try {
			FileUtility flib = new FileUtility();
			String DBurl = flib.getDataFromPropertiesFiles("DBurl");
			String DBusername = flib.getDataFromPropertiesFiles("DBusername");
			String DBpassword = flib.getDataFromPropertiesFiles("DBpassword");
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(DBurl, DBusername, DBpassword);
			stat = conn.createStatement();
		} catch (Exception e) {
		}
	}

	public ResultSet getExeceuteQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
			result = stat.executeQuery(query);
		} catch (Exception e) {
		}

		return result;
	}

	public int getExecuteUpdate(String query) throws Throwable {
		int result = 0;
		try {
			result = stat.executeUpdate(query);
		} catch (Exception e) {
		}

		return result;
	}

	public void getConnectionClose() {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

}
