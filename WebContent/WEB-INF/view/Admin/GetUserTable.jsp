<sec:authorize access="hasAnyRole('ROLE_ADMIN')">	
	<div id="container">
		<div id="content">
			<!--  add our HTML table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					<th>Password</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="cAdmin" items="${admin}">
					<tr>
						<td>${cAdmin.username}</td>
						<td>${cAdmin.password}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</sec:authorize>
	