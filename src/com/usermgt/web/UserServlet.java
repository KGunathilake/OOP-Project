//Servlet to handle the request
package com.usermgt.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermgt.dao.UserDAO;
import com.usermgt.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")	//all the request to the single servlet
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;	//create object of userDAO class
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
    	this.userDAO = new UserDAO();	//create object inside constructor
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);	//handleout the do get method request
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		//Switch statements for actions
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);	//no one perform loading default page
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)	//list user method
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();//call the userDAO object
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");	//display list of user page
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));	//retrieving all the user details by passing the user id
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String possition = request.getParameter("possition");

		User user = new User(id, name, contact, email, address, possition);		//creating user object
		userDAO.updateUser(user);	//calling the update user method
		response.sendRedirect("list");//redirect the list
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) //delete user method
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));	//get the selected id
		userDAO.deleteUser(id);	//call the method to delete
		response.sendRedirect("list");	//redirect to list

	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);		//get user object
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp"); // pass values to the form for editing
		request.setAttribute("user", existingUser);// call request method
		dispatcher.forward(request, response);// call dispatcher method

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");	//request the form (/new)
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 	//insert private method
			throws SQLException, IOException {
		String name = request.getParameter("name");	 //extracting the user details
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String possition = request.getParameter("possition");
		User newUser = new User(name, contact, email, address, possition);	//passing the values to the constructor
		userDAO.insertUser(newUser); //call to insert user
		response.sendRedirect("list"); //redirect to the list
	}

}
