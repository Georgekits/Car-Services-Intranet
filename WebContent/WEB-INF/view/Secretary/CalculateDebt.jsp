<sec:authorize access="hasAnyRole('ROLE_SECRETARY')">
	<div id="container">
		<div id="content">
			<form:form  action="CalculatedDebt" method="POST" class="ui form">
		   		<p>Plate:   <input type="text" name="plate">
		   		<p><input type="submit">
			</form:form>
		</div>
	</div>
</sec:authorize>
<% if(request.getParameter("result") == null){
	out.println("");
} else{
	out.println("<b>"+request.getParameter("result")+"</b>");
}
%>