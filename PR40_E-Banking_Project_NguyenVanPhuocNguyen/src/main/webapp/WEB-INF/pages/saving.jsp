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



<!-- </head> -->
<!-- <body> -->


<!-- 	<div class="container-contact100"> -->

<!-- 		<div class="wrap-contact100"> -->
<%-- 		<spring:form action="transferComfirm" method="post" modelAttribute="transfer" class="contact100-form validate-form"> --%>
<!-- 				<span class="contact100-form-title"> -->
<!-- 				Confirm Tranfer -->
<!-- 				</span> -->

<!-- 				<div class="wrap-input100 validate-input" -->
<!-- 					data-validate="Please enter your name"> -->
<%-- 					<input value = "${account_target_name}" placeholder="Account Target" --%>
<!-- 						class="input100" /> -->
<!-- 					<span class="focus-input100"></span> -->
<!-- 				</div> -->

<!-- 				<div class="wrap-input100 validate-input" data-validate="Please enter your name"> -->
<%-- 					<spring:input path="accountTarget" readonly="true"  placeholder="Account Target" class="input100" /> --%>
<!-- 					<span class="focus-input100"></span> -->
<!-- 				</div> -->

<!-- 				<div class="wrap-input100 validate-input" data-validate = "Please enter your email: e@a.x"> -->
<%-- 					<spring:input path="accountSource" value = "${accountId}" readonly="true" placeholder="Account Source" class="input100"/>  --%>
<!-- 					<span class="focus-input100"></span> -->
<!-- 				</div> -->

<!-- 				<div class="wrap-input100 validate-input" data-validate = "Please enter your phone"> -->
<%-- 					<spring:input path="amount"  placeholder="Amount" readonly="true" class="input100" /> --%>
<!-- 					<span class="focus-input100"></span> -->
<!-- 				</div> -->

<!-- 				<div class="wrap-input100 validate-input" data-validate = "Please enter your message"> -->
<%-- 					<spring:textarea class="input100" path="content" readonly="true" placeholder="Content"/> --%>
<!-- 					<span class="focus-input100"></span> -->
<!-- 				</div> -->

<!-- 				<div class="container-contact100-form-btn"> -->
<!-- 					<button class="contact100-form-btn"> -->
<!-- 						<span> -->
<!-- 							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i> -->
<!-- 							Transfer -->
<!-- 						</span> -->
<!-- 					</button> -->
<!-- 				</div> -->
<%-- 			</spring:form> --%>
<!-- 		</div> -->
<!-- 	</div> -->



<!-- 	<div id="dropDownSelect1"></div> -->



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <jsp:include page="user/css-page.jsp" />
         <jsp:include page="transfer/css-page.jsp" />
     
    </head>
    <body>
    <jsp:include page="user/header.jsp"/>
        <jsp:include page="saving/saving-page.jsp"/>
        <jsp:include page="user/footer.jsp"/>
            <jsp:include page="transfer/js-page.jsp"/>
               <jsp:include page="user/js-page.jsp"/>
               
    </body>
</html>