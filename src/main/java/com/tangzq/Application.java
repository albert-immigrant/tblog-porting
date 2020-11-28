package com.tangzq;

//import com.tangzq.model.User;
//import com.tangzq.repository.UserRepository;
//import com.tangzq.utils.CommonProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.DigestUtils;


import java.lang.management.ManagementFactory;

/**
 * 应用启动入口类
 * @author tangzhiqiang
 */
@SpringBootApplication(scanBasePackages = "com.tangzq",exclude = JmxAutoConfiguration.class)
//@SpringBootApplication(scanBasePackages = "com.tangzq")
@EnableJpaRepositories(basePackages = "com.tangzq")
@EnableCaching
public class Application implements CommandLineRunner {


//	@Autowired
//	private UserRepository userRepository;

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(Application.class);
//	}

	public static void main(String[] args) {

	String pname=ManagementFactory.getRuntimeMXBean().getName();
	System.out.println("-------------"+pname+"-------");
	System.out.println("-------------"+new ApplicationPid().toString()+"-------");

		SpringApplication.run(Application.class, args);
	}

	/**
	 * 通过实现CommandLineRunner接口，在应用启动时调用
	 * @param strings
	 * @throws Exception
	 */
	@Override
	public void run(String... strings) throws Exception {
		System.out.println("开始初始化数据....");
		//	initUser();
		System.out.println("初始化数据完成....");
	}

	/**
	 * 初始化系统管理员
	 **/

	/*
	private void initUser(){
		User u=userRepository.findByUsername(CommonProps.ADMIN_NAME);
		if(null==u){
			u=new User();
			u.setUsername(CommonProps.ADMIN_NAME);
			u.setPassword(DigestUtils.md5DigestAsHex(CommonProps.ADMIN_PWD.getBytes()));
			u.setEmail(CommonProps.ADMIN_EMAIL);
			userRepository.save(u);
			System.out.println("初始化管理员账号成功！");
		}else{
			System.out.println("管理员账号已经存在");
		}
	}

*/
	/*
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propsConfig
				= new PropertySourcesPlaceholderConfigurer();
		propsConfig.setLocation(new ClassPathResource("git.properties"));
		propsConfig.setIgnoreResourceNotFound(true);
		propsConfig.setIgnoreUnresolvablePlaceholders(true);
		return propsConfig;
	}
	*/
}
