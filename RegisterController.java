package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.UserBean;
import com.project.constant.GlobalConstant;
import com.project.model.User;
import com.project.service.UserService;
import com.project.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	UserService userService=null;
    public RegisterController() {
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
		userBean.setUserName(request.getParameter("registerUserName"));
		userBean.setUserEmail(request.getParameter("registerEmail"));
		userBean.setUserPassword(request.getParameter("registerPassword"));
		userBean.setUserMobile(request.getParameter("registerMobile"));
		User userModel=prepareModel(userBean);
		userService=new UserServiceImpl();
		
		if(userService.createUser(userModel))
		{
			GlobalConstant.MESSAGE=GlobalConstant.SUCCESS_MESSAGE;
			GlobalConstant.JSP_PAGE="index.jsp";
			
		}
		else
		{
			GlobalConstant.MESSAGE=GlobalConstant.ERROR_INVALID_CREDS;
			GlobalConstant.JSP_PAGE="index.jsp";
			System.out.println("register not success");
		}
		
		response.sendRedirect(GlobalConstant.JSP_PAGE);
	}
	
	
	//
	private User prepareModel(UserBean userBean) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUserName(userBean.getUserName());
		user.setUserEmail(userBean.getUserEmail());
		user.setUserPassword(userBean.getUserPassword());
		user.setUserBdate(userBean.getUserBdate());
		user.setUserId(userBean.getUserId());
		user.setUserMobile(userBean.getUserMobile());
		user.setUserProfession(userBean.getUserProfession());
		user.setUserHobby(userBean.getUserHobby());
		
		return user;
	}
}
