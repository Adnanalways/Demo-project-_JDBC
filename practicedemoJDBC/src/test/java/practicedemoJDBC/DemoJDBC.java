package practicedemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJDBC {
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String url ="jdbc:mysql://localhost:3306/";
				String dbName="practicedemo";
				String dburl=url+dbName;
				String username="root";
				String password="root";
				
				//create an object for mysql jdbc driver class
				String driver="com.mysql.cj.jdbc.Driver";
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//connect to mysql database system
			Connection connection=DriverManager.getConnection(dburl, username, password);
			
			if(!connection.isClosed()) {
				System.out.println("successfully connected to prctice demo database");
				//Execute the query retrieve the table records 
				Statement statement=connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from employee;");
				while(resultSet.next()) {
					System.out.println(resultSet.getString("Name")+"--"+resultSet.getString("location")+"--"+resultSet.getInt("exprience"));
				}
				connection.close();
				if (connection.isClosed()) {
					System.out.println("");
				}

			}

			
	}

}
