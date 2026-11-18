package kr.co.siggy.server.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String N8N_WEBHOOK_URL =
            "http://localhost:5678/webhook/server-error";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e) {

        Map<String, Object> log = new HashMap<>();

        log.put("level", "ERROR");
        log.put("timestamp", LocalDateTime.now().toString());
        log.put("message", e.getMessage());
        log.put("exception", e.getClass().getSimpleName());

        // n8n Webhook 호출
        try {
            restTemplate.postForEntity(
                    N8N_WEBHOOK_URL,
                    log,
                    Void.class
            );
        } catch (Exception n8nException) {
            System.err.println(
                    "n8n Webhook 호출 실패: " + n8nException.getMessage()
            );
        }

        Map<String, Object> response = new HashMap<>();

        response.put("status", 500);
        response.put("message", "Internal Server Error");
        response.put("timestamp", LocalDateTime.now().toString());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}