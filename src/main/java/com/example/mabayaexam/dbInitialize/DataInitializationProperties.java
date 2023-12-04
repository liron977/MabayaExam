package com.example.mabayaexam.dbInitialize;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "data.initialization")
@Getter
@Setter
public class DataInitializationProperties {

    private boolean enabled;
    private List<String> categories;

}