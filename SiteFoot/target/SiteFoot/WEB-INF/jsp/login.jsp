<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<div id="mainBody">
<div class="container">
<div class="row">
<div class="span9">
<div class="well">
	<div class="modal-header">
		<h3>Login Block</h3>
		 </div>
		 <div class="modal-body">
		<form:form class="form-horizontal loginFrm"
					method="POST"
					action="/SiteFoot/login/signin">
		  <div class="control-group">								
			<form:input type="text" id="inputEmail" path="Login" placeholder="Email" />
		  </div>
		  <div class="control-group">
			<form:input type="password" id="inputPassword" path="Password" placeholder="Password" />
		  </div>		
		<form:button class="btn btn-success">Sign in</form:button>
		</form:form>
	 </div>
 </div>
 </div>
 </div>
 </div>
 </div>