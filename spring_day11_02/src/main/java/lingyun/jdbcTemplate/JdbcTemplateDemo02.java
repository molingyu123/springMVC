package lingyun.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate 模板的基本用法
 */
public class JdbcTemplateDemo02 {
    public static void main(String[] args) {
//        // 准备数据源spring 的内置数据源
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        //驱动
//        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        // 数据库地址
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/demo");
//        //用户名
//        driverManagerDataSource.setUsername("root");
//        // 密码
//        driverManagerDataSource.setPassword("123456");
//        // 1.创建对象JdbcTemplate
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);

//        // 执行操作
//        jdbcTemplate.execute("insert into account(name,money) values('ccc',1000)");

        // 使用配置的方式
        //1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
        jdbcTemplate.execute("insert into account (name,money) value ('ddd',10000)");


    }
}
