<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
							<spring:form action="transferComfirm" method="post"
								modelAttribute="transfer">

								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<span class="form-label">Account Source</span>
											<spring:input path="accountSource" readonly="true"
												class="form-control" />
											<span class="select-arrow"></span>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<span class="form-label">Account Target</span>
											<spring:input path="accountTarget" readonly="true"
												class="form-control" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<span class="form-label">Account Target Name</span> <input
										value="${account_target_name}" class="form-control"
										readonly="true" />
								</div>

								<div class="form-group">
									<span class="form-label">Amount</span>
									<spring:input path="amount" type="number" class="form-control" />
								</div>
								<c:choose>
									<c:when test="${amountError != null}">
										<div class="form-group" style="color: red;">
											${amountError}</div>
									</c:when>
								</c:choose>
								<div class="form-group">
									<span class="form-label">Content</span>
									<spring:textarea class="form-control" path="content"
										placeholder="Content" required="required"/>
								</div>
								<img src="${pageContext.request.contextPath }/captcha">
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<spring:input type="text" path="captcha" required="required"
												style="margin-top: 5px;" class="form-control"
												placeholder="Captcha Code" />
										</div>
									</div>
									<div class="col-sm-6">
										<div style="color:red;" class="form-group">${captcharError}</div>
									</div>
								</div>
								<div class="form-btn">
									<button class="submit-btn">Comfirm Transfer</button>
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




