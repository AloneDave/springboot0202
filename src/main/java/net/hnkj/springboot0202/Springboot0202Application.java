package net.hnkj.springboot0202;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("net.hnkj.springboot0202.mapper") //扫描所有的mapper接口
@EnableTransactionManagement  //开启事务管理器
public class Springboot0202Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot0202Application.class, args);
    }

}
