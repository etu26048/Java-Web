<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<div class="span9">		
	<h4><spring:message code="Promotion"></spring:message> </h4>
		  <ul class="thumbnails">
		  <c:forEach items="${articles}" var="article">
			<li class="span3">
			  <div class="thumbnail">
				<a href = '<spring:url value="/category/details?articleId=${article.reference }" />'><img src="<spring:url value='/images/${article.urlImage}' />" width="160" height="160"  alt=""/></a>
				<div class="caption">
				  <h5>${article.name}</h5>
				  <p> 
					<span style="color:red">-${article.promo.percentage } %</span>
					<del>${article.unitPrice} &euro;</del>
				  </p>
				  <h4 style="text-align:center">
				  	   <a class="btn" href="<spring:url value='/product_detail/${article.reference }' />"><i class="icon-zoom-in"><img src=" <spring:url value='/images/loupe.png' /> " width="17.5" height="14" /></i></a>
					   <a class="btn" href="<spring:url value='/category/${category.id }/article?itemId=${article.reference}' />"><spring:message code="Addto" /> <i class="icon-shopping-cart" ><img  src="<spring:url value='/images/cart.png' />"width="17.5" height="14"/></i></a> 
					   <a class="btn btn-primary">${article.unitPrice = article.unitPrice - (article.unitPrice * (article.promo.percentage / 100))} &euro;</a>
				  </h4>
				</div>
			  </div>
			  </li>
		  </c:forEach>
		  </ul>	
	</div>