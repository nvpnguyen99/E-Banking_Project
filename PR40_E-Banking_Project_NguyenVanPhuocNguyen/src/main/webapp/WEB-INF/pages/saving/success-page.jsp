<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style>
table {
	width: 100%;
}

th {
	text-align: left;
	color: white;
	height: 5px;
	width: 200px;
}

td {
	text-align: right;
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
					<h2 class="heading-section">SAVING SUCCESS</h2>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4" style="">
					<div class="login-wrap p-0">
						<table class="table custom-table">
							<tr>
								<th>Saving Deposit ID:</th>
								<td>${saving.savingDepositId}</td>
							</tr>
							<tr>
								<th>Amount:</th>
								<td><fmt:formatNumber value="${saving.savingAmount}"
										type="currency" currencySymbol="VND" /></td>
							</tr>
							<tr>
								<th>Category:</th>
								<td>${saving.savingCategory.name}</td>
							</tr>
							<tr>
								<th>Interest Rate:</th>
								<td>${saving.savingCategory.interestRate}%</td>
							</tr>
							<tr>
								<th>Create Date:</th>
								<td>${saving.createDate}</td>
							</tr>
							<tr>
								<th>Expired Rate:</th>
								<td>${saving.expiredDate}</td>
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





