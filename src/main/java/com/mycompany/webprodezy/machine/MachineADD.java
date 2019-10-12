package com.mycompany.webprodezy.machine;
//package com.oreilly.servlet.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Paths;
import com.mycompany.webprodezy.webcall.SpinnerList;
import com.mycompany.webprodezy.webservices.*;


import javax.activation.MimetypesFileTypeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

@WebServlet("/MachineADD")
public class MachineADD extends HttpServlet {

	public MachineADD() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		

		//System.out.println("do get call");
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        MachineData dao = new MachineData();
      
        List<MachineDR> list = dao.list((page-1)*recordsPerPage, recordsPerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("machineList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);

        RequestDispatcher view = request.getRequestDispatcher("/mchin.do");
        view.forward(request, resp);

	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   // System.out.println("post");
    
    RequestDispatcher rd;
    	String selectedID="";
        String machineno=request.getParameter("machineno");
        String make=request.getParameter("make");
        String mc_type=request.getParameter("ismachinetype");
        String operating=request.getParameter("operating");
        String available=request.getParameter("available");
        String desig_available=request.getParameter("desig_available");
        String maintenance_rating=request.getParameter("maintenance_rating");
        selectedID=request.getParameter("id");
        //System.out.println("testing=  "+selectedID+machineno+make+mc_type+operating+available+desig_available+maintenance_rating);
        
        //HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
		String value=request.getParameter("Add_to_Master");
		System.out.println("value of button is = "+value);

        if(request.getParameter("Add_to_Master")!=null)
	     {
	      //  if( !machineno.equals( "")  ){
	        	System.out.println("Add button click");
	
	        	String addEmpAPICall="",result2="";
	              
	                    //if(selectedID.isEmpty())
	                    {
		                    addEmpAPICall = "machineadd?MACHINE_NO="+URLEncoder.encode(machineno, "UTF-8")+"&MAKE="+URLEncoder.encode(make, "UTF-8")+"&BED_SIZE="+URLEncoder.encode("" , "UTF-8")+"&HEATER_QTY="+URLEncoder.encode("", "UTF-8")+"&YR_OF_COMM="+URLEncoder.encode( "", "UTF-8")+"&CR_MAINT_RTG="+URLEncoder.encode( maintenance_rating, "UTF-8")+"&MCH_IMG="+URLEncoder.encode( "", "UTF-8")+"&CR_MCH_OWN="+URLEncoder.encode( "", "UTF-8")+"&MACH_OWN_IMG="+URLEncoder.encode( "", "UTF-8")+"&MCH_BRKD_RCD="+URLEncoder.encode( "", "UTF-8")+"&PM_ELE="+URLEncoder.encode( "", "UTF-8")+"&PM_MEC="+URLEncoder.encode( "", "UTF-8")+"&PM_HYD="+URLEncoder.encode( "", "UTF-8")+"&PM_PNM="+URLEncoder.encode( "", "UTF-8")+"&PM_CLIT="+URLEncoder.encode("", "UTF-8")+"&PRSS_GAUGE="+URLEncoder.encode("", "UTF-8")+"&TIMER="+URLEncoder.encode("", "UTF-8")+"&OP_RATE_HR="+URLEncoder.encode(operating, "UTF-8")+"&AVL_HRS="+URLEncoder.encode(available, "UTF-8")+"&DAVLHRS="+URLEncoder.encode(desig_available, "UTF-8")+"&INSTR_LIST="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("mayur", "UTF-8")+"&TYPE="+URLEncoder.encode(mc_type, "UTF-8"); 
		                    result2 =  WebAPITester.prepareWebCall ( addEmpAPICall);
	                   
	                    }
	                //    else
	                    {
	                    	//update by id
	                    	//System.out.println("update your code");
	                    } 	
	                    
	       // }
	                   if(result2.contains("success"))
	                   {
	                	   	String message="Your record  successfully saved..";
					        request.setAttribute("errorMessage",message );
					        rd=request.getRequestDispatcher("/mchin.do");
					        rd.forward(request, response);	
	
	                   }
	                   else
	                   {
	//                      
	                	   String message="Unable to save this record..Please try later";
	                	   request.setAttribute("errorMessage",message );
					        rd=request.getRequestDispatcher("/mchin.do");
					        rd.forward(request, response);	
	                   }
	                   
	                   
	                   
	                
	               
	            //JOptionPane.showMessageDialog(null, "Machine added successfuly");
	
		        
        }
        else if(request.getParameter("edit_record")!=null)
        {
        	System.out.println("edit_record button click");
        	if(!selectedID.isEmpty())
        	{
        		
        	String addEmpAPICall = "machinesupdate?MCH_ID="+URLEncoder.encode(selectedID, "UTF-8")+"&MACHINE_NO="+URLEncoder.encode(machineno, "UTF-8")+"&MAKE="+URLEncoder.encode(make, "UTF-8")+"&BED_SIZE="+URLEncoder.encode("" , "UTF-8")+"&HEATER_QTY="+URLEncoder.encode("", "UTF-8")+"&YR_OF_COMM="+URLEncoder.encode( "", "UTF-8")+"&CR_MAINT_RTG="+URLEncoder.encode( maintenance_rating, "UTF-8")+"&MCH_IMG="+URLEncoder.encode( "", "UTF-8")+"&CR_MCH_OWN="+URLEncoder.encode( "", "UTF-8")+"&MACH_OWN_IMG="+URLEncoder.encode( "", "UTF-8")+"&MCH_BRKD_RCD="+URLEncoder.encode( "", "UTF-8")+"&PM_ELE="+URLEncoder.encode( "", "UTF-8")+"&PM_MEC="+URLEncoder.encode( "", "UTF-8")+"&PM_HYD="+URLEncoder.encode( "", "UTF-8")+"&PM_PNM="+URLEncoder.encode( "", "UTF-8")+"&PM_CLIT="+URLEncoder.encode("", "UTF-8")+"&PRSS_GAUGE="+URLEncoder.encode("", "UTF-8")+"&TIMER="+URLEncoder.encode("", "UTF-8")+"&OP_RATE_HR="+URLEncoder.encode(operating, "UTF-8")+"&AVL_HRS="+URLEncoder.encode(available, "UTF-8")+"&DAVLHRS="+URLEncoder.encode(desig_available, "UTF-8")+"&INSTR_LIST="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("mayur", "UTF-8")+"&TYPE="+URLEncoder.encode(mc_type, "UTF-8");  
            String result2 =  WebAPITester.prepareWebCall ( addEmpAPICall);
            System.out.print(result2);
            
	            if(result2.contains("success"))
	            {
	         	   String message="Your record is successfully updated..";
	         	  request.setAttribute("errorMessage",message );
			        rd=request.getRequestDispatcher("/mchin.do");
			        rd.forward(request, response);	
	
	            }
        	}
	            else
	            {
	         	   String message="Unable to update this record..Please try later";
	         	  request.setAttribute("errorMessage",message );
			        rd=request.getRequestDispatcher("/mchin.do");
			        rd.forward(request, response);	
	            }
        	
        	//response.sendRedirect("Machines.jsp");
        }
        else if(request.getParameter("Import_to_Excel")!=null)
        {
//            System.out.println("here importing dtaa\n");
//            int uploadedcount=0;
//        	String folderName="resources";
//        	String uploadpath=request.getServletContext().getRealPath("")+folderName;
//        	File dir=new File(uploadpath);
//
//        	if(!dir.exists())
//        	{
//        		dir.mkdirs();
//        	}
//            Part filepart=request.getPart("excelfile");
//            String filename=filepart.getSubmittedFileName();
//            String path=folderName+File.separator+filename; 
//        	InputStream fis=filepart.getInputStream();
//    
//            ArrayList<String[]>uploadData = new ArrayList<String[]>();
//     
//
//            FileChannel inputChannel = null;
//            FileChannel outputChannel = null;
//
//
//            String url;
//            try {
//
////                url = "jdbc:sqlite:" + StaticValues.dbName;
////                Connection con = DriverManager.getConnection(url);
////                Statement stm = con.createStatement();
////                PreparedStatement pst;
//
//                //String query = "INSERT INTO xl_import_test ( ID, name, address, phone, email) VALUES ( ?,?,?,?,?)";
//                String query = "INSERT INTO finished_goods ( FG_PART_UNIQUE_ID,  FG_PART_NO, PART_NAME ) VALUES ( ?,?,?  )";
//
//                // pst = con.prepareStatement ( query );
//            //    InputStream fileinput=filepart.getInputStream();
//              //  fis = new FileInputStream(dir);
//                System.out.println(fis);
//                System.out.println("\n"+uploadpath);
//
//                System.out.println("here importing dtaa\n");
//                HSSFWorkbook my_xls_workbook = new HSSFWorkbook(fis);
//                HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
//
//                Iterator<Row> rowIterator = my_worksheet.iterator();
//
//                while (rowIterator.hasNext()) {
//                    Row row = rowIterator.next();
//
//                    String[] dataRow = new String[8];
//                    Cell c=row.getCell(1);
//                    if(c!=null && c.getCellType()!=Cell.CELL_TYPE_BLANK) {
//
//                    try {
//                        //  pst.setString ( 1 , row.getCell ( 0 ).getStringCellValue () );
//                        dataRow[0] = row.getCell(0).getStringCellValue();
//                    } catch (Exception e2) {
//                        try {
//                            //  pst.setInt ( 1 , ( int ) row.getCell ( 0 ).getNumericCellValue () );
//                            dataRow[0] = row.getCell(0).getNumericCellValue() + "";
//
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    try {
//                        //    pst.setString ( 2 , row.getCell ( 1 ).getStringCellValue () );
//                        dataRow[1] = row.getCell(1).getStringCellValue() + "";
//                    } catch (Exception e2) {
//                        try {
//                            //        pst.setInt ( 2 , ( int ) row.getCell ( 1 ).getNumericCellValue () );
//                            dataRow[1] = row.getCell(1).getNumericCellValue() + "";
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    try {
//                        //    pst.setString ( 3 , row.getCell ( 2 ).getStringCellValue () );
//                        dataRow[2] = row.getCell(2).getStringCellValue() + "";
//                    } catch (Exception e2) {
//                        try {
//                            //        pst.setInt ( 3 , ( int ) row.getCell ( 2 ).getNumericCellValue () );
//                            dataRow[2] = row.getCell(2).getNumericCellValue() + "";
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    try {
//                        //    pst.setString ( 3 , row.getCell ( 2 ).getStringCellValue () );
//                        dataRow[3] = row.getCell(3).getStringCellValue() + "";
//                    } catch (Exception e2) {
//                        try {
//                            //        pst.setInt ( 3 , ( int ) row.getCell ( 2 ).getNumericCellValue () );
//                            dataRow[3] = row.getCell(3).getNumericCellValue() + "";
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    try {         
//                        //    pst.setString ( 4 , row.getCell ( 3 ).getStringCellValue () );
//                        dataRow[4] = row.getCell(4).getStringCellValue();
//                    } catch (Exception e2) {
//                        try {
//                            //        pst.setInt ( 4 , ( int ) row.getCell ( 3 ).getNumericCellValue () );
//                            dataRow[4] = row.getCell(4).getNumericCellValue() + "";
//
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    try {
//                        //    pst.setString ( 5 , row.getCell ( 4 ).getStringCellValue () );
//                        dataRow[5] = row.getCell(5).getStringCellValue() + "";
//                    } catch (Exception e2) {
//                        try {
//                            //        pst.setInt (5 , ( int ) row.getCell ( 4 ).getNumericCellValue () );
//                            dataRow[5] = row.getCell(5).getNumericCellValue() + "";
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    try {
//                        //    pst.setString ( 5 , row.getCell ( 4 ).getStringCellValue () );
//                        dataRow[6] = row.getCell(6).getStringCellValue() + "";
//                    } catch (Exception e2) {
//                        try {
//                            //        pst.setInt (5 , ( int ) row.getCell ( 4 ).getNumericCellValue () );
//                            dataRow[6] = row.getCell(6).getNumericCellValue() + "";
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    try {
//                        //    pst.setString ( 5 , row.getCell ( 4 ).getStringCellValue () );
//                        dataRow[7] = row.getCell(7).getStringCellValue() + "";
//                    } catch (Exception e2) {
//                        try {
//                            //        pst.setInt (5 , ( int ) row.getCell ( 4 ).getNumericCellValue () );
//                            dataRow[7] = row.getCell(7).getNumericCellValue() + "";
//                        } catch (Exception e1) {
//                        }
//                    }
//                    }
//                    uploadData.add(dataRow);
//                    System.out.println(dataRow[0]+"\t"+dataRow[1]+"\t"+dataRow[2]+"\t"+dataRow[3]+"\t"+dataRow[4]+"\t"+dataRow[5]+"\t"+dataRow[6]+"\t"+dataRow[7]+"\t");
//                    if(dataRow[1]!=null && dataRow[2]!=null && dataRow[3]!=null && dataRow[4]!=null && dataRow[5]!=null )
//                    {
//                    	if(uploadedcount!=0) {
//		                    try {
//		                    		  String   addEmpAPICall = "machineadd?MACHINE_NO="+URLEncoder.encode(dataRow[1].trim(), "UTF-8")+
//		                    		 "&MAKE="+URLEncoder.encode(dataRow[2].trim(), "UTF-8")+"&BED_SIZE="+URLEncoder.encode("" , "UTF-8")+
//		                    		 "&HEATER_QTY="+URLEncoder.encode("", "UTF-8")+"&YR_OF_COMM="+URLEncoder.encode( "", "UTF-8")+
//		                    		 "&CR_MAINT_RTG="+URLEncoder.encode("", "UTF-8")+
//		                    		 "&MCH_IMG="+URLEncoder.encode( "", "UTF-8")+"&CR_MCH_OWN="+URLEncoder.encode( "", "UTF-8")+
//		                    		 "&MACH_OWN_IMG="+URLEncoder.encode( "", "UTF-8")+"&MCH_BRKD_RCD="+URLEncoder.encode( "", "UTF-8")+
//		                    		 "&PM_ELE="+URLEncoder.encode( "", "UTF-8")+"&PM_MEC="+URLEncoder.encode( "", "UTF-8")+
//		                    		 "&PM_HYD="+URLEncoder.encode( "", "UTF-8")+"&PM_PNM="+URLEncoder.encode( "", "UTF-8")+
//		                    		 "&PM_CLIT="+URLEncoder.encode("", "UTF-8")+"&PRSS_GAUGE="+URLEncoder.encode("", "UTF-8")+
//		                    		 "&TIMER="+URLEncoder.encode("", "UTF-8")+"&OP_RATE_HR="+URLEncoder.encode(dataRow[3].trim(), "UTF-8")+
//		                    		 "&AVL_HRS="+URLEncoder.encode(dataRow[4].trim(), "UTF-8")
//		                    		 +"&DAVLHRS="+URLEncoder.encode(dataRow[5].trim(), "UTF-8")+
//		                    		 "&INSTR_LIST="+URLEncoder.encode("", "UTF-8")+"&EDITED_BY="+URLEncoder.encode("harshal", "UTF-8")+
//		                    		 "&TYPE="+URLEncoder.encode("", "UTF-8"); 
//					                  String   result2 =  WebAPITester.prepareWebCall ( addEmpAPICall);
//					                  if(result2.contains("success"))
//					                  {
//					               	   	String message="\nYour record is successfully save..\n";
//					               	   	System.out.println(message);
//					               	 request.setAttribute("errorMessage",message );
//					     	        rd=request.getRequestDispatcher("/mchin.do");
//					                        
//					                  }
//					                  else {
//					                 	   	System.out.println("Sorry your data not uploaded");
//					               	   	String message="Sorry your data not uploaded";
//
//					                  request.setAttribute("errorMessage",message );
//					      	        rd=request.getRequestDispatcher("/mchin.do");
//					                  }
//		
//		                    }
//		                    catch (UnsupportedEncodingException e) 
//		                    {
//		                    	System.out.println(e);
//		                    }
//                    }
//                   uploadedcount++;
//
//                }
//                    else 
//                    	System.out.println("sheeet consist of null values");
//                    
//             }
//               
//			
//                
//			
//            } catch (IOException ex) {
//                System.out.println("IO  " + ex.getMessage());
//            }
//			uploadedcount=0;
//			 
 	        rd=request.getRequestDispatcher("/mchin.do");
			 rd.forward(request, response);
//
//           
        }
        else if(request.getParameter("Create_QR_code")!=null)
        {
        	System.out.println("Create QR code button click");
        	
        	
        	  rd =request.getRequestDispatcher("/mchin.do");
 			 rd.forward(request, response);
            
         }        
       
    else if(request.getParameter("Delete_Record")!=null)
    {
    	String message=" ";
		String apinamecall="machinedelete?MCH_ID="+URLEncoder.encode(selectedID, "UTF-8");
		   String result21 = WebAPITester.prepareWebCall ( apinamecall );
		   System.out.println("deleting Machine "+result21);
       //    System.out.println("calling shiftupdate id ="+ shifts.get ( i )[ 0 ]  );
		   
    	//response.sendRedirect("Machines.jsp");
		   
		   
		   if(result21.contains("success"))
           {

        	    message="Your record is successfully deleted..";
		        request.setAttribute("errorMessage",message );
		        rd=request.getRequestDispatcher("/mchin.do");
		        rd.forward(request, response);	

           }
           else
           {

        	  message="Unable to delete this record..Please try later";
        	   request.setAttribute("errorMessage",message );
		        rd=request.getRequestDispatcher("/mchin.do");
		        rd.forward(request, response);	
           }
		   
    }
    else
    {
    	
	    String message="Please fill all Fields!!";
			 request.setAttribute("errorMessage",message );
		    	rd =request.getRequestDispatcher("/mchin.do");
			 rd.forward(request, response);
		
    	
     } 
   }



public String getFileName(Part part)
{
	final String partHeader=part.getHeader("content-disposition");
	System.out.println("****partHeader: "+partHeader);
	for(String content: part.getHeader("content-disposition").split(";")) {	
		if(content.trim().startsWith("filename"));
		{
			return content.substring(content.indexOf("=")+1).trim().replace("\"","");
		}
	}
	return null;	
}
	
}