package com.cc.ccp.k8s.healthCheckTest.controllers;

import com.cc.ccp.k8s.healthCheckTest.model.KubernetesObjectToDisable;
import com.cc.ccp.k8s.healthCheckTest.services.HealthCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthCheckController {

    private final HealthCheckService healthCheckService;

    public HealthCheckController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @PostMapping("/disable")
    public ResponseEntity postController(
            @NonNull
            @RequestBody KubernetesObjectToDisable kubernetesObjectToDisable) {
        log.info("controller received: " + kubernetesObjectToDisable.getName());

        healthCheckService.createSendCommand(kubernetesObjectToDisable);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}