package springboot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import springboot.util.BeanInitLogger;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


public class DataSourceConfig extends BeanInitLogger {


    @Bean("writeDataSource")
    @ConfigurationProperties("spring.datasource.write")
    public DataSource buildWriteDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("readDataSource")
    @ConfigurationProperties("spring.datasource.read")
    public DataSource buildReadDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 创建数据源代理类
     *
     * @return
     */
    @Bean
    @Primary
    public DataSource buildDataSourceProxy(
    ) {
        DataSourceProxy proxy = new DataSourceProxy();
        return proxy;
    }

    private class DataSourceProxy extends AbstractRoutingDataSource {

        @Resource(name="writeDataSource")
        DataSource writeDataSource;

        @Resource(name="readDataSource")
        DataSource readDataSource;

        Map<Object,Object> mapDataSorce;

        public DataSourceProxy(DataSource... dataSources) {
          mapDataSorce = new HashMap<>();

        }

        @Override
        protected Object determineCurrentLookupKey() {
            return "writeDataSource";
        }

        @Override
        protected DataSource determineTargetDataSource() {
          return (DataSource)mapDataSorce.get(determineCurrentLookupKey());
        }

        public void addDataSource(String key,DataSource dataSource){
            this.mapDataSorce.put(key,dataSource);
        }


        @Override
        public void afterPropertiesSet() {
            this.mapDataSorce.put("writeDataSource", writeDataSource);
            this.mapDataSorce.put("readDataSource", readDataSource);

            this.setTargetDataSources(mapDataSorce);
        }
    }

}
