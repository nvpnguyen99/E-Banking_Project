<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<style>
table {
	width: 80%;
}

th, td {
	text-align: center;
	height: 5px;
	font-size: 12px;
}
</style>
</head>
<body>

	<div id="booking"
		style="background-image: url(<c:url value="resources/transfer/img/hero_2.jpg"/>);"
		class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="col-md-7 col-md-push-5">
						<div class="booking-cta">
							<c:choose>
								<c:when test="${estimate == 'non-term_monthly'}">
									<h2>Non-term saving & Monthly interest payment</h2>
									<div class="table-responsive">

										<table class="table custom-table">
											<thead>
												<tr>
													<th scope="col">Saving Amount</th>
													<th scope="col">Interest Rate</th>
													<th scope="col">Monthly Interest</th>

												</tr>
											</thead>
											<tbody>
												<tr scope="row">
													<td><fmt:formatNumber value="${saving.savingAmount}"
															type="currency" currencySymbol="VND" /></td>
													<td>${savingCategory.interestRate} %</td>
													<td><fmt:formatNumber value="${interestEstimate}"
															type="currency" currencySymbol="VND" /></td>


												</tr>
											</tbody>
										</table>
									</div>
								</c:when>

								<c:when test="${estimate == 'non-term_deferred'}">
									<h3>Non-term saving & Deferred interest payment</h3>
									<div class="table-responsive">

										<table class="table custom-table">
											<thead>
												<tr>
													<th scope="col">Month</th>
													<th scope="col">Saving Amount</th>
													<th scope="col">Interest Rate</th>
													<th scope="col">Total Amount</th>
													<th scope="col">Interest Amount</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${estimateList}" var="item">
													<tr scope="row">
														<td>${item.id}</td>
														<td><fmt:formatNumber value="${saving.savingAmount}"
																type="currency" currencySymbol="VND" /></td>
														<td>${savingCategory.interestRate} %</td>
														<td><fmt:formatNumber value="${item.currentAmount}"
																type="currency" currencySymbol="VND" /></td>
														<td><fmt:formatNumber value="${item.interestAmount}"
																type="currency" currencySymbol="VND" /></td>
													</tr>
												</c:forEach>
												<tr scope="row">
													<td>...</td>
													<td>...</td>
													<td>...</td>
													<td>...</td>
													<td>...</td>
												</tr>
											</tbody>
										</table>
									</div>
								</c:when>

								<c:when test="${estimate == 'term_monthly'}">
									<h2>Term saving & Monthly interest payment</h2>
									<div class="table-responsive">

										<table class="table custom-table">
											<thead>
												<tr>
													<th scope="col">Saving Amount</th>
													<th scope="col">Period</th>
													<th scope="col">Interest Rate</th>
													<th scope="col">Monthly Interest</th>
													<th scope="col">Total Interest</th>

												</tr>
											</thead>
											<tbody>
												<tr scope="row">
													<td><fmt:formatNumber value="${saving.savingAmount}"
															type="currency" currencySymbol="VND" /></td>
													<td>${savingCategory.period}</td>
													<td>${savingCategory.interestRate} %</td>
													<td><fmt:formatNumber value="${interestEstimate}"
															type="currency" currencySymbol="VND" /></td>
													<td><fmt:formatNumber value="${termInterestEstimate}"
															type="currency" currencySymbol="VND" /></td>

												</tr>
											</tbody>
										</table>
									</div>
								</c:when>

								<c:when test="${estimate == 'term_prepaid'}">
									<h2>Term saving & Prepaid interest payment</h2>
									<div class="table-responsive">

										<table class="table custom-table">
											<thead>
												<tr>
													<th scope="col">Saving Amount</th>
													<th scope="col">Period</th>
													<th scope="col">Interest Rate</th>
													<th scope="col">Total Interest Prepaid</th>

												</tr>
											</thead>
											<tbody>
												<tr scope="row">
													<td><fmt:formatNumber value="${saving.savingAmount}"
															type="currency" currencySymbol="VND" /></td>
													<td>${savingCategory.period}</td>
													<td>${savingCategory.interestRate} %</td>
													<td><fmt:formatNumber value="${termInterestEstimate}"
															type="currency" currencySymbol="VND" /></td>

												</tr>
											</tbody>
										</table>
									</div>
								</c:when>

								<c:when test="${estimate == 'term_deferred'}">
									<h3>Term saving & Deferred interest payment</h3>
									<div class="table-responsive">

										<table class="table custom-table">
											<thead>
												<tr>
													<th scope="col">Month</th>
													<th scope="col">Saving Amount</th>
													<th scope="col">Period</th>
													<th scope="col">Interest Rate</th>
													<th scope="col">Total Amount</th>
													<th scope="col">Interest Amount</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${estimateList}" var="item">
													<tr scope="row">
														<td>${item.id}</td>
														<td><fmt:formatNumber value="${saving.savingAmount}"
																type="currency" currencySymbol="VND" /></td>
														<td>${savingCategory.period}</td>
														<td>${savingCategory.interestRate} %</td>
														<td><fmt:formatNumber value="${item.currentAmount}"
																type="currency" currencySymbol="VND" /></td>
														<td><fmt:formatNumber value="${item.interestAmount}"
																type="currency" currencySymbol="VND" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</c:when>

								<c:otherwise>


									<h2>Saving Money</h2>
									<div class="table-responsive">

										<table class="table custom-table">
											<thead>
												<tr>

													<th scope="col"></th>
													<th scope="col">Category Name</th>
													<th scope="col">Period (month)</th>
													<th scope="col">Interest Rate</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${savingCategoryList}" var="item">
													<tr scope="row">
														<td>${item.id}</td>
														<td>${item.name}</td>
														<td>${item.period}</td>
														<td>${item.interestRate} %</td>


													</tr>
												</c:forEach>



											</tbody>
										</table>
									</div>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<div class="col-md-4 col-md-pull-7">
						<div class="booking-form">
							<spring:form action="savings" method="post"
								modelAttribute="saving">



								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<span class="form-label">Savings Account</span>
											<spring:select class="form-control" path="account.id">
												<%-- 		<spring:option value="0">--Select --</spring:option> --%>
												<spring:options items="${sessionScope.accountList}"
													itemLabel="accountId" itemValue="id" />
											</spring:select>
											<span class="select-arrow"></span>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<span class="form-label">savingAmount</span>
											<spring:input path="savingAmount" class="form-control" />
											<span class="select-arrow"></span>
										</div>
									</div>
								</div>
								<c:choose>
									<c:when test="${amountError != null}">
										<div class="form-group" style="color: red;">
											${amountError}</div>
									</c:when>
								</c:choose>
								<div class="form-group">
									<span class="form-label">Saving Category</span>
									<spring:select path="savingCategory.id" class="form-control">
										<spring:option value="0">--Select Category--</spring:option>
										<spring:options items="${savingCategoryList}" itemLabel="name"
											itemValue="id" />
									</spring:select>
									<span class="select-arrow"></span>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<span class="form-label">Interest Payment</span>
											<spring:select path="interestPayment" class="form-control">
												<%-- 		<spring:option value="0">--Select Type--</spring:option> --%>
												<spring:options items="${enums}" />
											</spring:select>
											<span class="select-arrow"></span>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-btn">
											<br> <input class="submit-btn" type="submit"
												name="estimate" value="Estimate" />
										</div>
									</div>
								</div>
								<c:choose>
									<c:when test="${interestPaymentError != null}">
										<div class="form-group" style="color: red;">
											${interestPaymentError}</div>
									</c:when>
								</c:choose>
								<!-- 								<div class="row"> -->
								<!-- 									<div class="col-sm-6"> -->
								<!-- 										<div class="form-group"> -->
								<!-- 											<span class="form-label">Check In</span> -->
								<!-- 											<input class="form-control" type="date" required> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 									<div class="col-sm-6"> -->
								<!-- 										<div class="form-group"> -->
								<!-- 											<span class="form-label">Check out</span> -->
								<!-- 											<input class="form-control" type="date" required> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<!-- 								<div class="row"> -->
								<!-- 									<div class="col-sm-4"> -->
								<!-- 										<div class="form-group"> -->
								<!-- 											<span class="form-label">Rooms</span> -->
								<!-- 											<select class="form-control"> -->
								<!-- 												<option>1</option> -->
								<!-- 												<option>2</option> -->
								<!-- 												<option>3</option> -->
								<!-- 											</select> -->
								<!-- 											<span class="select-arrow"></span> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 									<div class="col-sm-4"> -->
								<!-- 										<div class="form-group"> -->
								<!-- 											<span class="form-label">Adults</span> -->
								<!-- 											<select class="form-control"> -->
								<!-- 												<option>1</option> -->
								<!-- 												<option>2</option> -->
								<!-- 												<option>3</option> -->
								<!-- 											</select> -->
								<!-- 											<span class="select-arrow"></span> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 									<div class="col-sm-4"> -->
								<!-- 										<div class="form-group"> -->
								<!-- 											<span class="form-label">Children</span> -->
								<!-- 											<select class="form-control"> -->
								<!-- 												<option>0</option> -->
								<!-- 												<option>1</option> -->
								<!-- 												<option>2</option> -->
								<!-- 											</select> -->
								<!-- 											<span class="select-arrow"></span> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<div class="form-btn">
									<input class="submit-btn" type="submit" name="submit"
										value="Submit" />
								</div>

							</spring:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->





