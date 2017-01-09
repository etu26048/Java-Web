<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<div class="span9">
    <ul class="breadcrumb">
		<li><a href="<spring:url value='/index' />" >Home</a> <span class="divider"></span></li>
		<li class="active">${category.name} </li>
    </ul>
	<h3><spring:message code="ProductsName"/> <small class="pull-right">  ${countArticles} <spring:message code="Products"/> <spring:message code="Available"/></small></h3>	
	<hr class="soft"/>
	<p>
	</p>
	<hr class="soft"/>
	<form class="form-horizontal span6">
		<div class="control-group">
		  <label class="control-label alignL"><spring:message code="SortBy"/> </label>
			<select>
              <option>Product name A - Z</option>
              <option>Product name Z - A</option>
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
				<a href = '<spring:url value="/category/details?articleId=${article.reference }" />'><img src="<spring:url value='/images/${article.urlImage}' />" width="160" height="160"  alt=""/></a>
				<div class="caption">
				  <h5>${article.name}</h5>
				  <p> 
					I'm a short description :)
				  </p>
				  <h4 style="text-align:center">
				  	   <a class="btn" href="<spring:url value='/product_detail/${article.reference }' />"><i class="icon-zoom-in"><img src=" <spring:url value='/images/loupe.png' /> " width="17.5" height="14" /></i></a>
					   <a class="btn" href="<spring:url value='/category/${category.id }/article?itemId=${article.reference}' />"><spring:message code="Addto" /><i class="icon-shopping-cart" ><img  src="<spring:url value='/images/cart.png' />"width="17.5" height="14"/></i></a> 
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