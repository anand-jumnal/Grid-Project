<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
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
    background-color:#4DDBFF;
    /* background-image: url("./images/img_tree.png");
    background-repeat: no-repeat;
    background-position: right center;
    margin-right: 200px; */
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
    width: 320px;
    padding: 10px;
    /* border: 5px solid gray; */
    margin: 0;
    background-color:#AD855C;
}

 /* body {
    background-image: url("./images/img_tree.png");
    background-repeat: no-repeat;
    background-position: bottom;
    margin-right: 200px;
} */
</style>
</head>
<body background="./images/bg1.jpg">
<div id="header">
<h1 id='head1' align="center">Grid-Lab User Login</h1></div>
<div id="box">
<pre>
<form name="loginForm" method="post" action="loginServlet">
UserName : <input type="text" name="user_name" > <br>
Password : <input type="password" name="password1" > <br>
           <input type="submit" value="Login" /> <input type="reset" value="Clear" /> <br>
           <a href="signupForm.html">Not a member!!</a>
</form>
</pre>
</div>
</body>
</html>