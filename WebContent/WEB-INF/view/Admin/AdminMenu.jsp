<sec:authorize access="hasAnyRole('ROLE_ADMIN')">	
	<form
		action="${pageContext.request.contextPath}/admin/AddUser">
		<input style="font-size: 35px" type="submit" value="Add a user">
	</form>
	<br>
	<form
		action="${pageContext.request.contextPath}/admin/DeleteUser">
		<input style="font-size: 35px" type="submit" value="Delete a user">
	</form>
	<br>
	<form
		action="${pageContext.request.contextPath}/admin/UpdateUser">
		<input style="font-size: 35px" type="submit" value="Update a user">
	</form>
	<br>
	<form
		action="${pageContext.request.contextPath}/admin/CheckUser">
		<input style="font-size: 35px" type="submit" value="Check for user">
	</form>
	<br>
	<form
		action="${pageContext.request.contextPath}/admin/GetUserTable">
		<input style="font-size: 35px" type="submit" value="Print all users">
	</form>
	<br>
	<form
		action="${pageContext.request.contextPath}/admin/AddService">
		<input style="font-size: 35px" type="submit" value="Add a service">
	</form>
	<br>
	<form
		action="${pageContext.request.contextPath}/admin/DeleteService">
		<input style="font-size: 35px" type="submit" value="Delete a service">
	</form>
	<br>
	<form
		action="${pageContext.request.contextPath}/admin/UpdateService">
		<input style="font-size: 35px" type="submit" value="Update a service">
	</form>
	<br>	
	<form
		action="${pageContext.request.contextPath}/admin/GetPermissionsTable">
		<input style="font-size: 35px" type="submit" value="Print all services">
	</form>
</sec:authorize>
