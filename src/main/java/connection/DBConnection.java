package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	public static boolean startMigration(){
		java.sql.Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://134.106.3.242:5432/zuse", "alamm", "2uE7ECsKal"); // OFFIS
			// c =
			// DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5555/zuse",
			// "alamm", "2uE7ECsKal"); // SSH
			c.setAutoCommit(false);

			System.out.println("Opened database successfully");
			java.sql.Statement stmt = c.createStatement();
			String sql = "";
			try {
				if (!sql.equals("")) {
					stmt.executeUpdate(sql);
					stmt.close();
					c.commit();
				}
			} catch (Exception e) {
				System.out.println("Database Write failed!");
				e.printStackTrace();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		try {
			c.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
