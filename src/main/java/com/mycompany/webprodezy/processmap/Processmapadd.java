package  com.mycompany.webprodezy.processmap;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

import  com.mycompany.webprodezy.webservices.WebAPITester;

import   com.mycompany.webprodezy.model.*;


/**
 * Servlet implementation class Processmapadd
 */
@WebServlet("/Processmapadd")
public class Processmapadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Processmapadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String result="",fg_data,uom_id,fg_id,process_id,die_id,machine_id,setup_time,cycle_time,output_hr,output_shift,output_day,cost_rm,rejection,remark,addEmpAPICall;
	    String serial_no="",status="";
		RequestDispatcher rd;
		String message="";
		PrintWriter out = response.getWriter();
	
			String fgid=request.getParameter("isFg");
			String dieid=request.getParameter("die");
			String setup=request.getParameter("duration1");
			String cycletime=request.getParameter("duration2");
			fg_data = request.getParameter("isFg");
			process_id = request.getParameter("proc");
			String fpm_id = request.getParameter("fpm_id");

	//		String process_name = request.getParameter("proc");

			machine_id = request.getParameter("machine");
			output_hr = request.getParameter("output_hr");
			output_shift = request.getParameter("output_shift");
			output_day = request.getParameter("output_day");
			cost_rm = request.getParameter("cost_rm");
			rejection = request.getParameter("rejection");
			remark = request.getParameter("remark");
			uom_id=request.getParameter("uomid");
			
			String rem_string="";
			
			String processtime1[]= setup.split(" Hrs,");
			float hr=(Integer.parseInt(processtime1[0])*3600);
			rem_string=processtime1[1];
			System.out.println("setup rem time is"+rem_string );

			String processtime2[]= rem_string.split(" Min,");
			float mm=(Integer.parseInt(processtime2[0])*60);
			rem_string=processtime2[1];
			System.out.println("setup rem time is"+rem_string );

			String processtime3[]= rem_string.split(" Sec");
			float ss=((Integer.parseInt(processtime3[0])));
			//rem_string=processtime3[0];
			System.out.println("setup rem time is"+rem_string );

		float time1=(hr+mm+ss)/60;
		System.out.println("setup time is"+setup );

		System.out.println("setup hh mm ss duration"+hr+" "+mm+" "+ss+" = "+time1 );
		
		
		
		

		String proc_time1[]= cycletime.split(" Hrs,");
		 hr=(Integer.parseInt(proc_time1[0])*3600);
		rem_string=proc_time1[1];
	
		String proc_time2[]= rem_string.split(" Min,");
		 mm=(Integer.parseInt(proc_time2[0])*60);
		rem_string=proc_time2[1];
		
		String proc_time3[]= rem_string.split(" Sec");
		 ss=(Integer.parseInt(proc_time3[0]));
		//rem_string=processtime3[0];
	
	float time2=(hr+mm+ss)/60;
	System.out.println("cycle hh mm ss duration"+hr+" "+mm+" "+ss+" = "+time2);
