A:在控制层获取HttpServletRequest和HttpServletResponse对象
1.新建控制层GetRequest.java
@RequestMapping("/getRequest1")
public String getRequest1(HttpServletRequest request,HttpServletResponse response){
	System.out.println("request1："+request);
	System.out.println("response1："+response);
	request.setAttribute("username", "心塞塞");
	return "index";
}

B:使用HttpServletResponse对象输出响应字符
1.修改控制层
@RequestMapping("/getResponse1")
public void login(HttpServletResponse response){
	try {
		String username = "xuxuxux";
		System.out.println(username);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("我是心塞塞");
		out.flush();out.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

C:通过URL参数访问指定的业务方法
对于处理多个URL请求的eController来说，建议通过一个URL参数指定Controller处理方法名称
1.新建List.java
@Controller
public class List {
	@RequestMapping(value="/list",params="type=a")
	public String listA(){
		System.out.println("AAA");
		return "index";
	}
	
	@RequestMapping(value="/list",params="type=b")
	public String listB(){
		System.out.println("BBB");
		return "index";
	}
}
