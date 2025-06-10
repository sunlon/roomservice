package com.sunlon.roomservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Component
public class LoggingWebFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingWebFilter.class);

    private static final String CORRELATION_ID_HEADER = "X-Correlation-ID";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest originalRequest = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String correlationId = getOrCreateCorrelationId(originalRequest);
        ServerHttpRequest mutatedRequest = exchange.getRequest().mutate()
                .header(CORRELATION_ID_HEADER, correlationId)
                .build();

        ServerWebExchange mutatedExchange = exchange.mutate()
                .request(mutatedRequest)
                .build();

        long startTime = System.currentTimeMillis();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



        logger.info("[{}] --> start {} {} at {}", correlationId, originalRequest.getMethod(), originalRequest.getURI(),LocalDateTime.now().format(formatter));

        return chain.filter(mutatedExchange)
                .doOnSuccess(done -> {
                    long duration = System.currentTimeMillis() - startTime;
                    logger.info("[{}] <-- exit {} {} at {} in {}ms", correlationId,
                            originalRequest.getMethod(),
                            originalRequest.getURI(), LocalDateTime.now().format(formatter),
                            duration);
                });
    }

    private String getOrCreateCorrelationId(ServerHttpRequest request) {
        List<String> headers = request.getHeaders().get(CORRELATION_ID_HEADER);
        if (headers != null && !headers.isEmpty()) {
            return headers.getFirst();
        }
        return UUID.randomUUID().toString();
    }
}
