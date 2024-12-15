package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Value("${file.path}") // application.properties dosyasındaki file.path değerini al
    private String filePath;

    @Bean
    public CSVReader csvReader() throws IOException {
        return new CSVReader(filePath); // Tek bir CSVReader örneği oluştur
    }
}

