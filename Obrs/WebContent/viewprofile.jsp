<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
     <%@page import="com.model.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Bike booked</title>
<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200&display=swap" rel="stylesheet">

<link rel="stylesheet" href="profile.css">
</head>
<body>
	<div class="amal">
	<div class="head">
	<h1> RIDE-NOW   BIKE RENTALS</h1>
	<div class="form-box">
	<div class="button-box">
	<div id="btn"></div>
	<button type="button" class="toggle-btn"></button>
</div>
<form  id="login" class="input-group">
 <%
 String rec="";
 if(request.getAttribute("arr")!=null)
 {
	 ArrayList<RegistrationModel> arr=(ArrayList<RegistrationModel>)request.getAttribute("arr");
	 for(RegistrationModel a: arr)
	 {
		 rec=rec+"<tr>";
		 rec=rec+"<td>"+a.getEmail_id()+"</td><td>"+a.getName()+"</td><td>"+a.getPh_no()+"</td>"+"<td>"+a.getLocation()+"</td>";

		 rec=rec+"</tr>";
	 }
	 out.println(rec);
 }
 %>
</form>
</div>
</div>
    </div>
</body>
</html>
