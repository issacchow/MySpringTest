package springboot.config;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springboot.beans.MyBean;
import springboot.util.BeanInitLogger;

import javax.swing.*;

import static springboot.util.LogUtil.*;

@PropertySource("application.properties")
@Component
public class AppConfig extends BeanInitLogger{


    @Bean("myBean")
    @Order(1)
    public MyBean getMyBean(){
        log("order 2");
        return new MyBean();
    }

    @Bean("myBean2")
    @Order(2)
    public MyBean getMyBean2(){
        log("order 1");
        return new MyBean();
    }











}
