package com.zhou.zhouboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Conditional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//@MapperScan("com.zhou.zhouboot.mapper.*
public class ZhouBootApplication {
    private static BlockingQueue blockingQueue=new ArrayBlockingQueue(1000);
    public static void main(String[] args) {
        Integer[] integers = new Integer[100];
        System.out.println(integers.length);
        System.out.println(integers[90]);
//        SpringApplication.exit(SpringApplication.run(ZhouBootApplication.class, args));
        Demo demo = new Demo();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 20, 100, TimeUnit.SECONDS, blockingQueue);
//        threadPoolExecutor.execute(()->{
//            System.out.println("hello");
//        });

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPoolExecutor.execute(()->{
                demo.setDemoList(finalI);
            });
        }
        StringBuffer stringBuffer = new StringBuffer("当前列表内容：");
        stringBuffer.append("当前存储长度").append(demo.getDemoList().size())
                .append("当前存储内容："+demo.getDemoList().get(80));
        System.out.println(stringBuffer.toString());
        SpringApplication.run(ZhouBootApplication.class, args);
    }

}

class Demo{
    public List demoList=Collections.synchronizedList(new ArrayList<Integer>(100));;

    public void setDemoList(int i) {
        demoList.add(i);
    }

    public List getDemoList() {
        return demoList;
    }
}