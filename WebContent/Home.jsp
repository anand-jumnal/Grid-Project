<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<style>
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;	      
}
#header {
    background-color:blue;
   
    color:white;
    text-align:center;
    padding:30px;
}
#section {
    width:350px;
    text-align:center;
    padding:10px;	 	 
}

#box {
    line-height:30px;
    background-color:pink;
    height:300px;
    width:100px;
    padding:5px;	      
}
</style>
</head>
<body>
<div id="header">
<h1 align="center"> WELCOME TO GRID LABORATORY</h1></div>
<p></p>
<div id="nav">

<!-- <button type="button"  onclick="<a href="/signupForm.html"></a>" > File upload </button><br>
<button type="button" autofocus onclick="href=""('Hello world!')">File view!</button><br><br>
<button type="button" autofocus onclick="href=""('Hello world!')">File broseSS!</button><br><br> -->
</div>
<%-- <%HttpSession hp = request.getSession(false);
String fn = (String) hp.getAttribute("firstName"); 
 out.println(fn); %> --%>

<div id="section">
<h2>File Upload </h2>
</div>
<div id="box">
<form action="file1" method="post" enctype="multipart/form-data">
<b>Select a file to upload:</b> &nbsp;&nbsp;  	 
<input type="file" name="file" size="50" />
<br />
<br />
&nbsp;&nbsp;&nbsp;<input type="submit" value="Upload File" /> <input type="reset" value="Clear" />
<a href="file1">Download</a> 
</form></div>
</body>
</html>