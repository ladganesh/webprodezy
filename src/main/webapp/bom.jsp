
<%@page import="com.mycompany.webprodezy.webcall.*" %>
<%@page import ="com.mycompany.webprodezy.bom.BomrmDR"	%>
<%@page import="com.mycompany.webprodezy.utility.*"%>
<%@page import="com.mycompany.webprodezy.rawmaterial.*"%>
<%@page import="org.json.*" %>
<%@page import="model.*" %>
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>
 --%>

<%-- <%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
 --%><html>
<head>
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>

    <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<style>
.selected {
    background-color: blue;
}</style>
  <title>Prod-Ezy Bill Of Material</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<!--  <style #table {display:none;}></style>
 -->

 
 </head>  
<body id="page-top">
	
</script>
	 <%@include file="homeScreen.html" %>
	<div class="container-fluid">

     <!-- Page Heading -->
   <form action="Bomadd" method="post">
    <div>

              <!-- Circle Buttons -->
       <div class="card shadow mb-4" >
           <div class="card-header py-3" >
                  <h6 class="m-0 font-weight-bold text-primary">Utility</h6>
           </div>
                                <p id="demo1" style="color:red;" align="center">${errormessage}</p>

		<div class="card-body">
      
       
          <table align="center">
          <tr>
             	<td>Part Code/No<br><br><br></td>
									<td> <select id="isFg" class="form-control form-control-user" name="isFg"  onclick=fetchdata() >
											<%
												//out.print("chk");
							                    ArrayList<String[]> al = new SpinnerList().getfgList();
												//out.print(al.size());
			
								   				for(int i = 1; i < al.size(); i++) 
								   				{
								   					String assembled=(String)al.get(i)[3];	
								   					if(assembled.equals("0")){
													String id=(String)al.get(i)[0];
								   					String option = (String)al.get(i)[1];
								   					 %>  	
												<option value="<%= id %>"><%= option %>
											</option>
											<%	
								   					}
								   					}
										
											%> 
									</select><br><br>
									</td>
									</tr></table>
									  <div class="col-lg-6 mb-4" style ="text-align:center;">
              <div class="card shadow mb-4" align="center">
									 <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Bill Of Material</h6>
                </div>
									   <div align="center" class="card-body" >
									<table >
											<%
												//out.print("chk");
						                    List<String[]> al1 = new RMspinnerData().bomlist2();
												//out.print(al1.size());
			
								   				for(int i = 0; i < al1.size(); i++) 
								   				{
													String id= al1.get(i)[2];
								   					String option = (String)al1.get(i)[0];
								   					String uom = (String)al1.get(i)[1];

								   					%>  	
												<tr><td><label><%= option   %></label></td><td><input type="text" placeholder="0.0"  id= "<%= id %>" name= "<%= id %>" ><label><%=uom %></label><input type="hidden" id="hidden<%= id %>" name="hidden<%= id %>"><br><br>	
												</td></tr>
											<%	}
										
											%> 
											</table>
									
									
					</div>
					</div>
				</div>
					
 				<table>
 				<tr>
 						<td><input type="hidden" class="form-control form-control-user" name="deleteid" id="deleteid" /></td>
 						<td><input type="hidden" class="form-control form-control-user" name="deleterm" id="deleterm" /></td>
 						
 				</tr>
			</table>
			<br>
			<div class="card-body">

<div class="table-responsive">
			
 <table class="table table-bordered"  id="datatable" width="100%" cellspacing="0" >
	<col width="10">
  		<col width="80">
<thead>
	<tr>
		
		<th width="30%" align="center" >Part Code</th>
		<th width="30%">Raw Material Code</th>
			<th width="30%">Total Wt/Count</th>
		
		
	</tr>
	</thead>
	<tbody id="body">
			
   	</tbody>	
   	</table>
 
			</div></div>
			<br>
			<div align="center"> 
         		<input type="submit" class="btn btn-primary" value="Update" name="Update" />              
       	     	<input type="submit" class="btn btn-primary" value="Delete Record"  id="Delete Record" name="Delete Record" onClick=myFunction2() /> 
       	        <input type="reset" class="btn btn-primary" value="Clear" />                   
         		<input type="button" class="btn btn-primary" value="Cancel" />
			</div>
	</div>
	<!-- Footer -->
		<%@include file="footer.html" %>
      <!-- End of Footer -->    
	</div>
	</div>
  <p id="demo" ></p>
   </form>
</div>



  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>
	
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/datatables-demo.js"></script>

</body>
<script>
function myFunction2()
{
	var k=document.getElementById("deleterm").value;
	alert("Do you really want to delete "+k );
	}
</script>
<script>

function fetchdata(){
	var i=1;
   var bom = '${billofmaterial}';
 	//var id=  bom.get(i)[2];
	
	var size = '${bomlistsize}';
		console.log("size of list "+size);
	var id=document.getElementById("isFg").value;
	for(var j=0;j<size;j++)
			document.getElementById(j+1).value="";
	
	$("#datatable tbody tr").hide();

	<c:forEach items="${billofmaterial}" var="data">
		var bomid;
		console.log("id="+id);
				if(id==${data.FG_ID})
				{
					bomid="hidden"+${data.RM_ID};
					//console.log("bomid hain boss "+bomid);
					document.getElementById(${data.RM_ID}).value="${data.TOTAL_WT}";
					document.getElementById("hidden${data.RM_ID}").value="${data.BOM_ID}";
			//		console.log(document.getElementById("hidden${data.RM_ID}"));
					<c:forEach items="${bomid}" var="data2">
						if(${data2.RM_ID}==${data.RM_ID}){
							$(datatable).find('tbody').append( "<tr   onClick=myfunction(this) ><td >"+"${data.FG_PART_NO}"+"</td><td>"+"${data2.bomrmlable}"+"</td><td>"+"${data.TOTAL_WT}"+"</td><td>"+"${data.BOM_ID}"+"</td></tr>" );
							
						}
					</c:forEach>
				}
			i++;
	
	</c:forEach>
	
	
	//$("#datatable").tablesorter( {sortList: [[0,0]]} );

}
 </script>
 
 <script>

function myfunction(x) {
	
	/*  $(document).ready(function(){
		  $("datatable").find('tbody').css({"color": "blue"});
		}); */

	document.getElementById("body").style.color="grey";
	var flag=x.cells[3].innerHTML;
	var flag2=x.cells[1].innerHTML;
	document.getElementById("deleterm").value=flag2;

	
	//flag1.style.color="grey";
	x.style.color="red";
	
	document.getElementById("deleteid").value=flag;
	//alert("value of flag " +flag);
// return( x.style.color="grey");

}
</script>
</html>