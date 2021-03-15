//Data Access Object - Database Operation JDBC related stuff
package com.usermgt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usermgt.model.User;

//DAO class class provides CRUD database operations for the table users in the database
public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/usermgt?useSSL=false";	//JDBC variables
	private String jdbcUsername = "root";
	private String jdbcPassword = "Kcg@1993";
	
	//Insert,view,select,delete,update Query to user table and SQl statements
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (name,contact,email,address,possition) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,contact,email,address,possition from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,contact = ?,email = ?,address = ?,possition =? where id = ?;";
	
	public UserDAO() {
	}
	//SQl get Connection method
	protected Connection getConnection() {
		Connection connection = null;	//object
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//Create/insert  user method
	public void insertUser(User user) {
		try(Connection connection = getConnection();	//get connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){	//pass the sql statements
			preparedStatement.setString(1, user.getName());			//fill the query values placeholders
			preparedStatement.setString(2, user.getContact());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getPossition());
			preparedStatement.executeUpdate();		//execute the statement	
		}catch (Exception e) {		//catch exception
			e.printStackTrace();
		}
	}
	
	//Update user method
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;//create a variable 
		try (Connection connection = getConnection();//get connection object
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) { //pass the sql statements
			statement.setString(1, user.getName());  //fill the query values placeholders
			statement.setString(2, user.getContact());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getPossition());
			statement.setInt(6, user.getId());

			rowUpdated = statement.executeUpdate() > 0; //execute the statement	
		}
		return rowUpdated;
	}
	
	//Select user by id
	public User selectUser(int id) { // pass the value of the id
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();	//use execute query method to get result set

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String possition = rs.getString("possition");
				user = new User(id, name, contact, email, address, possition);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//Select All users method
	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String possition = rs.getString("possition");
				users.add(new User(id, name, contact, email, address, possition));
			}
		} catch (SQLException e) {
			e.printStackTrace();;
		}
		return users;
	}
	
	//Delete User method
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted; //create variable
		try (Connection connection = getConnection(); //get the connection object
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) { //pass the sql statements
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;//execute the statement	
		}
		return rowDeleted;
	}
	
}
