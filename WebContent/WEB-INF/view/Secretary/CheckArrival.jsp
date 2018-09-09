<sec:authorize access="hasAnyRole('ROLE_SECRETARY')">
	<div id="container">
		<div id="content">
			<form:form  action="CheckedArrival" method="POST" class="ui form">
		   		<p>Plate:   <input type="text" name="plate">
		   		<p><input type="submit">
			</form:form>
		</div>
	</div>
</sec:authorize>
<% if(request.getParameter("answer") == null){
	out.println("");
} else{
	out.println("<b>"+request.getParameter("answer")+"</b>");
}
%>