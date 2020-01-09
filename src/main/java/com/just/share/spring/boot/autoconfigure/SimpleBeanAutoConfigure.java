package com.just.share.spring.boot.autoconfigure;


        import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
        import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
        import org.springframework.boot.context.properties.EnableConfigurationProperties;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(SimpleBeanProperties.class)
@Configuration
@ConditionalOnClass({SimpleBeanProperties.class,SimpleService.class})
public class SimpleBeanAutoConfigure {


    private final SimpleBeanProperties properties;

    public SimpleBeanAutoConfigure(SimpleBeanProperties properties) {
        this.properties = properties;
    }
    @Bean
    @ConditionalOnProperty(prefix = "spring.qjq.just",name = "enable",havingValue = "true")
    public SimpleService simpleService(){
        return new SimpleService(properties.getName(),properties.getFiled(),properties.getAdd());
    }
}
