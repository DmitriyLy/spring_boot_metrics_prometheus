package dmly.micrometer.test.interceptors;

import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.Counter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomHandlerInterceptor implements HandlerInterceptor {

    private static final Counter requests = Counter.build().name("requests_total").help("Total number of requests.").labelNames("get").register();

    private MeterRegistry meterRegistry;

    public CustomHandlerInterceptor(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        requests.labels("dmly.test").inc();
        System.out.println("++++++++++++++++++++after completion interceptor+++++++++++++++++++++");
    }

    @PostConstruct
    void init() {
    }
}
