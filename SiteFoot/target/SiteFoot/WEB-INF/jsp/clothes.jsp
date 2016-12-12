<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<div id="mainBody">
	<div class="container">
	<div class="row">
<!-- Sidebar ================================================== -->
	<div id="sidebar" class="span3">
		<div class="well well-small"><a id="myCart" href="<spring:url value='/product_detail' /> "><img src="<spring:url value='/images/ico-cart.png'/>" alt="cart">3 Items in your cart  <span class="badge badge-warning pull-right">155.00 &euro;</span></a></div>
		<br/>
	</div>
<!-- Sidebar end=============================================== -->
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Products Name</li>
    </ul>
	<h3> Products Name <small class="pull-right"> ${countArticles} produits disponible</small></h3>	
	<hr class="soft"/>
	<p>
		Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies - that is why our goods are so popular and we have a great number of faithful customers all over the country.
	</p>
	<hr class="soft"/>
	<form class="form-horizontal span6">
		<div class="control-group">
		  <label class="control-label alignL">Sort By </label>
			<select>
              <option>Priduct name A - Z</option>
              <option>Priduct name Z - A</option>
              <option>Price Lowest first</option>
            </select>
		</div>
	  </form>
	
<br class="clr"/>
<div class="tab-content">
	<div class="tab-pane  active" id="blockView">
		<ul class="thumbnails">
		<c:forEach items="${articles}" var="article">
			<li class="span3">
			  <div class="thumbnail">
				<a href = '<spring:url value="/product_detail" />'><img src="<spring:url value='/images/${article.urlImage}' />" sizes="160x160"  alt=""/></a>
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
	<hr class="soft"/>
	</div>
</div>
</div>
</div>
</div>
</div>