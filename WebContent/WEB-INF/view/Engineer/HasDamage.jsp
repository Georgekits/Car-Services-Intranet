<sec:authorize access="hasAnyRole('ROLE_ENGINEER')">	
	<div>
		<form:form action="UpdatedDamage" method="POST" class="ui form">
			<p>
				Enter car's plate: <input type="text" name="plate">
			<p>
				Enter damage status: <select name="damage">
						<option value="yes">Has Damage</option>
						<option value="no">Absolutely fine</option>
					</select>
			<p>
				<input type="submit">
		</form:form>
		
	</div>
</sec:authorize>