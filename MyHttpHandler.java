import java.util.Map;

// i am supposing only get or post resquest come and it will handle
class Emp {
    private String name;
    private int  age;

    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      this.name = newName;
    }

    public String getAge() {
      return age;
    }
  
    public void setAge(int age) {
      this.age = age;
    }
}

private class MyHttpHandler implements HttpHandler {    
    static Connection con = null;
	static PreparedStatement prepareStatement = null;

    @Override    
    public List<Emp> handle(HttpExchange httpExchange) throws IOException {
    
        String requestParamValue=null; 
        try {
            if("GET".equals(httpExchange.getRequestMethod())) { 
    
                requestParamValue = handleRequest(httpExchange);
         
             }else if("POST".equals(httpExchange)) { 
         
                requestParamValue = handleRequest(httpExchange);        
         
             } 
        }catch(Exception ex) {
            System.out.println(ex);
        }
 
    
        return handleResponse(httpExchange,requestParamValue); 
    
    }
    
    
    private String handleRequest(HttpExchange httpExchange) {
    
            return httpExchange.
    
                    getRequestURI()
    
                    .toString()
    
                    .split("\\?")[1]
    
                    .split("=")[1];
    
    }

    private Lit<Emp> handleResponse(HttpExchange httpExchange, String requestParamValue)  throws  IOException {

        String url = "jdbc:mysql://localhost:3306/Emp";
        String user = "root";
        String password = "root";
        List<Emp> empList = new ArrayList<>();
 
        try {
            System.out.println("make JDBC connection to MySQL DB");
            makeJDBCConnection(url, user, password);

            empList = getDataFromDB(new ArrayList());
            
            httpExchange.sendResponseHeaders(200, empList);

            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
        
        return empList;
    
    }

    private void makeJDBCConnection(String url, String user, String password) {
 
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

    private List<Emp> getDataFromDB(List<Emp> empList) {
 
		try {

			String getQueryStatement = "select * from test";
 
			prepareStatement = con.prepareStatement(getQueryStatement);
 
			ResultSet resultsSet = prepareStatement.executeQuery();

			while (resultsSet.next()) {
                Emp emp = new Emp();
                String name = resultsSet.getString("name");
                int age = resultsSet.getInt("age");

                emp.setName(name);
                emp.setAge(age);

                empList.add(emp);
			}
 
		} catch (SQLException e) {
            System.out.println(e);
            return new ArrayList();
		}
        return empList;
 
	}
}