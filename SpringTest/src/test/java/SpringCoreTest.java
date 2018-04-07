import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.support.XmlWebApplicationContext;


public class SpringCoreTest {


    @Test
    public void ResourceLoaderTest(){

        ResourceLoader loader = new DefaultResourceLoader();
        Resource fileResource = loader.getResource("file:G:\\Tool.ini");
        Resource classpathResource = loader.getResource("classpath:my.properties");

        assertTrue(fileResource.isReadable());
        assertTrue(classpathResource.isReadable());

    }

    public void ApplicationContextTest(){


        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext();
        context.setConfigLocation("D:\\workspace\\SpringBootTest\\src\\test\\resources\\spring-config.xml");
        context.refresh();
    }
}
