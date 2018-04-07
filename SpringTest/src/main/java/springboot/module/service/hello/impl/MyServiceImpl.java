package springboot.module.service.hello.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import springboot.module.service.hello.MyService;
import springboot.module.service.hello.MyService222;
import springboot.util.BeanInitLogger;
import springboot.util.LogUtil;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import static springboot.util.LogUtil.log;


@Service
@DependsOn("myBean")
public class MyServiceImpl  extends BeanInitLogger implements MyService  {


    @Resource
    private MyService222 myService222;

    public void invoke() {
        log("myService222 invoked!");
    }

    @Override
    protected void onInit() {
        myService222.invoke();
    }
}
