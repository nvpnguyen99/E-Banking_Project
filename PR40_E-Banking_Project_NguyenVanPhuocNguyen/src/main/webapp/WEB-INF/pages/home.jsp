<%-- 
    Document   : welcomePage
    Created on : Jun 9, 2020, 10:09:35 AM
    Author     : ldanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <jsp:include page="guest/css-page.jsp" />
    </head>
    <body>
        <jsp:include page="guest/guest-page.jsp"/>
            <jsp:include page="guest/js-page.jsp"/>
    </body>
</html>

