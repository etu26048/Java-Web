<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<div id="mainBody">
<div class="container">
<div class="row">
<div class="span9">
<div class="well">
	<div class="modal-header">
		<h3><spring:message code="Login" /></h3>
		 </div>
		 <div class="modal-body">
		 <form:form class="form-horizontal loginFrm"
					method="POST"
					action="/SiteFoot/login/send"
					modelAttribute="loginForm">
					
		  <div class="control-group">								
			<form:input type="text"  path="mail" placeholder="Email" />
			<form:errors path="mail" />
		  </div>
		  <div class="control-group">
			<form:input type="password"  path="password" placeholder="Password" />
			<form:errors path="password" />
		  </div>
		  <div class="control-group">	
				<form:button value='/send' class="btn btn-success">Sign in</form:button>
		  </div>
		</form:form>
	 </div>
 </div>
 </div>
 </div>
 </div>
 </div>