<sec:authorize access="hasAnyRole('ROLE_ENGINEER')">	
	<form
		action="${pageContext.request.contextPath}/engineer/SubmitNextCheck">
		<input style="font-size: 35px" type="submit" value="Submit car's next check">
	</form>
	<br>		 
	<form
		action="${pageContext.request.contextPath}/engineer/HasDamage">
		<input style="font-size: 35px" type="submit" value="Enter car's damage status">
	</form>
	<br>
</sec:authorize>	