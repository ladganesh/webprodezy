<%@page import="com.mycompany.webprodezy.webcall.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import ="com.mycompany.webprodezy.bom.BomrmDR"	%>
<%@page import="com.mycompany.webprodezy.utility.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@page import="com.mycompany.webprodezy.rawmaterial.*"%>
<%@page import="com.mycompany.webprodezy.processmap.*"%>

<%@page import="org.json.*" %>
<%@page import="com.mycompany.webprodezy.model.*" %>

<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Prod-Ezy Process Map Master</title>

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
/* 
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
 */
	</script> 
	
</head>
<body id="page-top">

	<%@include file="homeScreen.html"%>
        <div class="container-fluid">
          <!-- Content Row -->
          <!-- Page Heading -->
		  <form action="${pageContext.request.contextPath}/Processmapadd"method="post" >
       
            <div class=s>
              <!-- Circle Buttons -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Process Map Master</h6>
                </div>
                <div class="card-body">
					<p id="demo" style="color:red;">${param.loginMsg}</p>

								<table>
									<tr>
									<td>Part Code/No</td>
									<td> <select id="isFg" name="isFg" class="form-control form-control-user"  onclick=fetchData()>
											<%
												out.print("chk");
							                    ArrayList<String[]> al = new SpinnerList().getfgList();
												out.print(al.size());
			
								   				for(int i = 0; i < al.size(); i++) 
								   				{
													String id=(String)al.get(i)[0];
								   					String option = (String)al.get(i)[1];
								   					String uom = (String)al.get(i)[3];

								   					%>
											
							   				
											<option value="<%= id %> " ><%= option%>
											</option>
											<%	}
										
											%> 	
									</select>
									</td>

										<td width=10></td>

									<td>Process</td>
									<td><select id="proc" name="proc" class="form-control form-control-user" name="proc" onkeypress="isKeyPressed(event)" >
											<%   	
										
											
						                    ArrayList<String[]> procList = new SpinnerList().getprocessList();
											out.print(procList.size());
		
							   				for(int i = 0; i < procList.size(); i++) 
							   				{
												String id=(String)procList.get(i)[0];
							   					String option = (String)procList.get(i)[1];
							   				%>
											<option value="<%= id %>"><%= option %>
											</option>
											<% }
											
							   				%> 
									</select></td>
								</tr>
								<tr>
									<td>Machine Type</td>
									<td><select id="machine" name="machine" class="form-control form-control-user"	onkeypress="isKeyPressed(event)" >
											<%   	
											
												out.print("chk");
						                    ArrayList<String[]> machList = new SpinnerList().getMachineList();
											out.print(machList.size());
		
							   				for(int i = 0; i < machList.size(); i++) 
							   				{
												String id=(String)machList.get(i)[0];
							   					String option = (String)machList.get(i)[1];
							   				%>
											<option value="<%= id %>"><%= option %>
											</option>
											<% 
											}
							   				%> 
									</select></td>

										<td width=10></td>

									<td>Die/Tool</td>
									<td><select id="die" name="die" onkeypress="isKeyPressed(event)" class="form-control form-control-user">
											<%   	
											
												out.print("chk");
						                    ArrayList<String[]> dieList = new SpinnerList().getDieList();
											out.print(dieList.size());
		
							   				for(int i = 0; i < dieList.size(); i++) 
							   				{
												String id=(String)dieList.get(i)[0];
							   					String option = (String)dieList.get(i)[1];
							   				%>
											<option value="<%= id %>"><%= option %>
											</option>
												<% }
										
						   				%> 
									</select></td>									
								</tr>
								<tr>
										<td>Setup Time</td>
										<td>
										<input type="text" name="duration1" class="form-control form-control-user" id="duration1" />
										<!-- <select >
									    <option>Secs</option>
									    <option>Mins</option>
									    <option>Hrs</option>
									    </select> --></td>

										<td width=10></td>
			
										<td>Cycle Time</td>
										<td><input type="text" name="duration2" class="form-control form-control-user" id="duration2" />
