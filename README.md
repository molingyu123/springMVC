# springMVC
spring 注解的范围及demo 演示

原创： MLY云  凌vs云  10月22日
xml bean 的配置方式还有作用域的范围的注入，以及bean 创建的生命周期，下面我们演示下使用bean 的范围：




value 属性可以写可以不写这个也是默认的存在的，默认不指定bean 的作用范围就是单列的对象，如果需要指定就需要是用@Scope 这个注解加以说明，在实际的开发过程中，看使用的场景和环境；
bean 的生命周期就是从开始到结束的过程，我们需要知道什么时候开始创建对象，什么时候开始结束对象：使用注解注入：


       和我们使用xml 配置是相同的，

这个是我们注解的方式对比xml 配置的对比演示完成
3.演示下整体使用xml 配置的demo
git@github.com:molingyu123/springMVC.git
上面是存放项目的地址，demo项目如下：

配置bean 对象：

配置数据源，用于连接数据库操作的：

pom 文件：

测试类：



测试结果：
