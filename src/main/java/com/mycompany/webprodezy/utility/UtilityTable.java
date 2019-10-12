package com.mycompany.webprodezy.utility;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mycompany.webprodezy.employee.*;
import com.mycompany.webprodezy.webservices.WebAPITester;

/**
 * Servlet implementation class UtilityTable
 */
@WebServlet("/UtilityTable")
public class UtilityTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilityTable() {
        super();
        // TODO Auto-generated constructor stub
        
        System.out.println("In utility table");

    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in Utility is "+errormessage+ " ");
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
        page = Integer.parseInt(request.getParameter("page"));
        
        

		
        
        SpinnerData dao = new SpinnerData();
        List<UtilityDr> listdep,listDesg,listgrade,listrole,listsalary,listmachine,listuom; 
        listdep = dao.listDept();
        listDesg=dao.listDesg();
        listgrade=dao.listGrade();
        listrole=dao.listRoles();
        listsalary=dao.listSalary();
        listmachine=dao.listMachine();
        listuom=dao.listuom();
//        System.out.println("List Size "+list.size());
     //   int noOfRecords = dao.getNoOfRecords();
//        System.out.println(noOfRecords);
      //  int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
      

        int counter=((page-1)*recordsPerPage)+recordsPerPage;
//        System.out.println("counnter "+counter);
        int indexFrom=(page-1)*recordsPerPage;

            System.out.printf("errormessage in utility do "+errormessage);

        request.setAttribute("desglist", listDesg);
        request.setAttribute("deptlist", listdep);
        request.setAttribute("grade", listgrade);
        request.setAttribute("role", listrole);
        request.setAttribute("uom", listuom);
        request.setAttribute("salary", listsalary);
        request.setAttribute("machine", listmachine);




//        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("errormessage", errormessage);

        RequestDispatcher view = request.getRequestDispatcher("/Utility.jsp");
        view.forward(request, response);
	           
	               
	         
	           
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
	}
	
}
