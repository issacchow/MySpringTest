package springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springboot.config.SpringConfigMarker;
import springboot.controller.ControllerMarker;

import static springboot.util.LogUtil.log;


@SpringBootApplication(
        scanBasePackageClasses = {SpringConfigMarker.class, ControllerMarker.class}
)
@PropertySource("application.properties")
public class MySpringBootApplication {


    public static  void main(String...args){
        int a = 2;
        int b = a<<15;
        log("%s",b);

       SpringApplication.run(MySpringBootApplication.class,args);
    }

}
