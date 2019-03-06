A:传回JSON对象
1.新建控制层文件CreateJSON.java
@Controller
public class CreateJSON {

	//通过consumes="application/json"限制前台传入数据的格式是JSON
	//produces="application/json"将返回的数据转成JSON对象并传回客户端
	//@ResponseBody将JSON字符串作为响应处理
	@RequestMapping(value="createJSON",method = RequestMethod.POST,
			consumes="application/json",produces="application/json"
			)
	@ResponseBody
	public Userinfo createJSON(@RequestBody Userinfo userinfoParam){
		System.out.println(userinfoParam.toString());
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername("传回对象了");
		userinfo.setPassword("123");
		return userinfo;
	}
}
2.新建JSP文件
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
</script>
3.可能存在的问题 org.codehaus.jackson.map.SerializationConfig.isEnabled，
jackson-all-1.9.0.jar 版本太低导致，需要导入3个jackon依赖包

B：传回JSON字符串
1.新建控制层文件ReturnJSONString.java
@Controller
public class ReturnJSONString {

	@RequestMapping("returnJson")
	@ResponseBody
	public String returnJson(){
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername("lala啦");
		userinfo.setPassword("123");
		return (new JSONObject(userinfo)).toString();
	}
}
2.修改jsp
function returnJson(){
	$.ajax({
		type:"POST",
		url:"returnJson.spring?t=" +new Date().getTime(),
		contentType:"application/json",
		dataType:"json",
		success:function(data,type){
			var jsonObject = JSON.parse(data);
			alert(jsonObject.username);
		}
	});
}
3.配置mvc.xml
<context:component-scan base-package="com.ssm.springmvc"></context:component-scan>

<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
	<property name="messageConverters">
		<list>
			<ref bean="stringHttpMessageConverter"/>
		</list>
	</property>
</bean>
<bean id="stringHttpMessageConverter" class="org.springframework.http.converter.StringHttpMessageConverter">
	<property name="supportedMediaTypes">
		<list>
			<value>text/plain;charset=utf-8</value>
		</list>
	</property>
</bean>

<!-- 使JSON字符串自动转成实体类 -->
<mvc:annotation-driven />
4.问题出现：
org.springframework.web.util.NestedServletException: Handler processing failed; nested exception is java.lang.NoClassDefFoundError: org/springframework/util/StreamUtils
jar包下没有该类，需要替换。。