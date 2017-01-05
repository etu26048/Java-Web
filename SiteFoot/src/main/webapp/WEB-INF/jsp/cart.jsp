<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider"></span></li>
		<li class="active"><spring:message code="SHOPPING"/><spring:message code="CART"/></li>
    </ul>
	<h3>  SHOPPING CART [ <small> ${countItems } Item(s) </small>]<a href="<spring:url value='/index' />" class="btn btn-large pull-right">
	<img src="<spring:url value='/images/leftArrow.png' />" class="icon-arrow-left"></img><spring:message code="Continue"/><spring:message code="Shopping"/> </a>
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
	                  <td>0.00 &euro;</td>
	                  <td>${product_line.value.article.unitPrice * product_line.value.quantity}&euro;</td>
	                  <p hidden>${amount = amount + product_line.value.article.unitPrice * product_line.value.quantity}</p>
	                </tr>
                </c:forEach>				
	                <tr>
	                  <td colspan="6" style="text-align:right">Total <spring:message code="Price"/>:	</td>
	                  <td> ${amount } &euro;</td>
	                </tr>
					 <tr>
	                  <td colspan="6" style="text-align:right">Total<spring:message code="Discount"/>:	</td>
	                  <td> ${amountWithReduction } &euro;</td>
	                </tr>
					 <tr>
	                  <td colspan="6" style="text-align:right"><strong>TOTAL </strong></td>
	                  <td class="label label-important" style="display:block"> <strong> ${amount - amountWithReduction } &euro;</strong></td>
	                </tr>
				</tbody>
	   </table>
       <table class="table table-bordered">
			<tbody>
				 <tr>
                  <td> 
				<form class="form-horizontal">
				<div class="control-group">
				<label class="control-label"><strong> PROMO CODE: </strong> </label>
				<div class="controls">
				<input type="text" class="input-medium" placeholder="CODE">
				<button type="submit" class="btn"><spring:message code="ADD" /></button>
				</div>
				</div>
				</form>
				</td>
                </tr>
			</tbody>
		</table>
				
		<a href="<spring:url value='/index' />" class="btn btn-large"><img src="<spring:url value='/images/leftArrow.png' />" class="icon-arrow-left"></img><spring:message code="Continue" /><spring:message code="Shopping" /> </a>
		<form:button class="btn btn-large pull-right"><spring:message code="Order"/> <img class="icon-arrow-right" src="<spring:url value='/images/rightArrow.png' />" /></form:button>
	
	</form:form>
	
</div>