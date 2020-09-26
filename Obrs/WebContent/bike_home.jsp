<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
     <%@page import="com.model.*" %>
<!DOCTYPE html>
<html>
<head>
<title> home page</title>
<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200&display=swap" rel="stylesheet">

<link rel="stylesheet" href="bike_home.css">
</head>
<body>
	<div class="amal">
	<div class="head">
	<h1> RIDE-NOW   BIKE RENTALS</h1>
	<div class="form-box">
	<div class="button-box">
	<div id="btn"></div>
	<button type="button" class="toggle-btn">WELCOME</button><br>
</div>
<form action="AvailableBikesController" id="login" class="input-group">
    <div class="dropdown">
  <button class="dropbtn">Booking type</button>
  <div class="dropdown-content">
    <select name="rent_type" id="booking" class="dropbtn">
  <option  class="dropbtn" name="rent_type" value="hourly">Hourly</option>
  <option  class="dropbtn" name="rent_type" value="daily">Daily</option>
  <option  class="dropbtn" name="rent_type" value="monthly">30 days</option>
</select>
  </div>
</div>
</div><br><br>
<table>
 <%
 String rec="";
 if(request.getAttribute("arr")!=null)
 {
	 ArrayList<RegistrationModel> arr=(ArrayList<RegistrationModel>)request.getAttribute("arr");
	 for(RegistrationModel a: arr)
	 {
		 rec=rec+"<tr>";
		 rec=rec+"<td>"+a.getModel()+"</td><td>"+a.getB_colour()+"</td><td>"+a.getPday_rent()+"</td>";

		 rec=rec+"</tr>";
	 }
	 out.println(rec);
 }
 %>
 </table>
<br><br>
	
    <button type="submit" class="submit-btn">Confirm</button>
	
</form>
<a href="ViewProfile"><button>Profile</button></a>
</div>
</div>
</body>
</html>
