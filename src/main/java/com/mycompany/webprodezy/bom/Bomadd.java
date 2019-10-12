package com.mycompany.webprodezy.bom;

import java.awt.List;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.webprodezy.rawmaterial.*;
import com.mycompany.webprodezy.webservices.*;

import com.mycompany.webprodezy.webcall.*;

/**
 * Servlet implementation class Bomadd
 */
@WebServlet("/Bomadd")
public class Bomadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bomadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		RequestDispatcher rd;
		String data,ubomid;
		ArrayList<String[]>getdata=new  ArrayList<String[]>();
		ArrayList<String []>  bill = (ArrayList<String[]>) new RMspinnerData().bomlist2();
		System.out.println("printing data");
		String fgid=request.getParameter("isFg");
		
		for(int i=0;i<bill.size();i++)
		{
			 data=request.getParameter(bill.get(i)[2]);
				//System.out.println(data);
			String x ="hidden"+bill.get(i)[2];
			 ubomid=request.getParameter(x);
				System.out.println("\nx ="+x);
				System.out.println("\nubommid ="+ubomid);

				if(data!="") {
					
					getdata.add(new String[]{fgid,bill.get(i)[2],data,ubomid});
					System.out.println(data);
				}
		}
		
		
		if(request.getParameter("Update")!=null) {
			System.out.println("fgid  bill.get(i)[2]  data  ubomid");
			for(int i=0;i<getdata.size();i++)
				{
					System.out.println(getdata.get(i)[0]+" "+getdata.get(i)[1]+" "+getdata.get(i)[2]+" "+getdata.get(i)[3]+" ");
				
						  if(getdata.get(i)[3]=="") {
							  
							 String result;
							
							String addEmpAPICall ="bomadd?FG_ID=" +URLEncoder.encode( getdata.get(i)[0], "UTF-8")+"&RM_ID="+URLEncoder.encode( getdata.get(i)[1], "UTF-8")+"&TOTAL_WT="+URLEncoder.encode( getdata.get(i)[2], "UTF-8");
					        System.out.printf("\n value of addEmpAPICall "+addEmpAPICall);	
				
								result= WebAPITester.prepareWebCall ( addEmpAPICall);
						        String message = "Your record is successfully save..";
						        System.out.printf("\n value of result "+result);	
						        request.setAttribute("errorMessage",message );
								
							 
						  }
						  else if(getdata.get(i)[3]!="" ) {
							  
								 String result;
								
								String addEmpAPICall ="bomupdate?BOM_ID="+URLEncoder.encode( getdata.get(i)[3], "UTF-8")+"&FG_ID=" +URLEncoder.encode( getdata.get(i)[0], "UTF-8")+"&RM_ID="+URLEncoder.encode( getdata.get(i)[1], "UTF-8")+"&TOTAL_WT="+URLEncoder.encode( getdata.get(i)[2], "UTF-8");
						        System.out.printf("\n value of addEmpAPICall "+addEmpAPICall);	
				
									result= WebAPITester.prepareWebCall ( addEmpAPICall);
							        String message = "Your record is successfully updated..";
							        System.out.printf("\n value of result "+result);	
							        request.setAttribute("errorMessage",message );
									
								 }
						}
					}
					else if(request.getParameter("Delete Record")!=null ) {
							  
							  String getdeleteid=request.getParameter("deleteid");
								String addEmpAPICall ="bomdelete?BOM_ID="+URLEncoder.encode( getdeleteid, "UTF-8");
						        System.out.printf("\n value of addEmpAPICall "+addEmpAPICall);	
				
									String result= WebAPITester.prepareWebCall ( addEmpAPICall);
							        String message = "Your record is successfully deleted..";
							        System.out.printf("\n value of result "+result);	
							        request.setAttribute("errorMessage",message );
							        System.out.printf("\n value of delete result "+result);	
		
								 }
						
				
				  else
				  {
				        String message = "Something went wrong......";
				        System.out.printf(message);	

				       // System.out.printf("\n value of result "+result);	
				        request.setAttribute("errorMessage",message );
				  }
					  
		 
rd =request.getRequestDispatcher("/Bomtable.do");
rd.forward(request, response);	
	}

}
