package plant.flashcards.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

/**
 * log time in/out of web requests in our application
 * we want to perform some of pre-processing and post-processing on a request and/or response like AOP but based on a web request
 */
@Component("stopWatchInterceptor")
@Log4j2
public class StopWatchInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Request started at :" + Instant.now());
        return HandlerInterceptor.super.preHandle(request, response, handler);
        // return false;
        // we don't want to proceed any further
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Method executed at:"+ Instant.now());
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Request completed and rendered the page at:"+ Instant.now());
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
