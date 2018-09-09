<sec:authorize access="hasAnyRole('ROLE_ADMIN')">	
		<div id="content">
			<!--  add our HTML table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Service</th>
					<th>Secretary</th>
					<th>Engineer</th>
					<th>Administrator</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="cAdmin" items="${admin}">
					<tr>
						<td>${cAdmin.services}</td>
						<td>${cAdmin.secretary}</td>
						<td>${cAdmin.engineer}</td>
						<td>${cAdmin.administrator}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</sec:authorize>
	