//		if(!setup.equals("") && !setup.equals(null) )
//		{
//			
              
			if(request.getParameter("add") != null)
			{
                            try{
                            if(!(fgid=="" && process_id=="" && machine_id==""&& dieid==""))		{

				
                int serial =0;
                
				addEmpAPICall="processmachmaps?REF_FG_ID="+URLEncoder.encode(fgid, "UTF-8");
	            result = WebAPITester.prepareWebCall(addEmpAPICall);
	            if(!result.contains("not found"))
	            {
					addEmpAPICall="processmachmaps?REF_FG_ID="+URLEncoder.encode(fgid, "UTF-8")+"&PROCESS_ID="+URLEncoder.encode(process_id, "UTF-8");
				String	result1=WebAPITester.prepareWebCall(addEmpAPICall);
					   if(!result1.contains("not found"))
					   {
						   HashMap<String, Object> map = new HashMap<String, Object>();
				            

				            JSONObject jObject;

				            jObject = new JSONObject(result1);
				            Iterator<?> keys = jObject.keys();

				            while( keys.hasNext() ){
				                String key = (String)keys.next();
				                Object value = jObject.get ( key ) ; 
				                map.put(key, value);
				            }

				            JSONObject st = (JSONObject) map.get ( "data" );
				            JSONArray records = st.getJSONArray("records");
				            	
				            JSONObject emp = null;
				            int fpm =0;
		                    for (int j = 0; j < records.length(); j++) 
		                    {
		                        emp = records.getJSONObject(j);
		                        serial = emp.getInt("serial_no");
		                        fpm = emp.getInt("FPM_ID");
		                                
		                    }
		                    addEmpAPICall = "processmachmapupdate?FPM_ID="+fpm+"&active=0";
		                    String result2 = WebAPITester.prepareWebCall(addEmpAPICall);
		                     }else
		                     {
		                         HashMap<String, Object> map1 = new HashMap<String, Object>();
		                    JSONObject jObject1 = new JSONObject(result);
		                    Iterator<?> keys1 = jObject1.keys();

		                    while (keys1.hasNext()) {
		                        String key1 = (String) keys1.next();
		                        Object value1 = jObject1.get(key1);
		                        map1.put(key1, value1);
		                    }

		                    JSONObject st1 = (JSONObject) map1.get("data");
		                    JSONArray records1 = st1.getJSONArray("records");

		                    serial = records1.length()+1;
		                     }
		                      
		                  }else
		                  {
		                      serial = 1;
		                  }
	            
	          
		  String addEmpAPICall1;

		  addEmpAPICall1 = "processmachmapadd?REF_FG_ID="+URLEncoder.encode(fgid, "UTF-8")
          +"&REF_PROCESS_ID="+URLEncoder.encode(process_id,"UTF-8")
          +"&REF_MCH_ID="+URLEncoder.encode(machine_id, "UTF-8")
          +"&SETUP_TIME="+time1
          +"&IDEAL_PROCESS_TIME="+time2
          +"&REMARKS="+URLEncoder.encode(remark, "UTF-8")
          +"&TG_OPT_HR="+URLEncoder.encode(output_hr,"UTF-8")
          +"&TG_OPT_SHT="+URLEncoder.encode(output_shift ,"UTF-8")
          +"&TG_OPT_DAY="+URLEncoder.encode(output_day, "UTF-8")
          +"&UOM_ID="+URLEncoder.encode(uom_id ,"UTF-8")
          +"&VAL_AT_PROC="+URLEncoder.encode(cost_rm,"UTF-8")
          +"&MAX_REJ_PERM="+URLEncoder.encode(rejection, "UTF-8")  
          +"&REF_TOOL_CODE="+URLEncoder.encode(dieid  ,"UTF-8")  
          + "&serial_no="+serial+"&active=1";
		  
		  System.out.println("\n"+addEmpAPICall);
		  
		  
		  result = WebAPITester.prepareWebCall(addEmpAPICall1);
		  System.out.println("result =="+result);
			}
			

				
	
		       
             //   
			 //  out.println(result);

				if(result.contains("Process Mach Map created successfully."))
				{
					 message="Your record  successfully saved..";
			        request.setAttribute("errorMessage",message );
			       
				}
				else
				{
					message="Please fll up all data....";
			        request.setAttribute("errorMessage",message );
				}
                                 
                }
                            catch(Exception e){
                                        
                                        }
                                
                                
				 rd=request.getRequestDispatcher("/processmap.do");
			        rd.forward(request, response);	
                            
        }
            
					
			else if(request.getParameter("update") != null)
			{
                            try {
				if(!(fgid=="" && process_id=="" && machine_id==""&& dieid==""))		{
				
	                int serial =0;
	                
					addEmpAPICall="processmachmaps?REF_FG_ID="+URLEncoder.encode(fgid, "UTF-8");
		            result = WebAPITester.prepareWebCall(addEmpAPICall);
		            if(!result.contains("not found"))
		            {
						addEmpAPICall="processmachmaps?REF_FG_ID="+URLEncoder.encode(fgid, "UTF-8")+"&PROCESS_ID="+URLEncoder.encode(process_id, "UTF-8");
					String	result1=WebAPITester.prepareWebCall(addEmpAPICall);
						   if(!result1.contains("not found"))
						   {
							   HashMap<String, Object> map = new HashMap<String, Object>();
					            

					            JSONObject jObject;

					            jObject = new JSONObject(result1);
					            Iterator<?> keys = jObject.keys();

					            while( keys.hasNext() ){
					                String key = (String)keys.next();
					                Object value = jObject.get ( key ) ; 
					                map.put(key, value);
					            }

					            JSONObject st = (JSONObject) map.get ( "data" );
					            JSONArray records = st.getJSONArray("records");
					            	
					            JSONObject emp = null;
					            int fpm =0;
			                    for (int j = 0; j < records.length(); j++) 
			                    {
			                        emp = records.getJSONObject(j);
			                        serial = emp.getInt("serial_no");
			                        fpm = emp.getInt("FPM_ID");
			                                
			                    }
			                    addEmpAPICall = "processmachmapupdate?FPM_ID="+fpm+"&active=0";
			                    String result2 = WebAPITester.prepareWebCall(addEmpAPICall);
			                     }else
			                     {
			                         HashMap<String, Object> map1 = new HashMap<String, Object>();
			                    JSONObject jObject1 = new JSONObject(result);
			                    Iterator<?> keys1 = jObject1.keys();

			                    while (keys1.hasNext()) {
			                        String key1 = (String) keys1.next();
			                        Object value1 = jObject1.get(key1);
			                        map1.put(key1, value1);
			                    }

			                    JSONObject st1 = (JSONObject) map1.get("data");
			                    JSONArray records1 = st1.getJSONArray("records");

			                    serial = records1.length()+1;
			                     }
			                      
			                  }else
			                  {
			                      serial = 1;
			                  }
		            
		          
			  String addEmpAPICall1;

			  addEmpAPICall1 = "processmachmapadd?REF_FG_ID="+URLEncoder.encode(fgid, "UTF-8")
	          +"&REF_PROCESS_ID="+URLEncoder.encode(process_id,"UTF-8")
	          +"&REF_MCH_ID="+URLEncoder.encode(machine_id, "UTF-8")
	          +"&SETUP_TIME="+time1
	          +"&IDEAL_PROCESS_TIME="+time2
	          +"&REMARKS="+URLEncoder.encode(remark, "UTF-8")
	          +"&TG_OPT_HR="+URLEncoder.encode(output_hr,"UTF-8")
	          +"&TG_OPT_SHT="+URLEncoder.encode(output_shift ,"UTF-8")
	          +"&TG_OPT_DAY="+URLEncoder.encode(output_day, "UTF-8")
	          +"&UOM_ID="+URLEncoder.encode(uom_id ,"UTF-8")
	          +"&VAL_AT_PROC="+URLEncoder.encode(cost_rm,"UTF-8")
	          +"&MAX_REJ_PERM="+URLEncoder.encode(rejection, "UTF-8")  
	          +"&REF_TOOL_CODE="+URLEncoder.encode(dieid  ,"UTF-8")  
	          + "&serial_no="+serial+"&active=1";
			  
			  System.out.println("\n"+addEmpAPICall);
			  
			  
			  result = WebAPITester.prepareWebCall(addEmpAPICall1);
			  System.out.println("result =="+result);
				
		        }

	       
				
			       
	            	if(result.contains("Process Mach Map created successfully."))
					{
						 message="Your record  successfully saved..";
				        request.setAttribute("errorMessage",message );
				      
					}
					else
					{
						message="Please fll up all data....";
				        request.setAttribute("errorMessage",message );
					}
                            }catch(Exception e){
                                
                            }
					  rd=request.getRequestDispatcher("/processmap.do");
				        rd.forward(request, response);	
				}
		else if(request.getParameter("loadmap") != null)
			{
				
			    rd=request.getRequestDispatcher("/processmap.do");
		        rd.forward(request, response);
			}
		else if(request.getParameter("delete") != null)
		{
			  String addEmpAPICall1;

			  addEmpAPICall1 = "processmachmapdelete?FPM_ID="+URLEncoder.encode(fpm_id, "UTF-8");
			  
			//  System.out.println("\n"+addEmpAPICall);
			  
			  
			  result = WebAPITester.prepareWebCall(addEmpAPICall1);
			
			
			message="record is deleted successfully...";
		    request.setAttribute("errorMessage",message );
		    rd=request.getRequestDispatcher("/processmap.do");
	        rd.forward(request, response);
		}
		else {
			 message="Unable to save this record..Please try later";
         	   request.setAttribute("errorMessage",message );
			        rd=request.getRequestDispatcher("/processmap.do");
			        rd.forward(request, response);	
			        }
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
