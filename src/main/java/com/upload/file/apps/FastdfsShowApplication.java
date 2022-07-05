package com.upload.file.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.upload.file.apps","com.luhuiguo.fastdfs"})
@SpringBootApplication
public class FastdfsShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastdfsShowApplication.class, args);
    }

}
