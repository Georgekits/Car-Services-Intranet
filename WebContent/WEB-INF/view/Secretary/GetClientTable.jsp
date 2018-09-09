<sec:authorize access="hasAnyRole('ROLE_SECRETARY')">
	<div id="container">
		<div id="content">
			<!--  add our HTML table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>Debt</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="secretary" items="${secretary}">
					<tr>
						<td>${secretary.username}</td>
						<td>${secretary.password}</td>
						<td>${secretary.debt}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</sec:authorize>