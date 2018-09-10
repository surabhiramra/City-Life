<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h1 {
    color: navy;
    margin-left: 20px;
    font-size:100px;
}
h2 {
    color: ligtblue;
    margin-left: 20px;
    font-size:50px
}
p {
	font-size:25px;

}
body {margin:0;}

.navbar {
  overflow: hidden;
  background-color: #1aafb8;
  position: fixed;
  top: 0;
  width: 100%;
}

.navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 25px;
}

.navbar a:hover {
  background: #ddd;
  color: black;
}

.main {
  padding: 16px;
  margin-top: 30px;
  height: 1500px; /* Used in this example to enable scrolling */
}
</style>

</head>
<body>
<div class="navbar">
	<center><font color='white'size=50><b>MYSORE</b></font>
	<br>
  <a href="About_Content.jsp">About</a>
  <a href="hotels.jsp">Hotels</a>
  <a href="food.jsp">Food</a>
  <a href=Things_To_Do.jsp >Things To Do</a>
  <a href=Places_To_Visit.jsp>Places To Visit</a>
  <a href=Map.jsp >Map</a>
  <a href=#login >Login</a>
  <a href=#Register >Register</a>
  
 </center> 
</div>


</body>
</html>