<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body class="img js-fullheight"
	style="background-image: url(<c:url value="resources/transfer/otp/images/bg.jpg"/>);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">OTP COMFIRM</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<h3 class="mb-4 text-center">An OTP code has been sent to
							email: ${email}</h3>
						<spring:form action="transferComfirmOTP" method="post"
							modelAttribute="transfer" class="signin-form">
							<div class="form-group">

								<spring:input path="accountSource" hidden="true" readonly="true"
									class="form-control" />

							</div>


							<div class="form-group">

								<spring:input path="accountTarget" hidden="true" readonly="true"
									class="form-control" />
							</div>



							<div class="form-group">

								<input value="${account_target_name}" hidden="true"
									class="form-control" readonly="true" />
							</div>

							<div class="form-group">

								<spring:input path="amount" hidden="true" class="form-control" />
							</div>


							<div class="form-group">

								<spring:textarea class="form-control" hidden="true"
									path="content" placeholder="Content" />
							</div>



							<div class="form-group">
								<spring:input type="text" path="captcha" hidden="true"
									required="required" style="margin-top: 5px;"
									class="form-control" placeholder="Captcha Code" />
							</div>



							<div class="form-group">

								<spring:input class="form-control" path="otp" placeholder="otp" />
							</div>
							<div class="form-group">${otpError}</div>

							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3">Tranfer</button>
							</div>

						</spring:form>
					</div>
				</div>
			</div>
		</div>
	</section>



</body>





