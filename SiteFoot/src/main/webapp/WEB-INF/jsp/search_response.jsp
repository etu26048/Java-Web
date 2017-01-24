<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<div class="span9">
	<h3>Research Products<small class="pull-right">  ${countArticles} <spring:message code="Products"/> <spring:message code="Available"/></small></h3>	
		<hr class="soft"/>
		<p>
		</p>
		<hr class="soft"/>
		
	<c:if test="${ empty articles}">
		<h2> No products found </h2>
	</c:if>
	<br class="clr"/>
	<div class="tab-content">
		<div class="tab-pane  active" id="blockView">
			<ul class="thumbnails">
			<c:forEach items="${articles}" var="article">
				<li class="span3">
				  <div class="thumbnail">
					<a href="<spring:url value='/product_detail/${article.reference }' />"><img src="<spring:url value='/images/${article.urlImage}' />" width="160" height="160"  alt=""/></a>
					<div class="caption">
					  <h5>${article.name}</h5>
					  <p>
					  	<c:if test="${article.inPromo }">
							<span style="color:red">-${article.promo.percentage } %</span>
							<del>${article.unitPrice} &euro;</del>
						</c:if>
						<c:if test="${!article.inPromo }">
							<span><spring:message code="NoPromo"></spring:message></span>
						</c:if>
					  </p>
					  <h4 style="text-align:center">
					  	   <a class="btn" href="<spring:url value='/product_detail/${article.reference }' />"><i class="icon-zoom-in"><img src=" <spring:url value='/images/loupe.png' /> " width="17.5" height="14" /></i></a>
						   <a class="btn" href="<spring:url value='/category/${category.id }/article?itemId=${article.reference}' />"><spring:message code="Addto" /><i class="icon-shopping-cart" ><img  src="<spring:url value='/images/cart.png' />"width="17.5" height="14"/></i></a> 
						   <c:if test="${article.inPromo }">
						   	<a class="btn btn-primary"><fmt:formatNumber value=" ${article.unitPrice = article.unitPrice - (article.unitPrice * (article.promo.percentage / 100))}" type="currency" currencySymbol="€"/></a>
						   </c:if>
						   <c:if test="${!article.inPromo }">
						    <a class="btn btn-primary"><fmt:formatNumber value=" ${article.unitPrice}" type="currency" currencySymbol="€"/></a>
						   </c:if>
					  </h4>
					</div>
				  </div>
				  </li>
			</c:forEach>
			</ul>
		<hr class="soft"/>
		</div>
	</div>
</div>