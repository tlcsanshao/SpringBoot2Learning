package com.sanshao.base.config;

import com.sanshao.base.bean.Car;
import com.sanshao.base.bean.Person;
import com.sanshao.base.bean.Student;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean("mycar0")
    public Car car0() {
        return new Car("byd", 10000l);
    }

    @Bean
    public Person person0(Car car) {
        return new Person(car, "zhangsan", 100);
    }

}
