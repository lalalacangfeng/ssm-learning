<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
  <label>控制层默认情况下可以处理get和post</label>
    <form action="login.spring" method="post">
    	username(test):
    	<input type="text" name="username">
    	<br />
    	password(123):
    	<input type="text" name="password">
    	<br />
    	<input type="submit" value="submit">
    	<br />
    </form>
  </body>
</html>
