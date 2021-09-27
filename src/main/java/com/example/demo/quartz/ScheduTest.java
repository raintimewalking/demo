package com.example.demo.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduTest {

    @Scheduled(cron = "0/5 * * * * ?")
    private void schedutest001(){

        System.out.println("定时任务执行===");
    }

}
