package com.mycompany.webprodezy.utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.mycompany.webprodezy.webservices.*;
@WebServlet("/UtilityADD")

public class UtilityADD extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		String utilityname=req.getParameter("utility_name");
        String value=req.getParameter("utilityname");
        String id=req.getParameter("id");
    	System.out.println("\n switch case VALUE "+ value);	
    	System.out.println("\n switch case ID "+ id);	

       // PrintWriter out = resp.getWriter();
        RequestDispatcher rd;
        String addEmpAPICall = null;
        String result2 = null;
        JSONObject responseObject = null;
        String action=req.getParameter("Add_to_Master");
    	System.out.println("value of action is "+ action);	

        if(req.getParameter("Add_to_Master")!=null)
        {	
            try{
        	System.out.println("\n switch case "+ utilityname);	

            switch ( utilityname ) {

                case "grade":
                    // res = DB_Operations.insertIntoGradesMaster ( value );
                    //showDataInParticularList ( "grade" , "GradeName" );

                    try{
                        addEmpAPICall = "gradeadd?GradeName=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                    	System.out.println("Added successfully");	
                    }

                   
                    break;

                case "designation":
                    //res = DB_Operations.insertIntoDesignationsMaster ( value );
                    //showDataInParticularList ( "designation" , "DesgTitle" );

                    try{
                        addEmpAPICall = "designationsadd?DesgTitle=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;

                case "salary":
                    //res = DB_Operations.insertIntoSalaryMaster ( value );
                    //showDataInParticularList ( "salaryband" , "SB_RANGE" );

                    try{
                        addEmpAPICall = "salarybandadd?SB_RANGE=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Nature of Employment":
                    //res = DB_Operations.insertIntoEmpNatureMaster ( value );
                    
                    

                    break;

                case "uom":
                    //res = DB_Operations.insertIntoUOMMaster ( value );
                    //showDataInParticularList ( "uom" , "UOM" );

                    try{
                        addEmpAPICall = "unitmeasadd?UOM=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Pack Size":
                    //res = DB_Operations.insertUtilitiesMaster ( "PackSize" , value );
                    //showDataInParticularList ( "pack_size" , "PackSize" );

                    try{
                        addEmpAPICall = "packsizeadd?PackSize=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Raw Material Type":
                    //res = DB_Operations.insertUtilitiesMaster ( "RawMaterial" , value );
                    //showDataInParticularList ( "raw_material_type" , "RawMaterialType" );

                   try{
                        addEmpAPICall = "rmtadd?RawMaterial=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Category":
                    //res = DB_Operations.insertUtilitiesMaster ( "Category" , value );
                    //showDataInParticularList ( "category" , "Category" );

                    try{
                        addEmpAPICall = "categoryadd?Category=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                         //   JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

                case "Segment":
                    // res = DB_Operations.insertUtilitiesMaster ( "Segment" , value );
                    //showDataInParticularList ( "segment" , "Segment" );

                    try{
                        addEmpAPICall = "segmentadd?Segment="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
               
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                          //  JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Industry":
                    //res = DB_Operations.insertUtilitiesMaster ( "Industry" , value );
                    //showDataInParticularList ( "industry" , "Industry" );

                     try{
                        addEmpAPICall = "industryadd?Industry=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                          //  JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

                case "Rejection Reason":
                    //res = DB_Operations.insertUtilitiesMaster ( "RejectionReason" , value );
                    //showDataInParticularList ( "rejectionReason" , "RejectionReasons" );

                     try{
                        addEmpAPICall = "rejreasonsadd?RR_DESC=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall);
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "Document Types":
                    //res = DB_Operations.insertUtilitiesMaster ( "DocumentType" , value );
                    //showDataInParticularList ( "documentType" , "DocumentType" );
//   
//                        if(  jRadioButton1.isSelected ()      ){
//                            if( ! value.contains ( "Part - ")  )
//                                value = "Part - "+ value ;
//                        }else if( jRadioButton2.isSelected ()       ){
//                            if( ! value.contains ( "RM - ")  )
//                            value = "RM - "+ value ;
//                        }else if( jRadioButton3.isSelected ()       ){
//
//                        }

                     try{
                        addEmpAPICall = "rdmadd?RDM_NAME=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "departments":
                    //res = DB_Operations.insertUtilitiesMaster ( "Departments" , value );
                    // showDataInParticularList ( "departments" , "Departments" );

                    try{
                        addEmpAPICall = "departmentadd?DNAME=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                          //  JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

                case "Resources":
                    //res = DB_Operations.insertUtilitiesMaster ( "Resources" , value );
                    //showDataInParticularList ( "resources" , "Resources" );

                    try{
                        addEmpAPICall = "resourceadd?RSNAME=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

                case "role":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "userrolesadd?RoleName="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;
                    
                    case "TimeLoss Reasons":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "timeloss_reason_add?TLR_DESC="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;
                    
                    
                    case "Maintenance Types":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "maintenance_type_add?activity="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;
                    case "machine":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "machinestype_add?MC_TYPE="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;
                case "Quality Raw Material":
                   try{
                        addEmpAPICall = "rmqty_u_master_add?param_name="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){}
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            ///JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    
                    break;
                case "Quality Process":
                   try{
                        addEmpAPICall = "procqty_u_master_add?param_name="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){}
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }
                    
                    
                    break;
                case "Quality Product":
                 try{
                        addEmpAPICall = "partqty_u_master_add?param_name="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){}
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    
                    break;
                    
                    //*******---------------
            }
            }catch(Exception e){
                
            }
        }
        else if(req.getParameter("Edit Record")!=null)
        {
try{
        	System.out.println("\n switch case IN eDIT"+ utilityname);	

            switch ( utilityname ) {

                case "grade":
                    // res = DB_Operations.insertIntoGradesMaster ( value );
                    //showDataInParticularList ( "grade" , "GradeName" );

                    try{
                        addEmpAPICall = "gradeupdate?GradeID=" +URLEncoder.encode( id, "UTF-8")+"&GradeName=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                    	System.out.println("Updated successfully");	
                    }

                   
                    break;

                case "designation":
                    //res = DB_Operations.insertIntoDesignationsMaster ( value );
                    //showDataInParticularList ( "designation" , "DesgTitle" );

                    try{
                        addEmpAPICall = "designationsupdate?DesgID="+ URLEncoder.encode( id, "UTF-8")+"&DesgTitle=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;

                case "salary":
                    //res = DB_Operations.insertIntoSalaryMaster ( value );
                    //showDataInParticularList ( "salaryband" , "SB_RANGE" );

                    try{
                        addEmpAPICall = "salarybandupdate?SB_ID="+URLEncoder.encode( id, "UTF-8")+"&SB_RANGE=" + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "uom":
                    //res = DB_Operations.insertIntoUOMMaster ( value );
                    //showDataInParticularList ( "uom" , "UOM" );

                    try{
                        addEmpAPICall = "unitmeasupdate?UOM_id=" + URLEncoder.encode( id, "UTF-8")+"&UOM="+URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "departments":
                    //res = DB_Operations.insertUtilitiesMaster ( "Departments" , value );
                    // showDataInParticularList ( "departments" , "Departments" );

                    try{
                        addEmpAPICall = "departmentupdate?DID=" + URLEncoder.encode( id, "UTF-8")+"&DNAME="+URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                          //  JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

               

                case "role":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "userrolesupdate?Role_ID="+URLEncoder.encode( id, "UTF-8")+"&RoleName="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;
                    
                   
                    case "machine":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "machinestype_update?MC_TYPE_ID="+URLEncoder.encode( id, "UTF-8")+"&MC_TYPE="  + URLEncoder.encode( value, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;
               
                    //*******---------------
            
        	
            }
}catch(Exception e){
    
}
        }   
        else if(req.getParameter("Delete Record")!=null)
        {
            try{
        	System.out.println("\n switch case IN eDIT"+ utilityname);	

            switch ( utilityname ) {

                case "grade":
                    // res = DB_Operations.insertIntoGradesMaster ( value );
                    //showDataInParticularList ( "grade" , "GradeName" );

                    try{
                        addEmpAPICall = "gradedelete?GradeID=" +URLEncoder.encode( id, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                    	System.out.println("Updated successfully");	
                    }

                   
                    break;

                case "designation":
                    //res = DB_Operations.insertIntoDesignationsMaster ( value );
                    //showDataInParticularList ( "designation" , "DesgTitle" );

                    try{
                        addEmpAPICall = "designationsdelete?DesgID="+ URLEncoder.encode( id, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;

                case "salary":
                    //res = DB_Operations.insertIntoSalaryMaster ( value );
                    //showDataInParticularList ( "salaryband" , "SB_RANGE" );

                    try{
                        addEmpAPICall = "salarybanddelete?SB_ID="+URLEncoder.encode( id, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "uom":
                    //res = DB_Operations.insertIntoUOMMaster ( value );
                    //showDataInParticularList ( "uom" , "UOM" );

                    try{
                        addEmpAPICall = "unitmeasdelete?UOM_id=" + URLEncoder.encode( id, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                   
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                    

                    break;

                case "departments":
                    //res = DB_Operations.insertUtilitiesMaster ( "Departments" , value );
                    // showDataInParticularList ( "departments" , "Departments" );

                    try{
                        addEmpAPICall = "departmentdelete?DID=" + URLEncoder.encode( id, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    if( result2.contains ( "success") ){
                          //  JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;

               

                case "role":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "userrolesdelete?Role_ID="+URLEncoder.encode( id, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall  );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                           // JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   

                    break;
                    
                   
                    case "machine":
                    //res = DB_Operations.insertUtilitiesMaster ( "User Roles" , value );
                    //showDataInParticularList ( "roles" , "User Roles" );

                    try{
                        addEmpAPICall = "machinestype_delete?MC_TYPE_ID="+URLEncoder.encode( id, "UTF-8");
                    }catch(UnsupportedEncodingException e){
                        
                    }
                    
                    result2 = WebAPITester.prepareWebCall ( addEmpAPICall );
                    responseObject = ( JSONObject ) new JSONTokener ( result2 ).nextValue ();
                    
                    if( result2.contains ( "success") ){
                            //JOptionPane.showMessageDialog ( null , "Successfuly created new entry in "+selectedMaster+" master" );
                    }

                   
                    break;
               
                    //*******---------------
            
        	
            }
        }  catch(Exception e){
                
                }
        }
        rd =req.getRequestDispatcher("/UtilityTable.do");
		rd.forward(req, resp);


        }
        
	}
	
	
	
	
	
	
	


