<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>SO FOOT</title>
	    <meta charset="utf-8" />
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link id="callCss" rel="stylesheet" href="<spring:url value='/css/bootstrap.min.css'/>"
	    		media="screen"/>
	    <link href="<spring:url value='/css/base.css'/>" rel="stylesheet" media="screen"/>
		<link href="<spring:url value='/css/bootstrap-responsive.min.css'/>" rel="stylesheet"/>
		<link href="<spring:url value='/css/prettify.css'/>" rel="stylesheet"/>
	    <link rel="shortcut icon" href="<spring:url value='/images/ico/favicon.ico' /> " >
	    <link rel="apple-touch-icon-precomposed" sizes="144x144" 
	    	href="<spring:url value='/images/ico/apple-touch-icon-144-precomposed.png'/>">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114"
	     	href="<spring:url value='/images/ico/apple-touch-icon-114-precomposed.png'/>">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" 
	    	href="<spring:url value='/images/ico/apple-touch-icon-72-precomposed.png'/>">
	    <link rel="apple-touch-icon-precomposed" href="<spring:url value='/images/ico/apple-touch-icon-57-precomposed.png'/>">
		<style type="text/css" id="enject"></style>
		
	</head>
	<body>
	<div id="header">
		<div class="container">
		<div id="welcomeLine" class="row">
			<div class="span6"><spring:message code="Welcome"></spring:message><strong> ${currentUser.lastName } ${currentUser.firstName } </strong></div>
			<div class="span6">
			<div class="pull-right">
				<spring:url var="localeFr" value="">
					<spring:param name="locale" value="fr" />
				</spring:url>
				
				<spring:url var="localeEn" value="">
					<spring:param name="locale" value="en" />
				</spring:url>
				
				<span>
					<a href="${localeFr}"><img src='<spring:url value="/images/fra.png"/>' width="26" height="17"/></a>
				    <a href="${localeEn}"><img src='<spring:url value="/images/eng.png"/>' width="26" height="17"/></a>
				</span>
				<span class="btn btn-mini">$155.00</span>
				<a href="<spring:url value='/cart' />" ><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"><img  src="<spring:url value='/images/cart.png' />" width="14" height="14" /></i> [ 3 ] Items in your cart </span></a> 
			</div>
			</div>
		</div>
		<div id="logoArea" class="navbar">
		<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</a>
		  <div class="navbar-inner">
		    <a class="brand" href="<spring:url value='/index' />"><img src="<spring:url value='/images/logo.png' />" alt="Bootsshop"/></a>
		    <ul id="topMenu" class="nav pull-right">
		    <!-- <li class=""><a href="<spring:url value='/promo' />">Specials Offer</a>
				 </li>
				 <li class=""><a href="<spring:url value='/shoes' />">Shoes</a>
				 </li>
				 <li class=""><a href="<spring:url value='/balls' />">Balls</a>
				 </li>-->
		     <c:forEach items="${labelsCategory}" var="cat">
				 <li class=""><a href="<spring:url value='/category/${cat.id}' />">${cat.name}</a></li>
			 </c:forEach>
			 <li>
				 <a class="" href="<spring:url value='/category/contact' />"><span><spring:message code="Contact"></spring:message></span></a>
			 </li>
			 <c:choose >
				 <c:when test="${empty currentUser.mail}">
					 <li>
						 <a class="" href="<spring:url value='/register' />"><span><spring:message code="Signin"></spring:message></span></a>
					 </li>
					 <!--<spring:message code="Signin" />-->
					 <li>
						 <a href="<spring:url value='/login' />" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-success"><spring:message code="Login"></spring:message></span></a>		  
					 </li>
					 <!--<spring:message code="Login" />	-->
				 </c:when>
				 <c:when test="${not empty currentUser.mail }">
					 <li>
						 <a href="<spring:url value='/login/disconnect' />" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-success"><spring:message code="Disconnect"></spring:message></span></a>		  
					 </li>
				 </c:when>
		     </c:choose>
		     
		    </ul>
		  </div>
		</div>
		</div>
		</div>
		<script src="<spring:url value='/js/jquery.js'/>" 
							type="text/javascript"></script>
							
		<script src="<spring:url value='/js/bootstrap.min.js'/>" 
						type="text/javascript"></script>
		<script src="<spring:url value='/js/prettify.js'/>"></script>
		
		<script src="<spring:url value='/js/bootshop.js'/>">
		</script>
	    <script src="<spring:url value='/js/jquery.lightbox-0.5.js'/>">
        </script>
        <div id="mainBody">
			<div class="container">
			<div class="row">
			<div id="sidebar" class="span3">
				<div class="well well-small"><a id="myCart" href="<spring:url value='/product_detail' /> "><img src="<spring:url value='/images/ico-cart.png'/>" alt="cart">3 Items in your cart  <span class="badge badge-warning pull-right">155.00 &euro;</span></a></div>
				<br/>
			</div>				<div>
				<tiles:insertAttribute name="main-content" />
			</div>
			</div>
			</div>
		</div>
	</body>
</html>
