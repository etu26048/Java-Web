<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<html>
<head>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  		<link rel="stylesheet" href="/resources/demos/style.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  		<script>
  			$( function() {
    				$( "#datepicker" ).datepicker();
  			} );
		</script>
</head>
<body>
<div id="mainBody">
	<div class="container">
	<div class="row">
	<div class="span9">
	<h3> Registration</h3>	
	<div class="well">
	<form:form class="form-horizontal"
				id="userInscriptionForm" 
				method="POST"
				action="/SiteFoot/register/create"
				modelAttribute="currentUser" >
				
		<h4><spring:message code="information" /></h4>
		<div class="control-group">
		<label class="control-label"><spring:message code="title" /> <sup>*</sup></label>
		<div class="controls">
		<form:select path="civility" class="span1" >
			<form:option value="Mr." label="Mr."></form:option>
			<form:option value="Mrs" label="Mrs"></form:option>
			<form:option value="Miss" label="Miss"></form:option>
		</form:select>
		<form:errors path="civility" />
		</div>
		</div>
		<div class="control-group">
			<form:label class="control-label" path="firstName"><spring:message code="Firstname"/> <sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="firstName" placeholder="First Name"/>
			  <form:errors path="firstName" style="color:red"></form:errors>
			</div>
		 </div>
		 <div class="control-group">
			<form:label class="control-label" path="lastName"><spring:message code="Lastname" /> <sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="lastName" placeholder="Last Name" />
			  <form:errors path="lastName" style="color:red"/>
			</div>
		 </div>
		<div class="control-group">
		<form:label class="control-label" path="mail">Email <sup>*</sup></form:label>
		<div class="controls">
		  <form:input type="text" path="mail" placeholder="Email" />
		  <form:errors path="mail" style="color:red"/>
		</div>
	  </div>	  
	<div class="control-group">
		<form:label class="control-label" path="password"><spring:message code="Password" /> <sup>*</sup></form:label>
		<div class="controls">
		  <form:input type="password" path="password" placeholder="Password"/>
	      <form:errors path="password" style="color:red"/>
		</div>
	</div>
	<div class="control-group">
		<form:label class="control-label" path="confirmPassword"><spring:message code="ConfirmPassword"/> <sup>*</sup></form:label>
		<div class="controls">
		  <form:input type="password"  path="confirmPassword" placeholder="Password" />
	      <form:errors path="confirmPassword" style="color:red"/>
		</div>
	</div>
		<div class="control-group">
		<form:label path="birthdate" class="control-label" placeholder="dd/mm/yyyy"><spring:message code="DateofBirth" /></form:label>
		<div class="controls">
			<form:input path="birthdate" id="datepicker"/>
			<form:errors path="birthdate" style="color:red"></form:errors>
		</div>
	  </div>

	  <div class="control-group">
			<form:label class="control-label" path="phone"><spring:message code="MobilePhone" /> </form:label>
			<div class="controls">
			  <form:input type="text" path="phone" placeholder="Mobile Phone"/> 
			  <form:errors path="phone" style="color:red"/>
			</div>
		</div>	
		<h4><spring:message code="address" /></h4>
		
		<div class="control-group">
			<form:label class="control-label" path="street"><spring:message code="Street" /><sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="street" placeholder="street"/> 
			  <form:errors path="street" style="color:red"/>
			</div>
		</div>
		
		<div class="control-group">
			<form:label class="control-label" path="number"><spring:message code="Number" /><sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="number" min="1" path="number" placeholder="Number"/>
			  <form:errors path="number" style="color:red"/>
			</div>
		</div>
		
		<div class="control-group">
			<form:label class="control-label" path="postal_box"><spring:message code="PostalBox" /></form:label>
			<div class="controls">
			  <form:input type="text" path="postal_box" placeholder="postal-box"/>
			  <form:errors path="postal_box" style="color:red"/>
			</div>
		</div>
		
		<div class="control-group">
			<form:label class="control-label" path="city"><spring:message code="City" /><sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="city" placeholder="city"/> 
			  <form:errors path="city" style="color:red"/>
			</div>
		</div>		
		<div class="control-group">
			<form:label class="control-label" path="postalCode"><spring:message code="zip" /><sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="postalCode" placeholder="Zip / Postal Code"/> 
			  <form:errors path="postalCode" style="color:red"/>
			</div>
		</div>
		
		<div class="control-group">
			<form:label class="control-label" path="country"><spring:message code="Country" /><sup>*</sup></form:label>
			<div class="controls">
			<form:select path="country" >
				<form:option value="Belgium" label="Belgium"></form:option>
			</form:select>
			</div>
		</div>	
		
		
	
	<p><sup>*</sup><spring:message code="Requiredfield"/>	</p>
	
	<div class="control-group">
		<div class="controls">
			<input type="hidden" name="email_create" value="1">
			<input type="hidden" name="is_new_customer" value="1">
			<form:button class="btn btn-large btn-success"><spring:message code="Create"></spring:message></form:button>
		</div>
	</div>		
</form:form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>