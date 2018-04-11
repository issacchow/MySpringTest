package springboot.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class MyBatisConfig {

    @Bean
    public void buildSqlSessionFactory(){

        SqlSessionFactoryBean bean;
        
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build()
    }

}
