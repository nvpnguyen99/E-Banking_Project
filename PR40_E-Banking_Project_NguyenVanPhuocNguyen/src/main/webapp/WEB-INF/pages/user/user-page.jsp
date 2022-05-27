<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/security/tags" 
           prefix="sec" %>
           	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  
    <div class="site-blocks-cover overlay" style="background-image: url(<c:url value="resources/images/hero_2.jpg"/>);" data-aos="fade" id="home-section">

      <div class="container">
        <div class="row align-items-center justify-content-center">

          
          <div class="col-md-10 mt-lg-5 text-center">
            <div class="single-text owl-carousel">
              <div class="slide">
              <p class="mb-5 desc"  data-aos="fade-up" data-aos-delay="100">Account: ${sessionScope.account.accountId}</p>
                <h1 class="text-uppercase" data-aos="fade-up">Balance</h1>
                <p class="mb-5 desc"  data-aos="fade-up" data-aos-delay="100"><fmt:formatNumber value="${sessionScope.account.balance}" type="currency" currencySymbol="VND"/> </p>
                <div data-aos="fade-up" data-aos-delay="100">
                </div>	
              </div>

              <div class="slide">
                <h1 class="text-uppercase" data-aos="fade-up">Financing Solutions</h1>
                <p class="mb-5 desc"  data-aos="fade-up" data-aos-delay="100">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Provident cupiditate suscipit, magnam libero velit esse sapiente officia inventore!</p>
              </div>

              <div class="slide">
                <h1 class="text-uppercase" data-aos="fade-up">Savings Accounts</h1>
                <p class="mb-5 desc"  data-aos="fade-up" data-aos-delay="100">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Provident cupiditate suscipit, magnam libero velit esse sapiente officia inventore!</p>
              </div>

            </div>
          </div>
            
        </div>
      </div>

      <a href="#next" class="mouse smoothscroll">
        <span class="mouse-icon">
          <span class="mouse-wheel"></span>
        </span>
      </a>
    </div>  

    <div class="site-section" id="next">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-4 text-center" data-aos="fade-up" data-aos-delay="">
            <img src="<c:url value="resources/images/flaticon-svg/svg/001-wallet.svg"/>" alt="Free Website Template by Free-Template.co" class="img-fluid w-25 mb-4">
            <h3 class="card-title"><a href="savingList">Money Savings</a></h3>
            <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
          </div>
          <div class="col-md-4 text-center" data-aos="fade-up" data-aos-delay="100">
            <img src="<c:url value="resources/images/flaticon-svg/svg/004-cart.svg"/>" alt="Free Website Template by Free-Template.co" class="img-fluid w-25 mb-4">
            <h3 class="card-title"><a href="transferPage">Transfer Money</a></h3>
            <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
          </div>
          <div class="col-md-4 text-center" data-aos="fade-up" data-aos-delay="200">
            <img src="<c:url value="resources/images/flaticon-svg/svg/006-credit-card.svg"/>" alt="Free Website Template by Free-Template.co" class="img-fluid w-25 mb-4">
            <h3 class="card-title">Credit / Debit Cards</h3>
            <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
          </div>

        </div>

       

  </div> <!-- .site-wrap -->

  

  
</body>
</html>