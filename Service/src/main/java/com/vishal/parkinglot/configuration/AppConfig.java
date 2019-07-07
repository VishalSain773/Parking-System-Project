package com.vishal.parkinglot.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.vishal.parkinglot.jsonobject.SlotFlag;

@Configuration
@ComponentScan(basePackages = "com.vishal.parkinglot")
public class AppConfig {
 
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SlotFlag slotFlag() {
    	System.out.println("new SlotFlag");
        return new SlotFlag();
    }
    
}