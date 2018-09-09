<sec:authorize access="hasAnyRole('ROLE_ADMIN')">	
	<div>
	   <form:form  action="UpdatedService" method="POST" class="ui form">
	   		<p>What do you want to update? 
	   		<select name="column">
  					<option value="service">service</option>
  					<option value="secretary">secretary</option>
					<option value="engineer">engineer</option>
					<option value="administrator">administrator</option>
			</select>
	   		<p>Enter new value: <input type="text" name="value">
	   		<p>Enter existent service name: <input type="text" name="existService">
	   		<p><input type="submit">
	   </form:form>
	</div>
</sec:authorize>