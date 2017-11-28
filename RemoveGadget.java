package com.project.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.constant.GlobalConstant;
import com.project.db.DBConnect;

/**
 * Servlet implementation class RemoveGadget
 */
@WebServlet("/RemoveGadget")
public class RemoveGadget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveGadget() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("imgid"));
		int widgetId=Integer.parseInt(request.getParameter("imgid"));
		String SQL="delete from tbl_widget where widget_id='"+widgetId+"'";
		Connection connection=DBConnect.getConnection();
		if(connection!=null)
		{
			try {
				Statement stmt=connection.createStatement();
				int index=stmt.executeUpdate(SQL);
				if(index>0)
				{
					System.out.println("Widget is Deleted");
					GlobalConstant.MESSAGE=GlobalConstant.SUCCESS_Remove_IMAGE;
					GlobalConstant.JSP_PAGE="/gadgetservices.jsp";
				}
				else
				{
					System.out.println("Widget is not Deleted");
					GlobalConstant.MESSAGE=GlobalConstant.ERROR_INVALID_IMAGE;
					GlobalConstant.JSP_PAGE="/gadgetservices.jsp";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		getServletContext().getRequestDispatcher(GlobalConstant.JSP_PAGE).include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
