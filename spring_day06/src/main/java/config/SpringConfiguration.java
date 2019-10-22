package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 该类是个配置类和bean.xml 是属于同样的功能
 * spring 中的新注解：
 * @Configuration:
 *    作用：表明当前类是一个配置类
 * @ComponentScan ：
 *    作用：用于通过注解指定spring 在创建容器时要扫描的包
 *    属性：
 *       value: 它和basePackages 的作用是相同的，都是用于指定创建容器时要扫描的包
 *              我们使用此注解就等同于在xml 配置：
 *              <context:component-scan base-package="com.lingyun"/>
 * @Bean :
 *   作用：用于把当前方法的返回值作为bean 对象存入spring 的ioc 容器中
 *   属性：
 *     name:用于指定bean 的id,当不指定id名，默认值是当前方法的名称
 *     细节：
 *       当我们使用注解配置方法时，如果方法有参数，spring会去容器中查找有没有可用的bean 对象
 *       查找的方式和Autowired 注解的作用是一样的，自动按照类型匹配注入，
 *
 */
@Configuration
@ComponentScan(basePackages = "com.lingyun")
public class SpringConfiguration {

    /**
     * 用于创建一个QueryRunner 对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return  new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean("dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            return dataSource;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
