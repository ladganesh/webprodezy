<%@page import="com.mycompany.webprodezy.webcall.*" %>
<%@page import="com.mycompany.webprodezy.rawmaterial.*" %>
<%@page import="com.mycompany.webprodezy.batch.*" %>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>

<%@page import="org.json.*" %>
<%@page import="model.*" %>

	<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
	
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Prod-Ezy Batch Master</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  <link href="css/duration-picker.css" rel="stylesheet">
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="js/duration-picker.js"></script>
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

	<script>

		function removeRequired(form)
		{
		    $.each(form, function(key, value)
		    		{
		        if ( value.hasAttribute("required"))
		        {

		            value.removeAttribute("required");
		        }
		    });
		}		

	</script>  
</head>
<body id="page-top">
<script>
function change(){
if (document.getElementById("checkbox1").checked == true)
    document.getElementById("txtAddress").disabled = false;
else
    document.getElementById("txtAddress").disabled = true;
}
</script>
	<%@include file="homeScreen.html"%>
        <div class="container-fluid">
          <!-- Content Row -->
          <!-- Page Heading -->
		  <form action="${pageContext.request.contextPath}/processmap"method="post" name="FC">
          	<div>
            <div class=s>
              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Process Map Master</h6>
                </div>
                <div class="card-body">
					<p id="demo" style="color:red;">${param.loginMsg}</p>

								<table align="center">
								<tr><input type="checkbox" name="checkbox1" id="checkbox1" onchange="change()">
								check here to create new intermediate raw material else leave unchecked to continue <br>creating a new production batch from available raw material
								<br><br></tr>
									<tr>
									<td width=25%>New Intermediate RM Name</td>
										<td width=25%><input type="text" name="rmname" value="" class="form-control form-control-user" required="required" /></td>
									<td width=25%>New Production Batch Name</td>
										<td><input type="text" name="batchname" value="" class="form-control form-control-user" required="required" /></td>
									</tr>
									<tr>									
									<td>Rm Code/No</td>
									<td> <select id="isFg" class="form-control form-control-user" name="isFg" onkeypress="isKeyPressed(event)">
											<%
												out.print("chk");
							                    List<String[]> al = new RMspinnerData().bomlist2();
												out.print(al.size());
			
								   				for(int i = 0; i < al.size(); i++) 
								   				{
													String id=(String)al.get(i)[2];
								   					String option = (String)al.get(i)[3];
								   					String uom = (String)al.get(i)[2]; %>  	
											
							   				
											<option value="<%= id %>" ><%= option%>
											</option>
											<%	}
										
											%> 
									</select>
									Select raw materials from above  list and put quantity in adjacent field and click add to mixture to save it to the list
									</td>
									
									<td>Select Available Raw Material Batches</td>
									<td> <select id="rm" class="form-control form-control-user" name="rm" onkeypress="isKeyPressed(event)">
											<%
												out.print("chk");
							                    List<String[]> al1 = new RMspinnerData().bomlist2();
												out.print(al1.size());
			
								   				for(int i = 0; i < al.size(); i++) 
								   				{
													String id=(String)al1.get(i)[2];
								   					String option = (String)al1.get(i)[3];
								   					String uom = (String)al1.get(i)[2]; %>  	
											
							   				
											<option value="<%= id %>" ><%= option%>
											</option>
											<%	}
										
											%> 
									</select>
									</td>
									
											
										</tr><tr>

									<td width="20%">Measure		</td>
									<td width="20%"><select class="form-control form-control-user" name="measurement" id="measurement">
													<%   
   				
   				ArrayList<String[]> unit = new RMspinnerData().listUnit();

   				for(int i = 0; i < unit.size(); i++) {
   					
   					String id1=(String)unit.get(i)[0];
   					String option1 = (String)unit.get(i)[1];
   					
 	
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>					</select></td>
								
									

									<td width=20%>Quantity</td>
									<td width=20%><input type="text" name="quantity" placeholder="quantity" value="" class="form-control form-control-user" required="required" /></td>
								<td width=20%><select class="form-control form-control-user" name="measurement" id="measurement">
													<%   
   				
   				ArrayList<String[]> unit1 = new RMspinnerData().listUnit();

   				for(int i = 0; i < unit1.size(); i++) {
   					
   					String id1=(String)unit1.get(i)[0];
   					String option1 = (String)unit1.get(i)[1];
   					
 	
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>					</select></td></tr><tr></tr><tr>
									<td>Resulting Quantity</td>
									<td><input type="text" name="result_quantity" placeholder="resulting quantity" class="form-control form-control-user" required="required" /></td>
							<td><select class="form-control form-control-user" name="measurement" id="measurement">
													<%   
   				
   				ArrayList<String[]> unit2 = new RMspinnerData().listUnit();

   				for(int i = 0; i < unit2.size(); i++) {
   					
   					String id1=(String)unit2.get(i)[0];
   					String option1 = (String)unit2.get(i)[1];
   					
 	
   				%>
   				<option value="<%= id1 %>"><%= option1 %> </option>
   				<% } %>					</select></td></tr><tr>
									<td>Batch Creation date</td>
									<td><input type= date name="creation" id="creation">
									<td>Batch Expiry Date</td>
									<td><input type="date" name="expiry" id="expiry"></td>
									</tr>
								</table>
					<br>
					<div align="center">
						<button class="btn btn-primary" type="submit" name="add" value="Add">Add</button>  <button class="btn btn-primary" type="submit" name="add" value="Load Map" onClick="removeRequired(this.form)">Load Map</button>	<button class="btn btn-primary" type="submit" name="update" value="Update">Update</button>	<button class="btn btn-primary" type="reset" name="reset" value="Reset">Reset</button>	<button class="btn btn-primary" type="submit" name="excel" value="excel">Export</button>	<button class="btn btn-primary" type="submit" name="cancel" value="cancel">Cancel</button> <button class="btn btn-primary"  type="submit" name="delete" value="Delete">Delete</button> <button class="btn btn-primary" type="reset" value="Reset">Reset</button>
					</div>
					<br>
			<div class="card-body">
					<div class="table-responsive">
					   <b>	Available Raw Material and Quantity:</b>
							  <table class="table table-bordered" id="dataTable"  cellspacing="0">
								<thead>
									<tr>
									
									<th></th>
										<th>RM_TYPE</th>
										<th>RM_CLASS</th>
										<th>RM_NAME</th>
										<th>REORDER_LEVEL</th>
										<th>AVAILABLE_STOCK</th>
											
									</tr>
								</thead>
									<tbody>
									<c:forEach items="${rmlist}" var="data"><tr>
						 				<td>${data.RM_ID }</td>
						 				<td>${data.RM_TYPE }</td>
						 				<td>${data.RM_CLASS }</td>
						 				<td>${data.RM_NAME }</td>
						 				<td>${data.REORDER_LEVEL }</td>
						 				<td>${data.CLOSING }</td>  </tr> 
						 				</c:forEach>
								</tbody>	
						   	</table>
						   	</div>
						   	</div>
						   		<div class="card-body">
					<div class="table-responsive">
						   <b>	Available Batches:</b>
							  <table class="table table-bordered" id="dataTable"  cellspacing="0">
								<thead>
									<tr>
										<th>BATCH_ID</th>
										<th>BATCH_NAME</th>
										<th>BATCH_QUANTITY</th>
										<th>BATCH_CREATE_DATE</th>
										<th>BATCH_EXPIRE_DATE</th>
										
											
									</tr>
								</thead>
									<tbody>
									<c:forEach items="${batches}" var="data1">
									<tr>
						 				<td>${data1.BATCH_ID}</td>
						 				<td>${data1.BATCH_NAME}</td>
						 				<td>${data1.BATCH_QTY}</td>
						 				<td>${data1.BATCH_CREATE}</td>
						 				<td>${data1.BATCH_EXPIRE}</td>
						 				</tr>
						 			</c:forEach>
							   	</tbody>	
						   	</table>
				   		</div>
					</div>
				</div>
		        <!-- Footer -->
				<%@include file="footer.html" %>
      			<!-- End of Footer --> 
			</div>
		</div>
		</div>
	</form>
</div>
  <!-- End of Page Wrapper -->

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

  <script src="js/duration-picker.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->

               
  <script src="js/demo/datatables-demo.js"></script>

    <script>
        $(function () {
        	$("#duration1").durationPicker();
        	$("#duration2").durationPicker();
        });
    </script>
</body>
</html>