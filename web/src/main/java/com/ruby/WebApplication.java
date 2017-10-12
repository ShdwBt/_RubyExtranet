package com.ruby;

import com.ruby.controller.UploadController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ShdwBt on 24/09/2017.
 */
@SpringBootApplication
@EnableScheduling
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean(name = "sessionRegistry")
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    CommandLineRunner init() {
        return (args) -> {
            FileSystemUtils.deleteRecursively(new File(UploadController.ROOT));

            Files.createDirectory(Paths.get(UploadController.ROOT));
        };
    }
}
