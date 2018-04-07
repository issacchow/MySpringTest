package springboot.application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springboot.config.AppConfig;
import springboot.config.mapping.DatabaseConfig;

import static springboot.util.LogUtil.*;
/**
 * 使用注解配置的应用程序
 */
public class AnntotationConfigApplication {

    public static void main(String... args){

        log("context start");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();//监听线程关闭钩子,从而达到自动关闭功能,否则需要手动调用close功能
        log("context initialized!");

        DatabaseConfig dbCfg = context.getBean(DatabaseConfig.class);
        context.close();
    }

}
