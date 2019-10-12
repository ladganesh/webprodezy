
<%@page import="com.mycompany.webprodezy.utility.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


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

  <title>Prod-Ezy Utility</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<!--  <style #table {display:none;}></style>
 --></head>  
<body id="page-top">
	
	 <%@include file="homeScreen.html" %>
	<div class="container-fluid">

     <!-- Page Heading -->
   <form action="UtilityADD" method="post">
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
				    <td><select name="utility_name"  id="choice" class="form-control form-control-user" ">
						<option value="grade" selected="selected">Grades</option>
						<option value="designation">Designations</option>
						<option value="departments">Departments</option>
						<option value="salary">Salary Band</option>
						<option value="uom">Unit of Measurements</option>
						<option value="role">Roles</option>
						<option value="machine">Machines</option>
						
					</select></td>
 				</tr>
				<tr>
					<td><input type="text" class="form-control form-control-user" name="utilityname" id="utilityname"/></td>
 				</tr>
 				<tr>
 						<td><input type="hidden" class="form-control form-control-user" name="id" id="id" /></td>
 				
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
		
		<th width="50%" align="center" >Ref_ID</th>
		<th width="50%">Master Name</th>
		
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${deptlist}" var="data">
		
         		<tr class="departments">
                 <td > ${data.id}     </td> 
     			 <td>  ${	data.name} </td>                   
                </tr>
                </c:forEach>
			<c:forEach items="${desglist}" var="data">
         		<tr class="designation">
                 <td > ${data.id}     </td> 
     			 <td>  ${data.name} </td>                   
                </tr>
                </c:forEach>
                <c:forEach items="${grade}" var="data">
         		<tr class="grade">
                 <td > ${data.id}     </td> 
     			 <td>  ${data.name} </td>                   
                </tr>
                </c:forEach>
                <c:forEach items="${role}" var="data">
         		<tr class="role">
                 <td > ${data.id}     </td> 
     			 <td>  ${data.name} </td>                   
                </tr>
                </c:forEach>
                <c:forEach items="${uom}" var="data">
         		<tr class="uom">
                 <td > ${data.id}     </td> 
     			 <td>  ${data.name} </td>                   
                </tr>
                </c:forEach>
                <c:forEach items="${salary}" var="data">
         		<tr class="salary">
                 <td > ${data.id}     </td> 
     			 <td>  ${data.name} </td>                   
                </tr>
                </c:forEach>
                <c:forEach items="${machine}" var="data">
         		<tr class="machine">
                 <td > ${data.id}     </td> 
     			 <td>  ${data.name} </td>                   
                </tr>
                </c:forEach>
               
                
			
   	</tbody>	
   	</table>
 
			</div></div>
			<br>
			<div align="center"> 
         		<input type="submit" class="btn btn-primary" value="Add to Master" name="Add_to_Master" />              
         		<input type="submit" class="btn btn-primary" value="Edit Record"  id="Edit Record" name="Edit Record" /> 
       	     	<input type="submit" class="btn btn-primary" value="Delete Record"  id="Delete Record" name="Delete Record" /> 
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
<script>

	
	//var p=$('#table tbody').detach();
	
 $("#datatable tbody tr").hide();
$("#choice").click(function(){
	  $("#datatable tbody tr").hide();
	  $("#datatable tbody tr."+$(this).val()).show('fast');
	});

	//this JS calls the tablesorter plugin that we already use on our site
$("#datatable").tablesorter( {sortList: [[0,0]]} );</script>
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



<script type="text/javascript">

var  table=document.getElementById('datatable'),rIndex;
for(var i=0;i<table.rows.length;i++)
	{
		table.rows[i].onclick=function()
		{
				
				rIndex=this.rowIndex;
			
				var flag1=this.cells[0].innerHTML;
				var flag2=this.cells[1].innerHTML;
				console.log(flag1);
				console.log(flag2);
				console.log(document.getElementById("choice").value);
				var utility=document.getElementById("choice").value;
			switch(utility){
			case "grade":
						<c:forEach items="${grade}" var="data">
							var flag3="${data.name}";
							console.log("flag3 "+flag3);
		
							if(flag1==${data.id} )
							{
								
									console.log("in for loop1");
									document.getElementById("utilityname").value="${data.name}";
									document.getElementById("id").value="${data.id}";
								
							}
						</c:forEach>
					break;
					
			case "departments":		
				<c:forEach items="${deptlist}" var="data">
				
					if(flag1==${data.id} )
					{
				

						console.log("in for loop2");

						document.getElementById("utilityname").value="${data.name}";
						document.getElementById("id").value="${data.id}";
						
					}
				</c:forEach>
				break;
			case "designation":		
				<c:forEach items="${desglist}" var="data">
				
					if(flag1==${data.id} )
					{
				

						console.log("in for loop2");

						document.getElementById("utilityname").value="${data.name}";
						document.getElementById("id").value="${data.id}";
						
					}
				</c:forEach>
				break;
			case "salary":		
				<c:forEach items="${salary}" var="data">
				
					if(flag1==${data.id} )
					{
				

						console.log("in for loop2");

						document.getElementById("utilityname").value="${data.name}";
						document.getElementById("id").value="${data.id}";
						
					}
				</c:forEach>
				break;
			case "uom":		
				<c:forEach items="${uom}" var="data">
				
					if(flag1==${data.id} )
					{
				

						console.log("in for loop2");

						document.getElementById("utilityname").value="${data.name}";
						document.getElementById("id").value="${data.id}";
						
					}
				</c:forEach>
				break;
			case "machine":		
				<c:forEach items="${machine}" var="data">
				
					if(flag1==${data.id} )
					{
				

						console.log("in for loop2");

						document.getElementById("utilityname").value="${data.name}";
						document.getElementById("id").value="${data.id}";
						
					}
				</c:forEach>
				break;
			case "role":		
				<c:forEach items="${role}" var="data">
				
					if(flag1==${data.id} )
					{
				

						console.log("in for loop2");

						document.getElementById("utilityname").value="${data.name}";
						document.getElementById("id").value="${data.id}";
						
					}
				</c:forEach>
				break;
			}
		};
	}  
	
 </script>



</body>
</html>