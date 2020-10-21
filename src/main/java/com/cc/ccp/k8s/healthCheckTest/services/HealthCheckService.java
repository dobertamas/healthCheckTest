package com.cc.ccp.k8s.healthCheckTest.services;

import com.cc.ccp.k8s.healthCheckTest.command.CreateDeploymentCommand;
import com.cc.ccp.k8s.healthCheckTest.command.KubernetesActionExecutor;
import com.cc.ccp.k8s.healthCheckTest.model.KubernetesObjectToDisable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HealthCheckService {

    public boolean createSendCommand(KubernetesObjectToDisable kubernetesObjectToDisable) {
        log.info("service received: " + kubernetesObjectToDisable.getName());
        KubernetesActionExecutor kubernetesActionExecutor = new KubernetesActionExecutor();
        kubernetesActionExecutor.executeOperation(new CreateDeploymentCommand(),kubernetesObjectToDisable.getName(),null);
        return true;

    }
}
