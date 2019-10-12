
<%@page import="com.mycompany.webprodezy.processmaster.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Prod-Ezy Process Master</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

	<script>
		function isKeyPressed(event) {
  			var text = "";
 		    document.getElementById("demo1").innerHTML = text;
 		   document.getElementById("demo2").innerHTML = text;
		}

	
		
	</script>
	<script>
/* 	$(document).ready(function () 
			{
	    $('#checkBtn').click(function() 
	    		{
	     // checked = $("input[type=checkbox]:checked").length;
	    checked = document.FC.Batch.checked || document.FC.Item.checked

	      if(!checked) 
	      {
	        alert("You must check at least one checkbox.");
	        return false;
	      }
	      else {
			return true;
		}

	    });
	}); */
	
	</script>  
</head>
    <body id="page-top">

	<%@include file="homeScreen.html"%>
        <div class="container-fluid">
          <!-- Content Row -->
          <!-- Page Heading -->
			<form action="ProcessMasteradd" method="post">
          <div >

            <div class=s>

              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Process Master</h6>
                </div>
                           			  <p id="demo1" style="color:red;" align="center">${errormessage}</p>
                
                <div class="card-body">
					<table align="center">

					<tr>
						<td>Process Name</td>
						<td><input type="text" name="process_name" id="process_name" class="form-control form-control-user" value=""size="45" required="required" /></td>
					</tr>
					<tr>
						<td>Process Type</td>
						<td><input type="checkbox" name="check_batch" id="check_batch" value="true" >Batch Wise <br>
						<input type="checkbox" name="check_item" id="check_item" value="true"  >Item Wise<br></td>
					</tr>
					<tr>
						<td>Process Details</td>
						<td><textarea name="details" id="details" class="form-control form-control-user" rows="4" cols="35"></textarea></td>
					<td><input type="hidden" name="id"id="id"></td>
					</tr>
				
					</table>
					
					<br>
					<div align="center">
						<button  type="submit" class="btn btn-primary" name="add_process" id="add_process">Add To Master</button>				    
						<button  type="submit" class="btn btn-primary" name="edit_process" id="edit_process">Edit Process</button>        			
						<button  type="submit" class="btn btn-primary" name="delete_process" id="delete_process">Delete Process</button>        			
						
						<button  type="reset" class="btn btn-primary" name="reset">Reset Form</button>					
						<button  type="button" class="btn btn-primary" name="cancel">Cancel</button>
					</div>

			<div class="card-body">
					<div class="table-responsive">
							  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
									<tr>
									<th></th>
										<th>Process Name</th>
										<th>Process Details</th>
										<th>Is Batch_Wise</th>
										<th>Is Item_Wise</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${processmaster}" var ="data">
							         		<tr>
							                    <td style="visibility:hidden;">${data.PROCESS_ID }</td>
							                    <td>${data.PROCESS_NAME}</td>
							                    <td>${data.PROCESS_DETAILS}</td>
							                    <td>${data.IS_BATCH}</td>
							                    <td>${data.IS_ITEM}</td>
							               							                   
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
            <span aria-hidden="true">Ã</span>
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
<script>

var  table=document.getElementById('dataTable'),rIndex;
for(var i=0;i<table.rows.length;i++)
	{
		table.rows[i].onclick=function()
		{
				
				rIndex=this.rowIndex;
			
				//console.log(rIndex);
				var flag=this.cells[0].innerHTML;
				<c:forEach items="${processmaster}" var="data">
				
					console.log(flag);
		
				if(flag==${data.PROCESS_ID})
				{
/* 					console.log("here     ............");
 */				
					
						document.getElementById("id").value="${data.PROCESS_ID}";
						document.getElementById("process_name").value="${data.PROCESS_NAME}";
		  				document.getElementById("details").value="${data.PROCESS_DETAILS}";
		  				if("${data.IS_BATCH}"=="Yes")
		  					document.getElementById("check_batch").checked=true;
		  				else
		  					document.getElementById("check_batch").checked=false;

		  				if("${data.IS_ITEM}"=="Yes")
		  					document.getElementById("check_item").checked=true;
		  				else
		  					document.getElementById("check_item").checked=false;
		
		  				
	
				}
				</c:forEach>
		};
	}  
	
		


</script>
</body>
</html>