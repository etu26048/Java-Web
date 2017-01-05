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
				
		<h4>Your personal information</h4>
		<div class="control-group">
		<label class="control-label">Title <sup>*</sup></label>
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
			<form:label class="control-label" path="firstName">First name <sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="firstName" placeholder="First Name"/>
			  <form:errors path="firstName" ></form:errors>
			</div>
		 </div>
		 <div class="control-group">
			<form:label class="control-label" path="lastName">Last name <sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="lastName" placeholder="Last Name" />
			  <form:errors path="lastName"  class="red"/>
			</div>
		 </div>
		<div class="control-group">
		<form:label class="control-label" path="mail">Email <sup>*</sup></form:label>
		<div class="controls">
		  <form:input type="text" path="mail" placeholder="Email" />
		  <form:errors path="mail" />
		</div>
	  </div>	  
	<div class="control-group">
		<form:label class="control-label" path="password">Password <sup>*</sup></form:label>
		<div class="controls">
		  <form:input type="password" path="password" placeholder="Password"/>
	      <form:errors path="password" />
		</div>
	</div>
	<div class="control-group">
		<form:label class="control-label" path="confirmPassword">Confirm Password <sup>*</sup></form:label>
		<div class="controls">
		  <form:input type="password"  path="confirmPassword" placeholder="Password" />
	      <form:errors path="confirmPassword" />
		</div>
	</div>
		<div class="control-group">
		<form:label path="birthdate" class="control-label">Date of Birth</form:label>
		<div class="controls">
			<form:input path="birthdate" id="datepicker"/>
			<form:errors path="birthdate"></form:errors>
		</div>
	  </div>

	  <div class="control-group">
			<form:label class="control-label" path="phone">Mobile Phone </form:label>
			<div class="controls">
			  <form:input type="text" path="phone" placeholder="Mobile Phone"/> 
			  <form:errors path="phone" />
			</div>
		</div>	
		<h4>Your address</h4>
		
		<div class="control-group">
			<form:label class="control-label" path="street">Street<sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="street" placeholder="street"/> 
			  <form:errors path="street" />
			</div>
		</div>
		
		<div class="control-group">
			<form:label class="control-label" path="number">Number<sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="number" placeholder="Number"/>
			  <form:errors path="number" />
			</div>
		</div>
		
		<div class="control-group">
			<form:label class="control-label" path="postal_box">Postal Box</form:label>
			<div class="controls">
			  <form:input type="text" path="postal_box" placeholder="postal-box"/>
			  <form:errors path="postal_box" />
			</div>
		</div>
		
		<div class="control-group">
			<form:label class="control-label" path="city">City<sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="city" placeholder="city"/> 
			  <form:errors path="city"/>
			</div>
		</div>		
		<div class="control-group">
			<form:label class="control-label" path="postalCode">Zip / Postal Code<sup>*</sup></form:label>
			<div class="controls">
			  <form:input type="text" path="postalCode" placeholder="Zip / Postal Code"/> 
			  <form:errors path="postalCode" />
			</div>
		</div>
		
		<div class="control-group">
			<form:label class="control-label" path="country">Country<sup>*</sup></form:label>
			<div class="controls">
			<form:select path="country" >
				<form:option value="Belgium" label="Belgium"></form:option>
			</form:select>
			</div>
		</div>	
		
		
	
	<p><sup>*</sup>Required field	</p>
	
	<div class="control-group">
		<div class="controls">
			<input type="hidden" name="email_create" value="1">
			<input type="hidden" name="is_new_customer" value="1">
			<form:button class="btn btn-large btn-success">Create</form:button>
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