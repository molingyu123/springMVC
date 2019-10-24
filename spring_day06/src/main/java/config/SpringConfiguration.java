package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

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
 * @Import：
 *    作用：导入其它的配置类
 *    属性：
 *      value:用于指定其它配置类的字节码当我们使用Import 的注解后，有Import注解的累，就是父配置类
 *            导入的就是配置类
 * @PropertySource
 *   作用：用于指定properties文件的位置
 *   属性：
 *    value:指定文件的名称和路径 关键字classpath,表示类路径下
 *
 *
 */
@Qualifier
@Configuration
@ComponentScan("com.lingyun")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
