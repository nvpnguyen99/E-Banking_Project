<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ page import="java.time.format.DateTimeFormatter" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <title>Transfer History</title>
  </head>
  <body>
  

  <div class="content">

    <div class="container">
      <h2 class="mb-5">Transfer History</h2>
      

      <div class="table-responsive">

        <table class="table table-striped custom-table">
          <thead>
            <tr>
              
              <th scope="col">Account Source</th>
              <th scope="col">Account Target</th>
              <th scope="col">Amount</th>
              <th scope="col">Content</th>
              <th scope="col">Date</th>
     
            </tr>
          </thead>
          <tbody>
        <c:forEach items= "${transferList}" var="item">
            <tr scope="row"> 
                      <td>
                        ${item.accountSource}
                      </td>
                      <td>  ${item.accountTarget}</td>
                      <td>
                      
                         <c:choose>
    <c:when test="${item.accountSource== sessionScope.account.accountId}">
-<fmt:formatNumber value="${item.amount}" type="currency" currencySymbol="VND"/>
        <br />
    </c:when>    
    <c:otherwise>
      +<fmt:formatNumber value="${item.amount}" type="currency" currencySymbol="VND"/>
        <br />
    </c:otherwise>
</c:choose>
<!--                         <small class="d-block">Far far away, behind the word mountains</small> -->
                      </td>
                      <td>  ${item.content}</td>
                      <td> ${item.transferDateTime.format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))} </td>

            
            </tr>
		</c:forEach>
            
          </tbody>
        </table>
      </div>


    </div>

  </div>
    
    

 
  </body>
</html>