package com.example.together.global.annotation;

import com.example.common.annotation.ReadOnlyUseCase;
import com.example.common.annotation.Service;
import com.example.common.annotation.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"com.example"},
        includeFilters = {
                @Filter(
                        type = FilterType.ANNOTATION,
                        classes = {
                                UseCase.class,
                                ReadOnlyUseCase.class,
                                Service.class
                        }
                )
        }
)
public class ComponentScanConfig {
}
