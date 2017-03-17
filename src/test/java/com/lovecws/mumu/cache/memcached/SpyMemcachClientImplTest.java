package com.lovecws.mumu.cache.memcached;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/7.
 */
public class SpyMemcachClientImplTest {
    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-cache-spymemcach.xml");
        applicationContext.start();

        SpyMemcachClient spyMemcachClient= applicationContext.getBean(SpyMemcachClient.class);
        boolean isOK=spyMemcachClient.set("name",60,"i love you");
        System.out.println("添加数据:"+isOK);

        Object obj=spyMemcachClient.get("name");
        System.out.println("存储数据:"+obj);
        applicationContext.close();
    }
}
