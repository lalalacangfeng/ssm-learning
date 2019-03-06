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
  		function send1(){
  			var userinfoRef = new userinfo('啦啦啦','123');
  			var jsonStringRef = JSON.stringify(userinfoRef);
  			$.ajax({
  				type:"POST",
  				data:jsonStringRef,
  				url:"getJSON1.spring?t=" +new Date().getTime(),
  				contentType:"application/json"
  			});
  		}
  		function send2(){
  			var myArray = new Array();
  			myArray[0] = "lalala";  			
  			myArray[1] = "中国";
  			myArray[2] = "666";
  			var jsonStringRef = JSON.stringify(myArray);
  			$.ajax({
  				type:"POST",
  				data:jsonStringRef,
  				url:"getJSON2.spring?t=" +new Date().getTime(),
  				contentType:"application/json"
  			});
  		}
  		function send3(){
  			var myArray = new Array();
  			myArray[0] =  new userinfo('啦啦啦111','3');	
  			myArray[1] =  new userinfo('啦啦啦222','2');
  			myArray[2] =  new userinfo('啦啦啦333','1');
  			var jsonStringRef = JSON.stringify(myArray);
  			$.ajax({
  				type:"POST",
  				data:jsonStringRef,
  				url:"getJSON3.spring?t=" +new Date().getTime(),
  				contentType:"application/json"
  			});
  		}
  		function send4(){
  			var jsonObject = {
  				"username":"accp",
  				"work":[{"address":"山岗"},{"address":"内江"}],
  				"school":{"name":"tx","address":"PYL"}
  			};
  			var jsonStringRef = JSON.stringify(jsonObject);
  			$.ajax({
  				type:"POST",
  				data:jsonStringRef,
  				url:"getJSON4.spring?t=" +new Date().getTime(),
  				contentType:"application/json"
  			});
  		}
  	</script>
  </head>
  
  <body>
  	实体类
  	<input type="button" onclick="send1()" />
  	<br/>
  	
  	ArrayList
  	<input type="button" onclick="send2()" />
  	<br/>
  	
  	ArrayList-Map
  	<input type="button" onclick="send3()" />
  	<br/>
  	
  	Map
  	<input type="button" onclick="send4()" />
  	<br/>
  	
  
  </body>
</html>
