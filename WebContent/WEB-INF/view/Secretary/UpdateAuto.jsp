<sec:authorize access="hasAnyRole('ROLE_SECRETARY')">
<div>
	   <form:form  action="UpdatedAuto" method="POST" class="ui form">
	   		<p>What do you want to update? 
	   		<select name="column">
  					<option value="plate">plate</option>
  					<option value="owner">owner</option>
					<option value="auto_type">auto type</option>
					<option value="last_check">last check</option>
  					<option value="model">model</option>
			</select>
	   		<p>Enter new value: <input type="text" name="value">
	   		<p>Enter existent plate: <input type="text" name="plate">
	   		<p><input type="submit">
	   </form:form>
   </div>
</sec:authorize>