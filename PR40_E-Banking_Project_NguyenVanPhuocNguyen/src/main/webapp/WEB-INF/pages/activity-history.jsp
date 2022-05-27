<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
 <%@ taglib prefix="spring" 
	uri="http://www.springframework.org/tags/form"%>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <jsp:include page="guest/css-page.jsp" />
         <jsp:include page="history/css-page.jsp" />
    </head>
    <body>
    <jsp:include page="user/header.jsp"/>
        <jsp:include page="history/activity-history.jsp"/>
        <jsp:include page="user/footer.jsp"/>
            <jsp:include page="history/js-page.jsp"/>
               <jsp:include page="guest/js-page.jsp"/>
    </body>
</html>

