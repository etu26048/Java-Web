<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML>
<html>
	<head>
		<link type="text/css" href="<spring:url value='/css/foot.css' />" rel="Stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<body background= "images/foot_background.png">
		<title>Bienvenue</title>
		<div>
			<tiles:insertAttribute name="main-content" />
		</div>
		<header>
			   <nav class="navbar navbar-inverse">
		 		 <div class="container-fluid">
		    		<div class="navbar-header">
		     	 		<a class="navbar-brand" href="#">SoFoot</a>
			     	</div>
			    	<ul class="nav navbar-nav">
			     	 <li class="active"><a href="#">Home</a></li>
			      	 <li><a href="#">Article</a></li>
			      	 <li><a href="#">Contact</a></li>
			      	 <li><a href="#">About</a></li>
			    	</ul>
			   	    <ul class="nav navbar-nav navbar-right">
			      	 <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			      	 <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			    	</ul>
		 		 </div>
				</nav>
		   </header> 
	   	
	</body>
</html>
