package rtek.perpus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.Validator;

public class Validation {
    @Bean
    public Validator getValidator() {
        return new LocalValidatorFactoryBean();
    }
}
