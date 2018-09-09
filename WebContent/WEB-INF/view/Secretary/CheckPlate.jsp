<sec:authorize access="hasAnyRole('ROLE_SECRETARY')">
	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<form:form  action="CheckedPlate" method="POST" class="ui form">
		   		<p>Plate:   <input type="text" name="plate">
		   		<p><input type="submit">
		   		
			</form:form>
		</div>
	</div>
</sec:authorize>
<% if(request.getParameter("exist") == null){
	out.println("");
} else{
	out.println("<b>"+request.getParameter("exist")+"</b>");
}
%>
