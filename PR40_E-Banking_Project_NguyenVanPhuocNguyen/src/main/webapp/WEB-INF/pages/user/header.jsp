 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/security/tags" 
           prefix="sec" %>
           
           
<div id="overlayer"></div>
  <div class="loader">
    <div class="spinner-border text-primary" role="status">
      <span class="sr-only">Loading...</span>
    </div>
  </div>


  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
   
    
    <header class="site-navbar js-sticky-header site-navbar-target" role="banner" ">
      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-6 col-xl-2">
            <div class="mb-0 site-logo"><a href="index.html"> ${sessionScope.account.userEntity.name}</a></div>
          </div>

          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">

              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block"> 
                <li><a href="<c:url value="/account" />" class="nav-link">Home</a></li>
                <li class="has-children">
                  <a href="#about-section" class="nav-link">Account</a>
                  <ul class="dropdown">
                  <c:forEach items="${sessionScope.accountList}" var="item">
                    <li><a href="accountChoice?accountId=${item.accountId}" class="nav-link"> ${item.accountId} </a></li>
                    </c:forEach>
                  </ul>
                </li>
                <li><a href="savingList" class="nav-link">Saving Money</a></li>
                 <li><a href="transferPage" class="nav-link">Transfer Money</a></li>
                <li><a href="activityHistory" class="nav-link">Transfer History</a></li>
                   <li>  
              <sec:authorize access="isAuthenticated()">
                <p><a href="<c:url value="/logout" />" class="nav-link">Logout</a></p>
        </sec:authorize>
              </li>
                <li class="social"><a href="#contact-section" class="nav-link"><span class="icon-facebook"></span></a></li>
                <li class="social"><a href="#contact-section" class="nav-link"><span class="icon-twitter"></span></a></li>
                <li class="social"><a href="#contact-section" class="nav-link"><span class="icon-linkedin"></span></a></li>
              </ul>
            </nav>
          </div>


          <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle float-right"><span class="icon-menu h3"></span></a></div>

        </div>
      </div>
      
    </header>