package com.cc.ccp.k8s.healthCheckTest.services;

import com.cc.ccp.k8s.healthCheckTest.command.CreateDeploymentCommand;
import com.cc.ccp.k8s.healthCheckTest.command.KubernetesActionExecutor;
import com.cc.ccp.k8s.healthCheckTest.command.ScaleDownDeploymentCommand;
import com.cc.ccp.k8s.healthCheckTest.model.KubernetesObjectToDisable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HealthCheckService {

    public boolean createDeploymentSendCommand(KubernetesObjectToDisable kubernetesObjectToDisable) {
        log.info("service received: " + kubernetesObjectToDisable.getDeploymentName());
        KubernetesActionExecutor kubernetesActionExecutor = new KubernetesActionExecutor();
        kubernetesActionExecutor.executeOperation(new CreateDeploymentCommand(), kubernetesObjectToDisable.getDeploymentName(), kubernetesObjectToDisable.getNamespace());
        return true;
    }

    public boolean scaleDownDeploymentCommand(KubernetesObjectToDisable kubernetesObjectToDisable) {
        log.info("service received: " + kubernetesObjectToDisable.getDeploymentName());
        KubernetesActionExecutor kubernetesActionExecutor = new KubernetesActionExecutor();
        kubernetesActionExecutor.executeOperation(new ScaleDownDeploymentCommand(), kubernetesObjectToDisable.getDeploymentName(), kubernetesObjectToDisable.getNamespace());
        return true;
    }

}
