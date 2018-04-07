package springboot.listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import springboot.util.LogUtil;

public class MySpringApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        System.out.println();
        System.out.printf("On Application Event:%s", event.getClass().getSimpleName());

        if (event instanceof ApplicationReadyEvent) {

            ApplicationReadyEvent e = (ApplicationReadyEvent) event;


            ApplicationContext context = e.getApplicationContext();

            LogUtil.log("load beans:");
            LogUtil.log("count:%s",context.getBeanDefinitionCount());
            String names[] = context.getBeanDefinitionNames();
            for (int i = 0; i < names.length; i++) {
                String beanName = names[i];
                Object bean = context.getBean(beanName);
                LogUtil.log("bean -- %s", bean.getClass().getSimpleName());
            }

        }
    }
}
