package com.lovecws.mumu.cache.memcached;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/7.
 */
public class XMemcachedClientImplTest {
    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-cache-xmemcached.xml");
        applicationContext.start();

        XMemcachClient xMemcachClient= applicationContext.getBean(XMemcachClient.class);
        boolean isOK=xMemcachClient.set("name",60,"i love you");
        System.out.println("添加数据:"+isOK);

        Object obj=xMemcachClient.get("name");
        System.out.println("存储数据:"+obj);
        applicationContext.close();
    }
}
