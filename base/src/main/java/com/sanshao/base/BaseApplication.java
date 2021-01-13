package com.sanshao.base;

import com.sanshao.base.bean.Car;
import com.sanshao.base.bean.Person;
import com.sanshao.base.bean.Student;
import com.sanshao.base.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class BaseApplication {

    public static void main(String[] args) {
        // 得到IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(BaseApplication.class, args);

        // 遍历所有的组件名称
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 是否存在某个Bean
        boolean mycar0 = run.containsBean("mycar0");
        System.out.println("mycar0  " + mycar0);

        boolean person0 = run.containsBean("person0");
        System.out.println("person  " + person0);

        // MyConfig也是一个组件，通过MyConfig来测试 proxyBeanMethods属性
        // 如果是true表示full模式，每次都查找容器
        // false表示lite模式，每次都新建对象
        MyConfig myconfig = run.getBean("myConfig", MyConfig.class);

        Car car1 = myconfig.car0();
        Car car2 = myconfig.car0();
        System.out.println("car1 == car2  " + (car1 == car2));

        Person person01 = run.getBean("person0", Person.class);
        System.out.println(person01);

        // 通过文件注入
        Student student = run.getBean("student", Student.class);
        System.out.println(student);

    }

}
