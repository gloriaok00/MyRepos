package com.example.demo.pingshi.spring.mycontext;

import com.example.demo.pingshi.config.InitApp;
import com.example.demo.pingshi.rest.Person;
import com.example.demo.pingshi.spring.mybean.myauto.Human;
import com.example.demo.pingshi.spring.mybean.myauto.Woman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @description
 * @date 2021-11-19 10:44
 */

public class MyContext {

    public static void main(String[] args) {
        ApplicationContext myContext=new FileSystemXmlApplicationContext("src/main/resources/bean.xml");
        Human myHuman=(Woman)myContext.getBean("mywoman");
        System.out.println(myHuman.runMarathon());

        ApplicationContext myContext2=new AnnotationConfigApplicationContext(ManConfig.class);
        Human myMan=myContext2.getBean(Human.class);
        System.out.println(myMan.runMarathon());

        ApplicationContext myContext3=new AnnotationConfigApplicationContext(InitApp.class);
        //以注解方式注入进来的bean，在没有命名的时候就自动按类的小写字母命了
        //InitApp那里命名了就用了
        InitApp initApp=(InitApp)myContext3.getBean("my_initApp");
        try{
            initApp.run(null);
        }catch (Exception e){
            e.printStackTrace();
        }

        //id在启动时就会检查或在xml编辑时也就校验唯一性,名字比较宽松，会出现下面那种重名的情况，会发生覆盖，覆盖原则略
        ApplicationContext myContext4=new AnnotationConfigApplicationContext(RootConfig.class);
        Person p=(Person)myContext4.getBean("personBean");
        System.out.println(p.toString());
    }
}


@Configuration
class RootConfig {

    @Bean("personBean")
    public Person person() {
        return new Person("RootConfig----Bean", "18");
    }
    @Bean("personBean")
    public Person person2() {
        return new Person("RootConfig----Bean2", "20");
    }

}


