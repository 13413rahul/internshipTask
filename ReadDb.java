import java.sql.*;

// it is not clear some data in already contains or not 
// so i am assuming some data in db contains

class ReadDb {
    static Connection con = null;
	static PreparedStatement prepareStatement = null;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Emp";
        String user = "root";
        String password = "root";
 
		try {
			System.out.println("make JDBC connection to MySQL DB");
			makeJDBCConnection(url, user, password);
 
			System.out.println("\nLet's get Data from DB");
			getDataFromDB();
 
			con.close();
			prepareStatement.close();
 
		} catch (SQLException e) {
            System.out.println(e);
		}
    }

     
	private static void makeJDBCConnection(String url, String user, String password) {
 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver");
			return;
		}
 
		try {
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Connection Successful!");
			} else {
				System.out.println("Failed to make connection!");
			}
		}catch (SQLException e) {
            System.out.println("MySQL Connection Failed!");
			return;
		}
 
	}

    private static void getDataFromDB() {
 
		try {

			String getQueryStatement = "select * from test";
 
			prepareStatement = con.prepareStatement(getQueryStatement);
 
			ResultSet resultsSet = prepareStatement.executeQuery();

            System.out.println("name\t\tage");

			while (resultsSet.next()) {
                String name = resultsSet.getString("name");
                int age = resultsSet.getInt("age");

                System.out.println(name + "\t\t" + age);
			}
 
		} catch (SQLException e) {
            System.out.println(e);
		}
 
	}

}


