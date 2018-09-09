<sec:authorize access="hasAnyRole('ROLE_ADMIN')">	
	<div>
	   <form:form  action="SaveUser" method="POST" class="ui form">
	   		<p>Username:   <input type="text" name="username">
	   		<p>Password:   <input type="text" name="password">
	   		<p>Role:       
				<select name="role">
  					<option value="ROLE_ENGINEER">Engineer</option>
  					<option value="ROLE_SECRETARY">Secretary</option>
				</select>
   			<p><input type="submit">
  		</form:form>
	</div>
</sec:authorize>