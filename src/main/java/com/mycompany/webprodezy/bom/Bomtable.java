package com.mycompany.webprodezy.bom;
import java.io.IOException;
import com.mycompany.webprodezy.webcall.*;
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
/**
 * Servlet implementation class Bomtable
 */
@WebServlet("/Bomtable")
public class Bomtable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bomtable() {
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
		System.out.printf(" error message in planttable is "+errormessage+ " ");
		
		RMspinnerData dao= new RMspinnerData(); 
		List<BomrmDR> bomlist=dao.bomlist();
		
		   request.setAttribute("bomlistsize", bomlist.size());

		
		
		
		
		
		
		
		
		
		
		ArrayList<BomDR> mcTypes=new SpinnerList().getbillofmaterial();;
		List<BomrmDR>bomid= new RMspinnerData().bomlist();
		ArrayList<String[]> fglist= new SpinnerList().getfgList();
		//ArrayList<String[]>fglist=new 
		ArrayList<String[]>totalwt=new ArrayList<String[]>();

	   	//ArrayList<RawMaterialDr> rawmaterial=new ArrayList<>();
//	   	
//	        String addEmpAPICall = "billofmaterials";
//	        String result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
//	       // System.out.println("result2==="+result2 );

//	           if( ! result2.contains( "not found" )){
//	               HashMap<String, Object> map = new HashMap<String, Object>();
//	               
//
//	               JSONObject jObject;
//
//	               jObject = new JSONObject(result2 );
//	               Iterator<?> keys = jObject.keys();
//
//	               while( keys.hasNext() ){
//	                   String key = (String)keys.next();
//	                   Object value = jObject.get ( key ) ; 
//	                   map.put(key, value);
//	               }
//
//	               JSONObject st = (JSONObject) map.get ( "data" );
//	               JSONArray records = st.getJSONArray("records");
//	               	
//	               JSONObject emp = null;
//	               
//	               for ( int i = 0 ; i < records.length(); i ++ ) {
//
//	                   emp = records.getJSONObject(i);
//	                   
//	                   String BOM_ID,FG_ID, RM_ID,NT_WT,GS_WT, TOTAL_WT;
//	                   
////	                   RM_ID=(emp.get ( "RM_ID" ).toString ());
////	                   RM_CTG=emp.get ( "RM_CTG" ).toString ();
////	                   RM_NAME=emp.get ( "RM_NAME" ).toString ();
////	                   RM_RATE=emp.get ( "RM_RATE" ).toString ();
////	                   REORDER_LEVEL=emp.get ( "REORDER_LEVEL" ).toString ();
//	                   BOM_ID=emp.get ( "BOM_ID" ).toString ();
//	                   FG_ID=emp.get ( "FG_ID" ).toString ();
//	                   RM_ID=emp.get ( "RM_ID" ).toString ();
//	                   NT_WT=emp.get ( "NT_WT" ).toString ();
//	                   GS_WT=emp.get ( "GS_WT" ).toString ();
//	                   TOTAL_WT=emp.get ( "TOTAL_WT" ).toString ();
//	                   String FG_PART_NO=emp.get ( "FG_PART_NO" ).toString ();
////	                   RM_EC_NO=emp.get ( "RM_EC_NO" ).toString ();
////	                   RM_CAS_NO=emp.get ( "RM_CAS_NO" ).toString ();
////	                   GST_NO=emp.get ( "GST_NO" ).toString ();
////	                   RM_CRIT=emp.get ( "RM_CRIT" ).toString ();
//	                 // System.out.printf("length is "+Length);
//	                   //machineTypes.add(new MachineDR(id,name));
//	                   mcTypes.add(new BomDR( BOM_ID,FG_ID,RM_ID,NT_WT,GS_WT,TOTAL_WT,FG_PART_NO) );
//	                  //bomid.add(new BomrmDR (BOM_ID));
//	                 //  fgid.add(new String[] {FG_ID});
//	               //    totalwt.add(new String[] { TOTAL_WT});
//	                  // rawmaterial.add(new RawMaterialDr (RM_ID,RM_CTG, RM_NAME,RM_RATE,REORDER_LEVEL, RMM_UOM_ID,RM_CODE,Length,Width,Thickness,Density,RM_EC_NO,RM_CAS_NO,GST_NO,RM_CRIT));
//	                   //System.err.println("id"+id+"    name"+ name);
//	                   //machine.setMC_ID(id  );
//	                   //machine.setMC_NAME(emp.get ( "MC_TYPE" ).toString () ); 
//	                   
//	                   
//	               }
//	              
//	           }
	           
		
		
		
	           request.setAttribute("billofmaterial", mcTypes);
	           request.setAttribute("fglist", fglist);
	         //  request.setAttribute("totalwt", totalwt);
	           request.setAttribute("bomid", bomid);
	           request.setAttribute("errormessage", errormessage);

	        RequestDispatcher view = request.getRequestDispatcher("/bom.jsp");
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
