package com.niantic.controllers.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@RestController
public class BeansController
{
    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/beans")
    public ResponseEntity<List<String>> getBeans()
    {
        var dataSource = applicationContext.getBean(DataSource.class);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        var beans = Arrays.stream(beanNames).filter(beanName -> beanName.indexOf('.') < 0).toList();

        return ResponseEntity.ok(beans);
    }
}
