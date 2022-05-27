<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="ISO-8859-1"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<h1>Transfer</h1> -->
<%-- 	<spring:form action="transfer" method="post" modelAttribute="transfer"> --%>
<%-- 		Account Target(*):<spring:input path="accountTarget" /> <spring:errors path="accountTarget"/> --%>
<!-- 		<!-- <input type="text" name="name"/> -->
<!-- 		<br /> -->
<%-- 		Account Source:<spring:input path="accountSource" value = "${accountId}" readonly="true" cssStyle="background-color:grey;" /> --%>
<!-- 		<!-- <input type="text" name="name"/> -->
<!-- 		<br /> -->
<%-- 		Amount(*):<spring:input path="amount" /> --%>
<!-- 		<br /> -->
<%-- 		Content:<spring:input path="content" /> <spring:errors path="content"/> --%>
<!-- 		<br /> -->

<!-- 		<input type="submit" value="transfer"> -->
<%-- 	</spring:form> --%>
<!-- </body> -->
<!-- </html> -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <jsp:include page="guest/css-page.jsp" />
         <jsp:include page="transfer/css-page.jsp" />
    </head>
    <body>
    <jsp:include page="user/header.jsp"/>
        <jsp:include page="transfer/transfer-page.jsp"/>
        <jsp:include page="user/footer.jsp"/>
            <jsp:include page="transfer/js-page.jsp"/>
               <jsp:include page="guest/js-page.jsp"/>
    </body>
</html>
