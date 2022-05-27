<%-- 
    Document   : welcomePage
    Created on : Jun 9, 2020, 10:09:35 AM
    Author     : ldanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <jsp:include page="user/css-page.jsp" />
    </head>
    <body>
      <jsp:include page="user/header.jsp"/>
        <jsp:include page="user/user-page.jsp"/>
        <jsp:include page="user/footer.jsp"/>
            <jsp:include page="user/js-page.jsp"/>
    </body>
</html>