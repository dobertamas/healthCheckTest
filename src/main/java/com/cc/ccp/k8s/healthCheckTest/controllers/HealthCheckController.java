package com.cc.ccp.k8s.healthCheckTest.controllers;

import com.cc.ccp.k8s.healthCheckTest.model.KubernetesDeploymentToDisable;
import com.cc.ccp.k8s.healthCheckTest.model.KubernetesDeploymentToScaleUp;
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

    @PostMapping("/create")
    public ResponseEntity<?> createController(
            @NonNull
            @RequestBody KubernetesDeploymentToDisable kubernetesObjectToDisable) {
        log.info("controller received request about: " + kubernetesObjectToDisable.getDeploymentName());

        final boolean sendCommand = healthCheckService.createDeploymentSendCommand(kubernetesObjectToDisable);
        log.info("sent command: " + sendCommand);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/scaleDown")
    public ResponseEntity<?> scaleDownController(
            @NonNull
            @RequestBody KubernetesDeploymentToDisable kubernetesObjectToDisable) {
        log.info("controller received request about : " + kubernetesObjectToDisable.getDeploymentName());

        final boolean sendCommand = healthCheckService.scaleDownDeploymentCommand(kubernetesObjectToDisable);
        log.info("sent command: " + sendCommand);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/scaleUp")
    public ResponseEntity<?> scaleUpController(
            @NonNull
            @RequestBody KubernetesDeploymentToScaleUp kubernetesDeploymentToScaleUp) {
        log.info("controller received request about : " +
                kubernetesDeploymentToScaleUp.getDeploymentName() + " for " + kubernetesDeploymentToScaleUp.getPodsToHave() + " pods");

        final boolean sendCommand = healthCheckService.scaleUpDeploymentCommand(kubernetesDeploymentToScaleUp);
        log.info("sent command: " + sendCommand);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
