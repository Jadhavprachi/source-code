package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.UserBean;
import com.project.constant.GlobalConstant;
import com.project.model.User;
import com.project.service.UserService;
import com.project.service.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	UserService userService=null;
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean userBean=new UserBean();
		
		userBean.setUserEmail(request.getParameter("loginEmail"));
		userBean.setUserPassword(request.getParameter("loginPassword"));
		User userModel=prepareModel(userBean);
		userService=new UserServiceImpl();
		if(userService.authenticateUser(userModel))
		{
			System.out.println(userModel.getUserId());
			HttpSession session=request.getSession();
			session.setAttribute("userModel",userModel );
			System.out.println("User is valid");
			
			GlobalConstant.JSP_PAGE="homepage.jsp";
		}
		else
		{
			System.out.println("User is not Valid");
		}
		response.sendRedirect(GlobalConstant.JSP_PAGE);
		
	}

	private User prepareModel(UserBean userBean) {
		// TODO Auto-generated method stub
		User user=new User();
		
		user.setUserEmail(userBean.getUserEmail());
		user.setUserPassword(userBean.getUserPassword());
		return user;
	}

}
