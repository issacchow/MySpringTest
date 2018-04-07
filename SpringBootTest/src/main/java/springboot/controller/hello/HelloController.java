package springboot.controller.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.beans.MyBean;
import springboot.util.BeanInitLogger;

@RestController
@RequestMapping("/hello")
public class HelloController extends BeanInitLogger {


    @RequestMapping(value = { "/","index"})
    public Object index(){
       return new MyBean();
    }


}
