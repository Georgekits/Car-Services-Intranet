<sec:authorize access="hasAnyRole('ROLE_SECRETARY')">
	<div>
	   <form:form  action="DeletedAuto" method="POST" class="ui form">
	   		<p>Plate:   <input type="text" name="plate">
	   		<p><input type="submit">
	   </form:form>
   </div>
</sec:authorize>