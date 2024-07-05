package com.neuedu.demo.tijian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.neuedu.demo.tijian.mapper")
@EnableTransactionManagement
@EnableScheduling
public class TijianApplication {

    public static void main(String[] args) {
        SpringApplication.run(TijianApplication.class, args);
    }

}
