<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>My JSP 'upload.jsp' starting page</title>
  </head>
  
  <body>
    This is my JSP page. <br>
    
    <form action="oneFileUpload.spring" method="post" enctype="multipart/form-data">
    	<input type="text" name="username">
    	<input type="file" name="uploadFile">
    	<input type="submit" value="单文件上传">
    </form>
    <br />
    <br />
    <br />
    
    <form action="oneFileUpload2.spring" method="post" enctype="multipart/form-data">
    	<input type="text" name="username">
    	<input type="file" name="uploadFile">
    	<input type="submit" value="单文件2222上传">
    </form>
    <br />
    <br />
    <br />
    
    <form action="moreFileUpload.spring" method="post" enctype="multipart/form-data">
    	<input type="text" name="username">
    	<input type="file" name="uploadFile1"><br />
    	<input type="file" name="uploadFile2"><br />
    	<input type="file" name="uploadFile3"><br />
    	<input type="file" name="uploadFile4">
    	<input type="submit" value="多文件上传">
    </form>
    
  </body>
</html>
