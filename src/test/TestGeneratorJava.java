package test;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class TestGeneratorJava {

	@Test
	public void TestGenerator(){
		ArrayList<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		try{
			System.out.println("generatorJava开始");
			File configFile = new File("config/generatorConfig.xml");
			ConfigurationParser cParser = new ConfigurationParser(warnings);
			Configuration configuration = cParser.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("generatorJava结束");
		}catch(Exception e){
			System.out.println("generatorJava出错");
			e.printStackTrace();
		}
	}
}
