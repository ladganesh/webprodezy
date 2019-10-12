package com.mycompany.webprodezy.processmaster;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.webprodezy.webcall.*;
import com.mycompany.webprodezy.webservices.*;


/**
 * Servlet implementation class ProcessMaster
 */
@WebServlet("/ProcessMasteradd")
public class ProcessMasteradd extends HttpServlet {
	String process, details, result;
	String batch_wise, item_wise;
//	WebCall add_new;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessMasteradd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String errormessage;
		process = request.getParameter("process_name");
		batch_wise = request.getParameter("check_batch");
		item_wise = request.getParameter("check_item");
		details = request.getParameter("details");
		System.out.println("processs : " + process);

		if(batch_wise==null)
			batch_wise="false";
		if(item_wise==null)
			item_wise="false";
		System.out.println("batch  : " + batch_wise);
		System.out.println("item : "+ item_wise);
		System.out.println("Details :"+ details);
	RequestDispatcher rd;
		// TODO Auto-generated method stub
		try {
			 if (request.getParameter("add_process") != null) 
				{
	
					
				 String addEmpAPICall = null ;
				 addEmpAPICall = "processeadd?PROCESS_NAME="+ URLEncoder.encode(process, "UTF-8")
				        + "&PROCESS_DETAILS=" + URLEncoder.encode(details, "UTF-8")
		         		+ "&IS_BATCH_WISE="+  URLEncoder.encode(batch_wise, "UTF-8")
		         		+ "&IS_ITEM_WISE="+  URLEncoder.encode(item_wise, "UTF-8");
					String result= WebAPITester.prepareWebCall ( addEmpAPICall);

				System.out.println(addEmpAPICall);
				writer.println(addEmpAPICall);

				 String message="Your record is successfully save..";
			        System.out.printf("\n value of result "+result);	
			        request.setAttribute("errorMessage",message );
					 rd =request.getRequestDispatcher("/ProcessMaster.do");
					 rd.forward(request, response);	
			        
			        
			       
				}	
			 else if(request.getParameter("edit_process")!=null)
			 {
				 String addEmpAPICall = null ;
				 String flag=request.getParameter("id");
				 addEmpAPICall = "processeupdate?PROCESS_ID="+ URLEncoder.encode(flag, "UTF-8")+"&PROCESS_NAME="+ URLEncoder.encode(process, "UTF-8")
				        + "&PROCESS_DETAILS=" + URLEncoder.encode(details, "UTF-8")
				        + "&IS_BATCH_WISE="+  URLEncoder.encode(batch_wise, "UTF-8")
		         		+ "&IS_ITEM_WISE="+  URLEncoder.encode(item_wise, "UTF-8");
					String result= WebAPITester.prepareWebCall ( addEmpAPICall);

				 System.out.println(addEmpAPICall);
				 String message="Your record is successfully updated..";
			        System.out.printf("\n value of result "+result);
			        request.setAttribute("errorMessage",message );
			        rd =request.getRequestDispatcher("/ProcessMaster.do");
					rd.forward(request, response);	
		
			 }
			 else if(request.getParameter("delete_process")!=null)
			 {
				 String addEmpAPICall = null ;
				 String flag=request.getParameter("id");

				 addEmpAPICall = "processedelete?PROCESS_ID="+ URLEncoder.encode(flag, "UTF-8");
				      System.out.println(addEmpAPICall);
				writer.println(addEmpAPICall);

				result = WebAPITester.prepareWebCall(addEmpAPICall);
				 String message="Your record is successfully deleted..";
			        System.out.printf("\n value of result "+result);
			        request.setAttribute("errorMessage",message );
			        rd =request.getRequestDispatcher("/ProcessMaster.do");
					rd.forward(request, response);	
			 }

		} catch (Exception e) {
			System.out.println("error  " + e);
		}

	}

}
