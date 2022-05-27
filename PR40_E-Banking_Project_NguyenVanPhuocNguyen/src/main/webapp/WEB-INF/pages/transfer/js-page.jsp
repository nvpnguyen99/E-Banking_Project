
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--===============================================================================================-->
	<script src="<c:url value="resources/transfer/vendor/jquery/jquery-3.2.1.min.js"/> "></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/transfer/vendor/animsition/js/animsition.min.js"/> "></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/transfer/vendor/bootstrap/js/popper.js"/> "></script>
	<script src="<c:url value="resources/transfer/vendor/bootstrap/js/bootstrap.min.js"/> "></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/transfer/vendor/select2/select2.min.js"/> "></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});

			$(".js-select2").each(function(){
				$(this).on('select2:close', function (e){
					if($(this).val() == "Please chooses") {
						$('.js-show-service').slideUp();
					}
					else {
						$('.js-show-service').slideUp();
						$('.js-show-service').slideDown();
					}
				});
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/transfer/vendor/daterangepicker/moment.min.js"/> "></script>
	<script src="<c:url value="resources/transfer/vendor/daterangepicker/daterangepicker.js"/> "></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/transfer/vendor/countdowntime/countdowntime.js"/> "></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/transfer/vendor/noui/nouislider.min.js"/> "></script>
	<script>
	    var filterBar = document.getElementById('filter-bar');

	    noUiSlider.create(filterBar, {
	        start: [ 1500, 3900 ],
	        connect: true,
	        range: {
	            'min': 1500,
	            'max': 7500
	        }
	    });

	    var skipValues = [
	    document.getElementById('value-lower'),
	    document.getElementById('value-upper')
	    ];

	    filterBar.noUiSlider.on('update', function( values, handle ) {
	        skipValues[handle].innerHTML = Math.round(values[handle]);
	        $('.contact100-form-range-value input[name="from-value"]').val($('#value-lower').html());
	        $('.contact100-form-range-value input[name="to-value"]').val($('#value-upper').html());
	    });
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/transfer/js/main.js"/> "></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>