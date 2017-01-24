<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider"></span></li>
		<li class="active"><spring:message code="SHOPPINGCART"></spring:message></li>
    </ul>
	<h3>  SHOPPING CART [ <small> ${countItems } Item(s) </small>]
	<a href="<spring:url value='/cart/clear_cart' />" class="btn btn-large pull-right">
		<spring:message code="ClearCart"/> 
	</a>
	</h3>	
	<hr class="soft"/>	
			
	<form:form id="orderForm" 
				method="POST"
				action="/SiteFoot/cart/confirm_order"
				modelAttribute="basket">
				
	<table class="table table-bordered">
              <thead>
                <tr>
                  <th><spring:message code="Product"></spring:message></th>
                  <th><spring:message code="Reference"></spring:message></th>
                  <th><spring:message code="Quantity/Update"></spring:message></th>
				  <th><spring:message code="UnitPrice"></spring:message></th>
                  <th><spring:message code="Discount"></spring:message></th>
                  <th><spring:message code="Total"></spring:message></th>
				</tr>
              </thead>
              <tbody>									
              	<c:forEach items="${basket.line_map}" var="product_line">
	                <tr>
	                  <td> <img width="60" src="<spring:url value='/images/${product_line.value.article.urlImage }' />" width="60px" height="60px" alt=""/></td>
	                  <td>${product_line.value.article.reference}</td>
					  <td>
						<div class="input-append">
									
								<form:input path="line_map[${product_line.key}].quantity" class="span1" style="max-width:50px;" width="25px" value="${product_line.value.quantity}" id="appendedInputButtons" type="number" min="1" />
								<a style="height:21px;" href="<spring:url value='/cart/delete?lineKey=${product_line.key}'/>" class="btn btn-danger" ><img width="39px" height="29px" style="padding:1px 2px" class="icon-remove" src="<spring:url value='/images/x-mark-14.png' />" /></a>
				
						</div>
					  </td>
	                  <td>${product_line.value.article.unitPrice } &euro;</td>
                  	  <c:if test="${product_line.value.article.inPromo }">
						<c:set var="reductPrice" value="${( product_line.value.article.unitPrice * ( product_line.value.article.promo.percentage / 100)) * product_line.value.quantity}" />
					  	<p hidden>${amountWithReduction = amountWithReduction + reductPrice }</p>
					  </c:if>
					  <c:if test="${!product_line.value.article.inPromo }">
						<c:set var="reductPrice" value="0.00" />
					  </c:if>
	                  <td><fmt:formatNumber value="${reductPrice } " type="currency" currencySymbol="€"/></td>
	                  <td> <fmt:formatNumber value=" ${(product_line.value.article.unitPrice * product_line.value.quantity) - reductPrice}" type="currency" currencySymbol="€"/></td>
	                  <p hidden>${amount = amount + (product_line.value.article.unitPrice * product_line.value.quantity) - reductPrice}</p>
	                </tr>
                </c:forEach>				
	                <tr>
	                  <td colspan="6" style="text-align:right">Total <spring:message code="Price"/>:	</td>
	                  <td> <fmt:formatNumber value="${amount }" type="currency" currencySymbol="€"/> </td>
	                </tr>
					 <tr>
	                  <td colspan="6" style="text-align:right">Total <spring:message code="Discount"/>:	</td>
	                  <td> <fmt:formatNumber value="${amountWithReduction}" type="currency" currencySymbol="€"/></td>
	                </tr>
					 <tr>
	                  <td colspan="6" style="text-align:right"><strong>TOTAL </strong></td>
	                  <td class="label label-important" style="display:block"> <strong> <fmt:formatNumber value=" ${amount - amountWithReduction }" type="currency" currencySymbol="€"/></strong></td>
	                </tr>
				</tbody>
	   </table>	
				
		<a href="<spring:url value='/index' />" class="btn btn-large"><img src="<spring:url value='/images/leftArrow.png' />" class="icon-arrow-left"></img><spring:message code="Continue" /> <spring:message code="Shopping" /> </a>
		<form:button class="btn btn-large pull-right"><spring:message code="Order"/> <img class="icon-arrow-right" src="<spring:url value='/images/rightArrow.png' />" /></form:button>
	
	</form:form>
	
</div>