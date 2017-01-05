<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

	<div class="span9">		
			<div class="well well-small">
			<h4><spring:message code="Promo"></spring:message></h4>
			<div class="row-fluid">
			<div id="featured" class="carousel slide">
			<div class="carousel-inner">
			  <div class="item active">
			  <ul class="thumbnails">
				<li class="span3">
				  <div class="thumbnail">
				  <i class="tag"></i>
					<a href="<spring:url value='/product_detail' />"><img src="<spring:url value='/images/ballon1.png'/>" width="128" height="128" alt=""></a>
					<div class="caption">
					  <h5>Product name</h5>
					  <h4><a class="btn" href="<spring:url value='/category/product_detail/detail' />">VIEW</a>
					   <span class="pull-right">22&euro;</span></h4>
					</div>
				  </div>
				</li>
			  </ul>
			  </div>
			  </div>
			  </div>
			  </div>
		</div>
		<h4><spring:message code="LastestProduct"></spring:message> </h4>
			  <ul class="thumbnails">
			  <c:forEach items="${articles}" var="article">
				<li class="span3">
				  <div class="thumbnail">
					<a href = '<spring:url value="/category/details?articleId=${article.reference }" />'><img src="<spring:url value='/images/${article.urlImage}' />" width="160" height="160"  alt=""/></a>
					<div class="caption">
					  <h5>${article.name}</h5>
					  <p> 
						I'm a short description :)
					  </p>
					  <h4 style="text-align:center">
					  	   <a class="btn" href="<spring:url value='/category/${category.id }/details?articleId=${article.reference }' />"><i class="icon-zoom-in"><img src=" <spring:url value='/images/loupe.png' /> " width="17.5" height="14" /></i></a>
						   <a class="btn" href="<spring:url value='/category/${category.id }/article?itemId=${article.reference}' />">Add to <i class="icon-shopping-cart" ><img  src="<spring:url value='/images/cart.png' />"width="17.5" height="14"/></i></a> 
						   <a class="btn btn-primary">${article.unitPrice} &euro;</a>
					  </h4>
					</div>
				  </div>
				  </li>
			  </c:forEach>
			  </ul>	
		</div>