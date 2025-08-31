package cn.easygd.example;

import cn.easygd.dynaguard.config.EnableValidation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author VD
 * @date 2025/8/16 11:11
 */
@SpringBootApplication
@EnableValidation
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("启动成功");
    }
}
