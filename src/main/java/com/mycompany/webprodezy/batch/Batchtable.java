package com.mycompany.webprodezy.batch;

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

import com.mycompany.webprodezy.rawmaterial.*;
import com.mycompany.webprodezy.webservices.*;

import com.mycompany.webprodezy.webcall.*;

/**
 * Servlet implementation class Batchtable
 */
@WebServlet("/Batchtable")
public class Batchtable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Batchtable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	try{
		String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in planttable is "+errormessage+ " ");
		
		List<RawMaterialDr> rmlist=new RMspinnerData().list(0,0);
		ArrayList<BatchDR>batches=new ArrayList<BatchDR>();
		  String addEmpAPICall = "batches";
	        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
	       // System.out.println("result2==="+result2 );

	           if( ! result2.contains( "not found" )){
	               HashMap<String, Object> map = new HashMap<String, Object>();
	               

	               JSONObject jObject;

	               jObject = new JSONObject(result2 );
	               Iterator<?> keys = jObject.keys();

	               while( keys.hasNext() ){
	                   String key = (String)keys.next();
	                   Object value = jObject.get ( key ) ; 
	                   map.put(key, value);
	               }

	               JSONObject st = (JSONObject) map.get ( "data" );
	               JSONArray records = st.getJSONArray("records");
	               	
	               JSONObject emp = null;
	               
	               for ( int i = 0 ; i < records.length(); i ++ ) {

	                   emp = records.getJSONObject(i);
	                   
	              	 String BatchId,BatchName,BatchQty,BatchUOM_ID,BatchCreatedDate,BatchExpireDate;
	                   
	              	BatchId=(emp.get ( "BatchId" ).toString ());
	              	BatchName=emp.get ( "BatchName" ).toString ();
	              	BatchQty=emp.get ( "BatchQty" ).toString ();
	              	BatchUOM_ID=emp.get ( "BatchUOM_ID" ).toString ();
	              	BatchCreatedDate=emp.get ( "BatchCreateDate" ).toString ();
	              	BatchExpireDate=emp.get ( "BatchExpireDate" ).toString ();
	             batches.add(new BatchDR ( BatchId,BatchName,BatchQty,BatchCreatedDate,BatchExpireDate) );
	           
	               }
	              
	           }
	           
		
		
		
	           request.setAttribute("batches", batches);
	           request.setAttribute("rmlist", rmlist);

	          request.setAttribute("errormessage", errormessage);

	        RequestDispatcher view = request.getRequestDispatcher("/Batch.jsp");
	        view.forward(request, response);
		           	
        }catch(Exception e){
            
        }
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
