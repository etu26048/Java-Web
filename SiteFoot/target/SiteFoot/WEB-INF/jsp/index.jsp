<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<div id="mainBody">
	<div class="container">
	<div class="row">
<!-- Sidebar ================================================== -->
	<div id="sidebar" class="span3">
		<div class="well well-small"><a id="myCart" href="<spring:url value='/cart' />" ><img src="<spring:url value='/images/ico-cart.png'/>" alt="cart">3 Items in your cart  <span class="badge badge-warning pull-right">$155.00</span></a></div>
		<br/>
	</div>
<!-- Sidebar end=============================================== -->
		<div class="span9">		
			<div class="well well-small">
			<h4>Featured Products <small class="pull-right">200+ featured products</small></h4>
			<div class="row-fluid">
			<div id="featured" class="carousel slide">
			<div class="carousel-inner">
			  <div class="item active">
			  <!-- <ul class="thumbnails">
				<li class="span3">
				  <div class="thumbnail">
				  <i class="tag"></i>
					<a href="<spring:url value='/product_detail' />"><img src="<spring:url value='/images/${articles.article[0].urlImage}'/>" alt=""></a>
					<div class="caption">
					  <h5>Product name</h5>
					  <h4><a class="btn" href="<spring:url value='/product_detail' />">VIEW</a> <span class="pull-right">${articles.article[0].unitPrice}</span></h4>
					</div>
				  </div>
				</li>
			  </ul>-->
			  </div>
			  </div>
			  </div>
			  </div>
		</div>
		<h4>Latest Products </h4>
			  <ul class="thumbnails">
			  <c:forEach items="${articles}" var="article">
				<li class="span3">
				  <div class="thumbnail">
					<a href = '<spring:url value="/product_detail" />'><img src="<spring:url value='/images/${article.urlImage}' />" width="128" height="128"  alt=""/></a>
					<div class="caption">
					  <h5>${article.reference}</h5>
					  <p> 
						I'm a short description :)
					  </p>
					  <h4 style="text-align:center">
					  	   <a class="btn" href="<spring:url value='/product_detail' />"><i class="icon-zoom-in"><img src=" <spring:url value='/images/loupe.png' /> " sizes="17.5x14" /></i></a>
						   <a class="btn" href="<spring:url value='/cart' />">Add to <i class="icon-shopping-cart" ><img  src="<spring:url value='/images/cart.png' />" sizes="17.5x14"/></i></a> 
						   <a class="btn btn-primary">${article.unitPrice} &euro;</a>
					  </h4>
					</div>
				  </div>
				</li>
			  </c:forEach>
			  </ul>	

		</div>
		</div>
	</div>
</div>