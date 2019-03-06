<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'createJSON.jsp' starting page</title>
    
    <script src="js/jquery.min.js" ></script>
   	<script src="js/json2.js" ></script>
  	<script type="text/javascript">
  		function userinfo(username, password){
  			this.username = username;
  			this.password = password;
  		}
  		function create(){
  			var userinfoRef = new userinfo('啦啦啦','123');
  			var jsonStringRef = JSON.stringify(userinfoRef);
  			$.ajax({
  				type:"POST",
  				data:jsonStringRef,
  				url:"createJSON.spring?t=" +new Date().getTime(),
  				contentType:"application/json",
  				dataType:"json",
  				success:function(data,type){
  					alert(data.username);
  				}
  			});
  		}
  		function returnJson(){
  			$.ajax({
       				type:"POST",
       				url:"returnJSONString.spring?t="+new Date().getTime(),
       				success:function(data,textStatus){
       					var jsonObject = JSON.parse(data);
       					alert("returnJSONString="+data+" value="+jsonObject.username+" "+jsonObject.password
       					+jsonObject.password+" "+jsonObject.daylist[0]+" "+jsonObject.daylist[2]+" "+jsonObject.daylist[3])
       				}
       			});
  		}
  	</script>
    
  </head>
  
  <body>
    This is my JSP page. <br>
    
    	111
  	<input type="button" onclick="create()" />
    	222
  	<input type="button" onclick="returnJson()" />
  	
  </body>
</html>
