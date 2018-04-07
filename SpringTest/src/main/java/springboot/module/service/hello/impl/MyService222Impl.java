package springboot.module.service.hello.impl;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import springboot.module.service.hello.MyService;
import springboot.module.service.hello.MyService222;
import springboot.util.BeanInitLogger;
import  static springboot.util.LogUtil.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
@DependsOn()
public class MyService222Impl extends BeanInitLogger implements MyService222 {

    @Resource
    private MyService myService;



    public void invoke() {
        log("myService222 invoked!");
    }

    @Override
    protected void preDestroy() {
       myService.invoke();
    }

    @Override
    protected void onInit() {
        super.onInit();
    }
}
