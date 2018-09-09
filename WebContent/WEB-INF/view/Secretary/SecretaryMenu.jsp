<sec:authorize access="hasAnyRole('ROLE_SECRETARY')">
		<form
			action="${pageContext.request.contextPath}/secretary/AddAuto">
			<input style="font-size: 35px" type="submit" value="Add a car">
		</form>
		<br>		 
		<form
			action="${pageContext.request.contextPath}/secretary/DeleteAuto">
			<input style="font-size: 35px" type="submit" value="Delete a car">
		</form>
		<br>
		<form
			action="${pageContext.request.contextPath}/secretary/UpdateAuto">
			<input style="font-size: 35px" type="submit" value="Update info of a car">
		</form>
		<br>
		<form
			action="${pageContext.request.contextPath}/secretary/CheckPlate">
			<input style="font-size: 35px" type="submit" value="Check for plate">
		</form>
		<br>
		
		<form
			action="${pageContext.request.contextPath}/secretary/CheckInsurance">
			<input style="font-size: 35px" type="submit" value="Check for Insurance">
		</form>
		<br>
		
		
		<form
			action="${pageContext.request.contextPath}/secretary/CheckArrival">
			<input style="font-size: 35px" type="submit" value="Check for Arrival">
		</form>
		<br>
		 
		<form
			action="${pageContext.request.contextPath}/secretary/GetClientTable">
			<input style="font-size: 35px" type="submit" value="Print all clients">
		</form>
		<br>
		<form
			action="${pageContext.request.contextPath}/secretary/CalculateDebt">
			<input style="font-size: 35px" type="submit" value="Calculate debt">
		</form>
		<br>
</sec:authorize>