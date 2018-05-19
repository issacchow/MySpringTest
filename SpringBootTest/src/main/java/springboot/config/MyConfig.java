package springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "myconfig")
public class MyConfig {

    private String url;
    private int port;
    private NestedConfig nestedConfig;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @ConfigurationProperties("nested")
    public NestedConfig getNestedConfig() {
        return nestedConfig;
    }

    public void setNestedConfig(NestedConfig nestedConfig) {
        this.nestedConfig = nestedConfig;
    }


    /**** class ****/
    public class NestedConfig extends MyConfig{
    }
}
