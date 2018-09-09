<sec:authorize access="hasAnyRole('ROLE_SECRETARY')">
	<div>
		<form:form  action="SaveAuto" method="POST" class="ui form">		
			<p>
				Plate: <input type="text" name="plate">
			<p>
				Owner: <input type="text" name="owner">
			<p>
				Last check: <input type="text" name="last_check">
			<p>
				Model: <input type="text" name="model">
			<p>
				Auto_type: <select name="auto_type">
					<option value="Car <= 1800cc">Car <= 1800cc</option>
					<option value="Car > 1800cc">Car > 1800cc</option>
					<option value="Truck <= 3t">Truck <= 3t</option>
					<option value="Truck > 3t">Truck > 3t</option>
				</select>
			<p>
				<input type="submit">
		</form:form>
	</div>
</sec:authorize>