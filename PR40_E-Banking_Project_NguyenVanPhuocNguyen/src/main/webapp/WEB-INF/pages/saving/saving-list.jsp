<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<body style = "background-color: #e9cba3;">
	<section class="ftco-section">
		<div class="container" >
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
				  <input type="button" class="button button2" onclick="location.href='savingsPage';" value="Saving" />
				  <input type="button" class="button button3" onclick="location.href='account';" value="Home" />
				</div>
			</div>
			<div class="row">
			<c:choose>
    <c:when test="${amountError != null}">
			<div class="form-group" style="color:red;">
			${amountError}
			</div>
			   </c:when> 
			   </c:choose>
				<div class="col-md-12">
					<div class="table-wrap" style = "background-color: white; border-radius: 25px;">
						<table class="table table-striped">
						  <thead>
						    <tr>
						      <th>Saving Deposit Id</th>
						      <th>Saving Amount</th>
						      <th>Current Amount</th>
						      <th>Money Withdrawal Available</th>
						      <th>Saving Category</th>
						      <th>Expired Date</th>  
						      <th>Status</th>
						       <th></th>
						      <th>InterestPayment</th>
					 		  <th>Create Date</th>
						    </tr>
						  </thead>
						  <tbody>
						    <c:forEach items= "${savingList}" var="item">
						    <tr>
						      <td>${item.savingDepositId}</td>
						      <td><fmt:formatNumber value="${item.savingAmount}" type="currency" currencySymbol="VND"/></td>
						      <td><fmt:formatNumber value="${item.currentAmount}" type="currency" currencySymbol="VND"/></td>
						      <td><fmt:formatNumber value="${item.interestAmount}" type="currency" currencySymbol="VND"/></td>
						      <td>${item.savingCategory.name}</td>
						      <td>${item.expiredDate}</td>
						      <c:choose>
    <c:when test="${item.savingStatus== 'IN_PROCESS'}">
 <td><a href="#" class="btn btn-success" style ="font-size: 12px;">${item.savingStatus}</a></td>
    </c:when>
    <c:when test="${item.savingStatus== 'EXPIRED'}">
 <td><a href="#" class="btn btn-warning" style ="font-size: 12px;">${item.savingStatus}</a></td>
    </c:when>      
    <c:otherwise>
   <td><a href="#" class="btn btn-danger" style ="font-size: 12px;">${item.savingStatus}</a></td>
    </c:otherwise>
</c:choose>
						     <c:choose>
    <c:when test="${item.savingStatus== 'IN_PROCESS'}">
						      <td><a href="withdraw?id=${item.id}" class="btn btn-success" style ="font-size: 10px;">Interest Withdraw</a> <a href="settle?id=${item.id}" class="btn btn-danger" style ="font-size: 10px;">Amount Settle</a></td>
						         </c:when> 
						           <c:when test="${item.interestAmount != 0}">
						      <td><a href="withdraw?id=${item.id}" class="btn btn-success" style ="font-size: 10px;">Interest Withdraw</a> <a href="settle?id=${item.id}" class="btn btn-danger" style ="font-size: 10px;">Amount Settle</a></td>
						         </c:when> 
						          <c:otherwise>
   								<td></td>
   							 </c:otherwise>
								</c:choose>
						      <td>${item.interestPayment}</td>
						      <td>${item.createDate}</td>
						    </tr>
							</c:forEach>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>



	</body>


