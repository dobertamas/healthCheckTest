package com.cc.ccp.k8s.healthCheckTest.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle io.fabric8.kubernetes.client.KubernetesClientException
     */
    @ExceptionHandler(io.fabric8.kubernetes.client.KubernetesClientException.class)
    protected ResponseEntity<Object> handleEKubernetesClientException(io.fabric8.kubernetes.client.KubernetesClientException fkckex) {
        return buildResponseEntity(new ApiError(HttpStatus.SERVICE_UNAVAILABLE, "KubernetesClientException - perhaps request body needs update?", fkckex));
    }


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
