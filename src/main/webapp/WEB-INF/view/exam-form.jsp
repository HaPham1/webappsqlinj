<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Exam Registration Form</title>

	<!--  Inline CCS -->
	<style>
		.error {color:red}
	</style>

</head>
<body>

	<form:form action="${pageContext.request.contextPath}/workout/examForm" 
		modelAttribute="exam" >
		Area: <form:input path="area" />
		<form:errors path="area" cssClass="error" />
		
		<br><br>
		
		Question: <form:input path="question" />
		<form:errors path="question" cssClass="error" />
		
		<br><br>
		
		Answer: <form:input path="answer" />
		<form:errors path="answer" cssClass="error" />
		
		<br><br>
		
		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>
