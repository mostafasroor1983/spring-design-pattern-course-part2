package plant.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import plant.flashcards.interceptor.StopWatchInterceptor;

@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer {

    HandlerInterceptor stopWatchInterceptor;

    public ApplicationConfiguration(StopWatchInterceptor stopWatchInterceptor) {
        this.stopWatchInterceptor = stopWatchInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(stopWatchInterceptor);
    }
}
