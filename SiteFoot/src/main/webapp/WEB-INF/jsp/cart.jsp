<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active"> SHOPPING CART</li>
    </ul>
	<h3>  SHOPPING CART [ <small>3 Item(s) </small>]<a href="products.html" class="btn btn-large pull-right"><i class="icon-arrow-left"></i> Continue Shopping </a></h3>	
	<hr class="soft"/>
	<table class="table table-bordered">
		<tr><th> I AM ALREADY REGISTERED  </th></tr>
		 <tr> 
		 <td>
			<form class="form-horizontal">
				<div class="control-group">
				  <label class="control-label" for="inputUsername">Username</label>
				  <div class="controls">
					<input type="text" id="inputUsername" placeholder="Username">
				  </div>
				</div>
				<div class="control-group">
				  <label class="control-label" for="inputPassword1">Password</label>
				  <div class="controls">
					<input type="password" id="inputPassword1" placeholder="Password">
				  </div>
				</div>
				<div class="control-group">
				  <div class="controls">
					<button type="submit" class="btn">Sign in</button> OR <a href="<spring:url value='/register' />" class="btn">Register Now!</a>
				  </div>
				</div>
				<div class="control-group">
					<div class="controls">
					  <a href="forgetpass.html" style="text-decoration:underline">Forgot password ?</a>
					</div>
				</div>
			</form>
		  </td>
		  </tr>
	</table>		
			
	<form:form id="orderForm" 
				method="POST"
				action="/SiteFoot/cart/create_order"
				modelAttribute="basket">
				
	<table class="table table-bordered">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Description</th>
                  <th>Quantity/Update</th>
				  <th>Price</th>
                  <th>Discount</th>
                  <th>Total</th>
				</tr>
              </thead>
              <tbody>									
              	<c:forEach items="${basket.line_map}" var="product_line">
	                <tr>
	                  <td> <img width="60" src="<spring:url value='/images/${product_line.value.article.urlImage }' />" width="60px" height="60px" alt=""/></td>
	                  <td>${product_line.value.article.name }</td>
					  <td>
						<div class="input-append">
								
							<form:form action="" method="POST" modelAttribute="line">							
								<form:button path="quantity" class="span1" style="max-width:34px" placeholder="${quantity }" id="appendedInputButtons" size="16" type="text"/>
							</form:form>
							<form:form action="/cart/minusQuantity" method="POST" modelAttribut="line">
								<form:button path="quantity" class="btn" type="button"><i class="icon-minus"></i></form:button>
							</form:form>
							<form:form action="/cart/plusQuantity" method="POST" modelAttribut="line">
								<form:button path="quantity" class="btn" type="button"><i class="icon-plus"></i></form:button>
							</form:form>
							<form:form action="/cart/deleteLine" method="POST" modelAttribut="line">
								<form:button path="quantity" class="btn btn-danger" type="button"><i class="icon-remove icon-white"></i></form:button>
							</form:form>
						</div>
					  </td>
	                  <td>${product_line.value.article.unitPrice } &euro;</td>
	                  <td>0.00 &euro;</td>
	                  <td>${product_line.value.article.unitPrice } &euro;</td>
	                </tr>
                </c:forEach>				
	                <tr>
	                  <td colspan="6" style="text-align:right">Total Price:	</td>
	                  <td> $228.00</td>
	                </tr>
					 <tr>
	                  <td colspan="6" style="text-align:right">Total Discount:	</td>
	                  <td> $50.00</td>
	                </tr>
	                 <tr>
	                  <td colspan="6" style="text-align:right">Total Tax:	</td>
	                  <td> $31.00</td>
	                </tr>
					 <tr>
	                  <td colspan="6" style="text-align:right"><strong>TOTAL ($228 - $50 + $31) =</strong></td>
	                  <td class="label label-important" style="display:block"> <strong> $155.00 </strong></td>
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
				<button type="submit" class="btn"> ADD </button>
				</div>
				</div>
				</form>
				</td>
                </tr>
			</tbody>
		</table>
				
		<a href="products.html" class="btn btn-large"><i class="icon-arrow-left"></i> Continue Shopping </a>
		<form:button class="btn btn-large pull-right"><spring:message code="Order"/> <i class="icon-arrow-right"></i></form:button>
	
	</form:form>
	
</div>