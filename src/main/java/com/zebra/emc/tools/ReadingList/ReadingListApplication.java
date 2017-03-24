package com.zebra.emc.tools.ReadingList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication:
 *  - @Configuration: Indicates that this class can be used by IoC container.
 *  - @EnableAutoConfiguration: Automatically configure Spring app based on jar dependencies.
 *  - @ComponentScan: Equivalent for "context:component-scan", specify the base packages to scan.
 *                      So that the web controller classes and other components will be
 *                      auto-discovered and registered as beans in Spring application context.
 */
@SpringBootApplication
public class ReadingListApplication {

    public static void main(String[] args) {
        /*
         * Bootstrap the application, pass a ref to the ReadlingListApplication class to
         * SpringApplication.run(), along with the command-line arguments, to kick off the app
         */
        SpringApplication.run(ReadingListApplication.class, args);
    }
}
