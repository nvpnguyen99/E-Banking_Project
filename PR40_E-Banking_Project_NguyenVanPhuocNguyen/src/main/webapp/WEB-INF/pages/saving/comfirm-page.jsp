<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>	

<head>
<style>
table{
 	
  width :80%;

}

th,td{

text-align: center;

height: 5px;
font-size: 12px;
}

</style>
</head>
<body>
	<div id="booking" style="background-image: url(<c:url value="resources/transfer/img/hero_2.jpg"/>);" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="col-md-7 col-md-push-5">
						<div class="booking-cta" >
							<h2>Saving Money</h2>
							 <div class="table-responsive">

        <table class="table custom-table" >
          <thead>
            <tr >
              
              <th scope="col"></th>
              <th scope="col">Category Name</th>
              <th scope="col">Period (month)</th>
              <th scope="col">Interest Rate</th>
           
            </tr>
          </thead>
          <tbody>
        <c:forEach items= "${savingCategoryList}" var="item">
            <tr scope="row"> 
                      <td>
                        ${item.id}
                      </td>
                      <td>  ${item.name}</td>
                      <td>  ${item.period}</td>
                      <td>  ${item.interestRate} %</td>
                    
            
            </tr>
		</c:forEach>
          </tbody>
        </table>
      </div>
      
      
						</div>
					</div>
					<div class="col-md-4 col-md-pull-7">
	<div class="booking-form">
							<spring:form action="savingComfirm" method="post" modelAttribute="saving">
								
							
								
								<div class="row">
									<div class="col-sm-6">
													<div class="form-group">
									<span class="form-label">Savings Account</span>
									<input value="${saving.account.accountId}" class="form-control" readonly="true"/>
									<spring:input path="account.id" hidden="true" class="form-control" readonly="true"/>
								</div>
									</div>
									<div class="col-sm-6">
							<div class="form-group">
											<span class="form-label">savingAmount</span>
			<spring:input path="savingAmount" class="form-control" readonly="true"/>
		<span class="select-arrow"></span>
										</div>	
									</div>
								</div>

								<div class="form-group">
								<span class="form-label">Saving Category</span>
					<input value="${saving.savingCategory.name} " class="form-control" readonly="true"/>
					<spring:input path="savingCategory.id" hidden="true" class="form-control" readonly="true"/>
		</div>
		<div class="row">
		<div class="col-sm-6">
						<div class="form-group">
								<span class="form-label">Interest Payment</span>
<spring:input path="interestPayment" class="form-control" readonly="true"/>
		</div>
		</div>
		<div class="col-sm-6">
		<span class="form-label">Interest Rate</span>
	<input value="${saving.savingCategory.interestRate} %" class="form-control" readonly="true"/>
		</div>
			</div>
			<c:choose>
    <c:when test="${interestPaymentError != null}">
			<div class="form-group" style="color:red;">
			${interestPaymentError}
			</div>
			   </c:when> 
			   </c:choose>

								
								<div class="form-group">
									<span class="form-label">description</span>
										<spring:textarea class="form-control" path="description" placeholder="Content" required="required"/>
								</div>	
								<img src="${pageContext.request.contextPath }/captcha">
													<div class="row">
														<div class="col-sm-6">
																		<div class="form-group">
													<spring:input type="text" path="captcha" required="required" style="margin-top: 5px;" class="form-control" placeholder="Captcha Code"/>
													</div>
																	</div>
														<div class="col-sm-6">
																		<div class="form-group">			
													${captcharError}
													</div>
																	</div>
																		</div>				
								<div class="form-btn">
								<input class="submit-btn" type="submit" name="submit" value="Submit" />
								</div>
									
							</spring:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->





