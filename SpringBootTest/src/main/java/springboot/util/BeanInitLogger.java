package springboot.util;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static springboot.util.LogUtil.log;

public abstract class BeanInitLogger {

    private String name = this.getClass().getName();
    public BeanInitLogger(){
        log("%s  -- init",name);
    }

    @PostConstruct
    final public void init(){
        log("%s -- onInit",name);
        onInit();
    }

    protected void onInit(){}

    @PreDestroy
    final public void destroy(){
        log("%s -- preDestroy",name);
        preDestroy();
    }


     protected void preDestroy(){}
}
