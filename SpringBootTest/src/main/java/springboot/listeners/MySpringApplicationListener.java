package springboot.listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import springboot.config.custom.MyConfig;
import springboot.dto.EmailDto;
import springboot.data.PagingRequest;
import springboot.data.PagingResult;
import springboot.service.EmailMyISAMService;

import static springboot.util.LogUtil.log;

public class MySpringApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        System.out.println();
        System.out.printf("On Application Event:%s", event.getClass().getSimpleName());

        if (event instanceof ApplicationReadyEvent) {

            ApplicationReadyEvent e = (ApplicationReadyEvent) event;


            ApplicationContext context = e.getApplicationContext();

            log("load beans:");
            log("count:%s",context.getBeanDefinitionCount());
            String names[] = context.getBeanDefinitionNames();
            for (int i = 0; i < names.length; i++) {
                String beanName = names[i];
                Object bean = context.getBean(beanName);
                log("bean -- %s", bean.getClass().getSimpleName());
            }

            MyConfig config = context.getBean(MyConfig.class);
            log("%s",config.getPort());

            EmailMyISAMService service = context.getBean(EmailMyISAMService.class);
            PagingRequest request = new PagingRequest();
            request.setPage(1);
            request.setPage_size(10);

            PagingResult<EmailDto> emailDtoPagingResult = service.selectByPaging(request);
            log("-- total emails:%s -- ",emailDtoPagingResult.getTotal_records());

            //service.generateEmails(Integer.MAX_VALUE);
        }
    }
}
