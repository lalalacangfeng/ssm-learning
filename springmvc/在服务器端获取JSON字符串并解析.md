方式A：
1.在web.xml中配置字符编码过滤器：
<!-- spring的编码过滤器 -->
<filter>
	<filter-name>encodingFilter</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>utf-8</param-value>
		</init-param>
</filter>
<filter-mapping>
	<filter-name>encodingFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>

<servlet>
	<servlet-name>springMVC</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
	<servlet-name>springMVC</servlet-name>
	<url-pattern>*.spring</url-pattern>
</servlet-mapping>
<welcome-file-list>
	<welcome-file>index.jsp</welcome-file>
</welcome-file-list>
	
2.新建JSP文件：sendAjax.jsp
<input type="button" onclick="send()" send>
<script src="js/jquery.min.js" ></script>
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
</script>
  	
 3.新建控制层GetJSONString.java(需添加依赖jar包)
@Controller
public class GetJSONString {
	
	@RequestMapping(value="getJSONString")
	public String getJSONString(@RequestParam("jsonString") String jsonString){
		JSONObject object  = new JSONObject(jsonString);
		System.out.println(object.get("username"));
		System.out.println(object.get("password"));
		return "test";
	}
}

方式B：
springmvc中已经提供了一种从JSON字符串自动转成实体的技术@RequestBody
1.新建实体类UserInfo.java
2.新建控制层，这里修改GetJSONString
@RequestMapping(value="createJSON",method=RequestMethod.POST)
	public String createJSON(@RequestBody Userinfo userinfo){
		System.out.println("username value="+userinfo.getUsername());
		System.out.println("password value="+userinfo.getPassword());
		return "test";
}
3.修改JSP文件
4.在配置文件springmvc.xml中添加<mvc:annotation-driven />注解
需要添加xmlns与xsd
xmlns:mvc="http://www.springframework.org/schema/mvc"
http://www.springframework.org/schema/mvc
http://www.springframework.org/schema/mvc/spring-mvc-3.1.xsd
<!-- 使JSON字符串自动转成实体类 -->
<mvc:annotation-driven />
5.添加jacksonJSON.jar包
