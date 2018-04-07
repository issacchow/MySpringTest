package springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springboot.config.SpringConfigMarker;
import springboot.controller.ControllerMarker;


@SpringBootApplication(
        scanBasePackageClasses = {SpringConfigMarker.class, ControllerMarker.class}
)
@PropertySource("application.properties")
public class MySpringBootApplication {

    public static  void main(String...args){

        SpringApplication.run(MySpringBootApplication.class,args);
    }

}
