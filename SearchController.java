package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.project.model.SeedURL;
import com.project.model.User;
import com.project.service.URLService;
import com.project.service.URLServiceImpl;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	URLService urlService;
    public SearchController() {
        super();
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
		
		PrintWriter out= response.getWriter();  
		response.setContentType("text/html");
		String searchQuery=request.getParameter("searchquery");
		urlService=new URLServiceImpl();
		
		//Call for Stop Word Removal from user search Statement.
		String stopWordRemoved=urlService.stopWordRemoval(searchQuery);
		System.out.println("Stop Word Found"+stopWordRemoved);
		
		List<SeedURL> seedURL=urlService.seedCollection(stopWordRemoved);
		JSONObject jsonData = new JSONObject();  	        
        
		 jsonData=printSeedCollection(seedURL);
		
		
	     out.print(jsonData);
	}

	
	private JSONObject printSeedCollection(List<SeedURL> seedURL) {
		// TODO Auto-generated method stub
		
		JSONObject jsonData = new JSONObject(); 
		String urlTitle="",urlLink="",urlConcept="";
		
		 
		for(int index=0;index<seedURL.size();index++)
		{
		
			
			urlLink+=seedURL.get(index).getUrlLink()+",";
			urlConcept+=seedURL.get(index).getUrlConcept()+",";
			urlTitle+=seedURL.get(index).getUrlTitle().replaceAll("\\W", " ")+",";
			jsonData.put("title", urlTitle);
			jsonData.put("url", urlLink);
			jsonData.put("concept", urlConcept);
		}
		
		
		return jsonData;
	}

}
