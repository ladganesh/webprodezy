package  com.mycompany.webprodezy.processmap;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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

import  com.mycompany.webprodezy.webservices.*;



/**
 * Servlet implementation class ProcessMap
 */
@WebServlet("/ProcessMap")
public class ProcessMap extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	 String errormessage=(String)request.getAttribute("errorMessage");
		System.out.printf(" error message in processmaster is "+errormessage+ " ");
    
	
	
	ArrayList<ProcessmapDR> mcTypes=new ArrayList<ProcessmapDR>();
	try{
     String addEmpAPICall = "processmachmaps";
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
         //   SpinnerData dao = new SpinnerData();

            for ( int i = 0 ; i < records.length(); i ++ ) {

                emp = records.getJSONObject(i);
                String process_id, PROCESS_NAME,machine,die_tool,setup_time,ideal_cycle,remarks,tg_hr,tg_day,unit,effective,permissible;
                process_id=(emp.get ( "FPM_ID" ).toString ());
               String fg_id=(emp.get ( "REF_FG_ID" ).toString ());

                PROCESS_NAME=emp.get ( "PROCESS_NAME" ).toString ();
               // System.out.println("Process name= "+PROCESS_NAME);
                machine=emp.get ( "MC_TYPE" ).toString ();
             //   System.out.println("\n  name of machine "+machine);
                    die_tool=emp.get ("die_name"  ).toString ();
                setup_time=emp.get ( "SETUP_TIME" ).toString ();
                ideal_cycle=emp.get ( "IDEAL_PROCESS_TIME" ).toString ();
                tg_hr=emp.get ( "TG_OPT_HR" ).toString ();
              String  tg_shift=emp.get ( "TG_OPT_SHT" ).toString ();
              tg_day=emp.get ( "TG_OPT_DAY" ).toString ();
              unit=emp.get ( "UOM" ).toString ();
              String uom_id=emp.get ( "UOM_ID" ).toString ();
              System.out.println("\n  uom _id "+uom_id);
              String Ref_process_id=(emp.get ( "REF_PROCESS_ID" ).toString ());
              String ref_tool_code=(emp.get ( "REF_TOOL_CODE" ).toString ());

              effective=emp.get("VAL_AT_PROC").toString();
              permissible=emp.getString("MAX_REJ_PERM").toString();
                mcTypes.add(new ProcessmapDR (process_id, PROCESS_NAME,machine,die_tool,setup_time,ideal_cycle,"",tg_hr,tg_shift,tg_day,unit,effective,permissible,fg_id,uom_id,Ref_process_id,ref_tool_code) );
            
                
            }
           
        }
       System.out.printf("errormessage in processmaster "+errormessage);

         request.setAttribute("processmap", mcTypes);
        request.setAttribute("errormessage", errormessage);

        
        }catch(Exception e){
            
        }
        RequestDispatcher view = request.getRequestDispatcher("/ProcessMap.jsp");
        view.forward(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	doGet(request, response);
}
	
}
