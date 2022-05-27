<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style>
table {
	width: 80%;
}

th, td {
	text-align: left;
	color: white;
	height: 5px;
}
</style>
</head>



<body class="img js-fullheight"
	style="background-image: url(<c:url value="resources/transfer/otp/images/bg.jpg"/>);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h1 class="heading-section">BANK</h1>
					<i class="fa fa-check-circle" style="font-size: 48px; color: white"></i>
					<h2 class="heading-section">TRANSFER SUCCESS</h2>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<table class="table custom-table">
							<tr>
								<th>Account Source:</th>
								<td>${transfer.accountSource}</td>
							</tr>
							<tr>
								<th>Account Target:</th>
								<td>${transfer.accountTarget}</td>
							</tr>
							<tr>
								<th>Account Target Name:</th>
								<td>${account_target_name}</td>
							</tr>
							<tr>
								<th>Amount:</th>
								<td><fmt:formatNumber value="${transfer.amount}"
										type="currency" currencySymbol="VND" /></td>
							</tr>
							<tr>
								<th>Content:</th>
								<td>${transfer.content}</td>
							</tr>
						</table>
						<div class="form-group">
							<form action="account">
								<button class="form-control btn btn-primary submit px-3">Home</button>
							</form>

						</div>


					</div>
				</div>
			</div>
		</div>
	</section>



</body>





