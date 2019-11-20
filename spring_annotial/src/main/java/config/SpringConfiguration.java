package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * spring 配置类相当于xml
 */
@Configuration
@ComponentScan("lingyun")
@Component
@Import({JdbcConfiguration.class,TransactionConfig.class})
@PropertySource("JdbcConfig.properties")
@EnableTransactionManagement   //这个注解开启事务管理器

public class SpringConfiguration {

}
