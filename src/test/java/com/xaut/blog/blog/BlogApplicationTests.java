package com.xaut.blog.blog;

import com.xaut.blog.blog.dao.AlphaDao;
import com.xaut.blog.blog.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = BlogApplication.class)
class BlogApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext){
		this.applicationContext = applicationContext;
	}
	@Test
	public void testApplicationContext(){
//		AlphaHibernateDaoImpl alphaHibernateDaoImpl = applicationContext.getBean(AlphaHibernateDaoImpl.class);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
//		alphaHibernateDaoImpl.select();
//		System.out.println(alphaHibernateDaoImpl.select());
		System.out.println(alphaDao.select());
		//想在此处获取Hibernate实现的Dao
//		alphaDao = (AlphaDao) applicationContext.getBean("alphaDaoHibernateImpl");//使用AlphaDao强制转型
//		alphaDao = applicationContext.getBean("alphaDaoHibernateImpl",AlphaDao.class);//使用参数转型
		alphaDao = applicationContext.getBean("h",AlphaDao.class);//使用参数转型
		System.out.println(alphaDao.select());
	}
	@Test
	public void testSpringBeanManagement(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);//获取到Bean对象
		System.out.println(alphaService);//打印第一次获取的对象
		alphaService = applicationContext.getBean(AlphaService.class);//再获取一次Bean对象
		System.out.println(alphaService);//打印第二次获取的对象（看看两个对象是否一样，来检验是不是单例模式）
	}
	@Test
	public void testBean(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean("simpleDateFormat",SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));

	}
	@Autowired
	@Qualifier("h")
	private AlphaDao alphaDao;

	@Test
	public void testDI(){
		System.out.println(alphaDao);
	}


}
