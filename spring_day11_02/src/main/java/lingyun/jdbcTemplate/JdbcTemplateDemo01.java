package lingyun.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate 模板的基本用法
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        // 准备数据源spring 的内置数据源
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        //驱动
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        // 数据库地址
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        //用户名
        driverManagerDataSource.setUsername("root");
        // 密码
        driverManagerDataSource.setPassword("123456");
        // 1.创建对象JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        // 执行操作
        jdbcTemplate.execute("insert into account(name,money) values('ccc',1000)");

    }
}
