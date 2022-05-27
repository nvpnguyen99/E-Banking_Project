<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<div id="booking"
		style="background-image: url(<c:url value="resources/transfer/img/hero_2.jpg"/>);"
		class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="col-md-7 col-md-push-5">
						<div class="booking-cta">
							<h1>Make your Money Transfer</h1>
							<p>For Corporate customers that need fast money transfer and
								receipt via E-Banking system to any domestic or international
								accounts. For Corporate customers that need legal, safe,
								convenient and fast money remittance to anywhere in the world.</p>
						</div>
					</div>
					<div class="col-md-4 col-md-pull-7">
						<div class="booking-form">
							<spring:form action="transfer" method="post"
								modelAttribute="transfer">



								<div class="form-group">
									<span class="form-label">Account Source</span>
									<spring:select class="form-control" path="accountSource">
										<%-- 		<spring:option value="0">--Select --</spring:option> --%>
										<spring:options items="${sessionScope.accountList}"
											itemLabel="accountId" itemValue="accountId" />
									</spring:select>
									<span class="select-arrow"></span>
								</div>


								<div class="form-group">
									<span class="form-label">Account Target</span>
									<spring:input path="accountTarget" required="required"
										placeholder="Account Target" class="form-control" />
								</div>
								<div style="color:red;" class="form-group">${idError}</div>
								<div class="form-btn">
									<button class="submit-btn">Confirm Transfer</button>
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




