package dmly.micrometer.test.interceptors;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private MeterRegistry meterRegistry;


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        meterRegistry.counter("dmly.counter.interceptor", Tags.of(
                Tag.of("tag_key", "tag_value")
        )).increment();

        System.out.println("++++++++++++++++++++after completion interceptor+++++++++++++++++++++");
    }

    @PostConstruct
    void init() {
    }
}
