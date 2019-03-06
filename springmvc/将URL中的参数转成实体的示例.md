1.新建控制层文件ParamToEntity.java
@Controller
public class ParamToEntity {
	
	@RequestMapping("paramToEntity")
	public String ParamToEntity(Userinfo userinfo){
		System.out.println(userinfo.getUsername());
		System.out.println(userinfo.getPassword());
		return "test";
	}
}

2.在web.xml中配置字符编码过滤器：
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

3.新建paramToEntity.jsp