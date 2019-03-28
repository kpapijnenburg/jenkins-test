package testapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import testapp.service.DummyMessageService;
import testapp.service.MessageService;

@Configuration
public class DependencyInjection {

    @Bean
    public MessageService getMessageService() {
        return new DummyMessageService();
    }
}
