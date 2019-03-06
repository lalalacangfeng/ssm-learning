<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>JSON1</title>
   	<script src="js/jquery.min.js" ></script>
   	<script src="js/json2.js" ></script>
  	<script type="text/javascript">
  		function userinfo(username, password){
  			this.username = username;
  			this.password = password;
  		}
  		function send(){
  			var userinfoRef = new userinfo('啦啦啦','123');
  			var jsonStringRef = JSON.stringify(userinfoRef);
  			$.post("getJSONString.spring?t=" +new Date().getTime(), {
  				jsonString:jsonStringRef
  			});
  		}
  		function create(){
  			var userinfoRef = new userinfo('啦啦啦','123');
  			var jsonStringRef = JSON.stringify(userinfoRef);
  			$.ajax({
  				type:"POST",
  				data:jsonStringRef,
  				url:"createJSON.spring?t=" +new Date().getTime(),
  				contentType:"application/json"
  			});
  		}
  	</script>
  </head>
  
  <body>
  	111
  	<input type="button" onclick="send()" />
  	
  	222
  	<input type="button" onclick="create()" />
  	
  
  </body>
</html>
