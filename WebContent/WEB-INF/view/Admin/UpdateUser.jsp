<sec:authorize access="hasAnyRole('ROLE_ADMIN')">	
	<div>
	   <form:form  action="ModifiedUser" method="POST" class="ui form">
	   		<p>What do you want to update</p>
	   		<select name="column">
  					<option value="password">password</option>
					<option value="role">role</option>
			</select>
	   		<p>Enter new value: <input type="text" name="value">
	   		<p>If you want to change role the available options are 'ROLE_ENGINEER' and 'ROLE_SECRETARY'</p>
	   		<p>Enter existent username: <input type="text" name="existUsername">
	   		<p><input type="submit">
	   </form:form>
   </div>
</sec:authorize>