<!--										<select >
									    <option>Secs</option>
									    <option>Mins</option>
									    <option>Hrs</option>
									    </select>--></td>								
									</tr>
					     			<tr>
										<td>Target output/hour</td>
										<td><input type="text" name="output_hr" id="output_hr" class="form-control form-control-user" value="" size="20"  required="required"/></td>

										<td width=10></td>

										<td>Target output/shift</td>
										<td><input type="text" id="output_shift" name="output_shift" value=""	size="20" class="form-control form-control-user" required="required" /></td>
									
									</tr>
									<tr>
										<td>Target output/day</td>
										<td><input type="text" id="output_day"  name="output_day" value="" class="form-control form-control-user"  required="required"/></td>

										<td width=10></td>
			
										<td>Cost of the RM/IRM <br>after this process</td>
										<td><input type="text" id="cost_rm" name="cost_rm" value="" class="form-control form-control-user" required="required" /></td>
										<td><input type="hidden" id="fgid2" name="fgid2" value="" class="form-control form-control-user"  /></td>
										<td><input type="hidden" id="dieid" name="dieid" value="" class="form-control form-control-user"  /></td>
									
									</tr>
									<tr>
										<td>Maximum permissible<br>rejection/day</td>
										<td><input type="text" id="rejection" name="rejection" value="" class="form-control form-control-user"  required="required"/></td>

										<td width=10></td>
			
										<td>Remark</td>
										<td><textarea rows="2" class="form-control form-control-user" cols="22" name="remark"  id="remark"></textarea></td>
										<td><input type="hidden" id="processid" name="processid" value="" class="form-control form-control-user" s/></td>
										<td><input type="hidden" id="fpm_id" name="fpm_id" value="" class="form-control form-control-user" /></td>
									
									</tr>
								</table>
														<input type="hidden" id="uomid" name="uomid" value="" class="form-control form-control-user" />
				
					<div align="center">
						<button class="btn btn-primary" type="submit" name="add" value="Add">Add</button>  
						<button class="btn btn-primary" type="submit" name="loadmap" value="Load Map" onClick="removeRequired(this.form)">Load Map</button>	
						<button class="btn btn-primary" type="submit" name="update" value="Update">Update</button>	
						<button class="btn btn-primary" type="reset" name="reset" value="Reset">Reset</button>	
						<button class="btn btn-primary" type="submit" name="excel" value="excel">Export</button>	
						<button class="btn btn-primary" type="submit" name="cancel" value="cancel">Cancel</button> 
						<button class="btn btn-primary"  type="submit" name="delete" value="Delete">Delete</button>
						 <button class="btn btn-primary" type="reset" value="Reset">Reset</button>
					</div>
					
			<div class="card-body">
					<div class="table-responsive">
							  <table class="table table-bordered" id="dataTable" >
								<thead>
									<tr>
									<th>Id</th>
										<th>Process</th>
										<th>Machine</th>
										<th>Die/Tool</th>
										<th>Set up Time</th>
										<th>Cycle Time</th>
										<th>Remark</th>
										<th>O/P per hour</th>
										<th>O/P per shift</th>
										<th>O/P per day</th>
										<th>Unit of Part</th>
										<th>Effective value</th>
										<th>Maximum permissible</th>	
									</tr>
								</thead>
						<tbody>
						<tr>
					<!-- 	<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>	
						<td></td>
						<td></td>
						<td></td> -->
						
						</tr>
						</tbody>
						   	</table>   		</div>
					</div>
			</div></form>
			
		        
				<!-- Footer -->
				<%@include file="footer.html" %>
      			<!-- End of Footer --> 
			</div>
		</div>
		</div>
	
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

function fetchData(){
	var i=1;
	
//	var size = '${bomlistsize}';
	//	console.log("size of list "+size);
	var id=document.getElementById("isFg").value;
	/* for(var j=0;j<size;j++)
			document.getElementById(j+1).value="";
	 */
	$("#dataTable tbody tr").hide();	

	<c:forEach items="${processmap}" var="data">
		var bomid;
		console.log("id="+id);
				if(id==${data.ref_fg_id})
				{			$(dataTable).find('tbody').append( "<tr onClick=myfunction(this) >"+"<td>"+"${data.process_id}"+"</td><td>"+"${data.PROCESS_NAME}"+"</td><td>"+"${data.machine}"+"</td><td>"+"${data.die_tool}"+"</td><td>"+"${data.setup_time}"+"</td><td>"+"${data.ideal_cycle}"+"</td><td>"+"${data.remarks}"+"</td><td>"+"${data.tg_hr}"+"</td><td>"+"${data.tg_shift}"+"</td><td>"+"${data.tg_day}"+"</td><td>"+"${data.unit}"+"</td><td>"+"${data.effective}"+"</td><td>"+"${data.permissible}"+"</td><td>"+"${data.ref_fg_id}</tr>" );
				document.getElementById("uomid").value="${data.uom_id}";
						}
					
				
			document.getElementById("uomid").value="${data.uom_id}";
		
	</c:forEach>
	console.log(document.getElementById("uomid").value);
}
 </script>
 
 <script>
 function myfunction(x) {
 	
 	
 	var flag=x.cells[0].innerHTML;
 	
 	<c:forEach items="${processmap}" var="data">
 	console.log("here");	
 		//document.getElementById("isFg").value="${data.ref_fg_id}";
 	//	console.log(document.getElementById("proc").value);
 		console.log(x.rowIndex);
 		if(flag==${data.process_id}){
 		document.getElementById("proc").value="${data.PROCESS_NAME}";
 		document.getElementById("machine").value="${data.machine}";
 		document.getElementById("die").value="${data.die_tool}";
 		document.getElementById("output_hr").value="${data.tg_hr}";
 		document.getElementById("output_shift").value="${data.tg_shift}";
 		document.getElementById("output_day").value="${data.tg_day}";
 		document.getElementById("cost_rm").value="${data.effective}";
 		document.getElementById("rejection").value="${data.permissible}";
 		document.getElementById("processid").value="${data.ref_process_id}"	;
 		document.getElementById("fgid2").value="${data.ref_fg_id}"	;
 		document.getElementById("dieid").value="${data.ref_tool_code}"	;
 		document.getElementById("uomid").value="${data.uom_id}"	;
 		document.getElementById("fpm_id").value="${data.process_id}"	;

 		console.log(document.getElementById("duration1").value)
 		}
// 		document.getElementById("duration2").value="${data.ideal_cycle}";
//	document.getElementById("duration1").value="${data.setup_time}";
 	 	
	
 	</c:forEach>
 	//flag1.style.color="grey";
 	x.style.color="red";
 	
 	//document.getElementById("deleteid").value=flag;
 	//alert("value of flag " +flag);
 // return( x.style.color="grey");

 }
 </script>
   <script>
        $(function () {
        	$("#duration1").durationPicker();
        	$("#duration2").durationPicker();
        });
    </script>
</body></html>