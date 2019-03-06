A:单文件上传
1.新建FileUpload.java
@RequestMapping("/oneFileUpload")
public void oneFileUpload(MultipartHttpServletRequest request,HttpServletResponse response){
	try {
		System.out.println("username="+request.getParameter("username"));
		MultipartFile file = request.getFile("uploadFile");
		String uploadFileName = file.getOriginalFilename();
		
		InputStream isRef = file.getInputStream();
		
		String targetDir = request.getSession().getServletContext().getRealPath("/upload");
		File targetFile = new File(targetDir,uploadFileName);
		FileOutputStream fosRef = new FileOutputStream(targetFile);
		IOUtils.copy(isRef, fosRef);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//需要与前台file文件域name名称一样，还需要再MulitpartFile前加上@RequestParam注解，否则出现异常
@RequestMapping("/oneFileUpload2")
public void oneFileUpload2(@RequestParam String username,@RequestParam MultipartFile uploadFile,HttpServletRequest request){
	try {
		System.out.println("方法2");
		System.out.println("username="+request.getParameter("username"));
		MultipartFile file = uploadFile;
		String uploadFileName = file.getOriginalFilename();
		
		InputStream isRef = file.getInputStream();
		
		String targetDir = request.getSession().getServletContext().getRealPath("/upload");
		File targetFile = new File(targetDir,uploadFileName);
		FileOutputStream fosRef = new FileOutputStream(targetFile);
		IOUtils.copy(isRef, fosRef);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
2.配置mvc.xml，声明上传请求
<!-- 文件上传请求 -->
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	<property name="maxUploadSize" value="204800000" />
</bean>
3.创建JSP文件
<form action="oneFileUpload.spring" method="post" enctype="multipart/form-data">
	<input type="text" name="username">
	<input type="file" name="uploadFile">
	<input type="submit" value="单文件上传">
</form>
<form action="oneFileUpload2.spring" method="post" enctype="multipart/form-data">
	<input type="text" name="username">
	<input type="file" name="uploadFile">
	<input type="submit" value="单文件2222上传">
</form>

