<sec:authorize access="hasAnyRole('ROLE_ADMIN')">	
	<div>
	   <form:form  action="RemoveUser" method="POST" class="ui form">
	   		<p>Username:    <input type="text" name="username">
	   		<p><input type="submit">
   		</form:form>
	</div>
</sec:authorize>