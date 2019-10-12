package  com.mycompany.webprodezy.processmaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import  com.mycompany.webprodezy.supplier.*;
import  com.mycompany.webprodezy.webservices.*;

/**
 * Servlet implementation class ProcessMastertable
 */
@WebServlet("/ProcessMastertable")
public class ProcessMastertable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessMastertable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	 String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in processmaster is "+errormessage+ " ");
    
	
	
	ArrayList<ProcessmasterDR> mcTypes=new ArrayList<ProcessmasterDR>();
	try{
     String addEmpAPICall = "processes";
     String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
   //  System.out.println("result2==="+result2 );

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
                
                String process_id,process_name,  process_details, is_batch,  is_item ;               
                process_id=(emp.get ( "PROCESS_ID" ).toString ());
                process_name=emp.get ( "PROCESS_NAME" ).toString ();
                is_batch=emp.get ( "IS_BATCH_WISE" ).toString ();
                is_item=emp.get ( "IS_ITEM_WISE" ).toString ();
                process_details=emp.get ( "PROCESS_DETAILS" ).toString ();
                if(is_batch.equals("true"))
                	is_batch="Yes";
                else
                	is_batch="No";
                
                if(is_item.equals("true"))
                	is_item="Yes";
                else
                	is_item="No";

                mcTypes.add(new ProcessmasterDR (process_id,	  process_name,  process_details, is_batch,  is_item) );
            
                
            }
           
        }
	
	
	
        System.out.printf("errormessage in processmaster "+errormessage);

         request.setAttribute("processmaster", mcTypes);
        request.setAttribute("errormessage", errormessage);

        
        }catch(Exception e){
            
            
        }
        RequestDispatcher view = request.getRequestDispatcher("/processmaster.jsp");
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
