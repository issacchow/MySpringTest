package springboot;


import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import springboot.advice.AdviceMarker;
import springboot.config.SpringConfigMarker;
import springboot.controller.ControllerMarker;
import springboot.service.ServiceMarker;

import javax.sql.DataSource;

import static springboot.util.LogUtil.log;

/**
 * 多数据源应用程序(读写分离)
 */
@SpringBootApplication(
        scanBasePackageClasses = {
                SpringConfigMarker.class,
                ControllerMarker.class,
                ServiceMarker.class,
                AdviceMarker.class
        },
        exclude = {
                DataSourceAutoConfiguration.class,
                MybatisAutoConfiguration.class
        }
)
//@PropertySource("application.properties")
public class MutilDataSourceApplication {


    public static  void main(String...args){
        int a = 2;
        int b = a<<15;
        log("%s",b);

       SpringApplication.run(MutilDataSourceApplication.class,args);
    }

}
