package dmly.micrometer.test.interceptors;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomHandlerInterceptor implements HandlerInterceptor {

    private MeterRegistry meterRegistry;
    private Counter counter;

    public CustomHandlerInterceptor(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        counter.increment();
        System.out.println("++++++++++++++++++++after completion interceptor+++++++++++++++++++++");
    }

    @PostConstruct
    void init() {
        counter = Counter.builder("test.dmly.interceptor").register(meterRegistry);
    }
}
