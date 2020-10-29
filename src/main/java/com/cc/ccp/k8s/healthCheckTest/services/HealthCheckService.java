package com.cc.ccp.k8s.healthCheckTest.services;

import com.cc.ccp.k8s.healthCheckTest.command.CreateDeploymentCommand;
import com.cc.ccp.k8s.healthCheckTest.command.KubernetesActionExecutor;
import com.cc.ccp.k8s.healthCheckTest.command.ScaleDownDeploymentCommand;
import com.cc.ccp.k8s.healthCheckTest.command.ScaleUpDeploymentCommand;
import com.cc.ccp.k8s.healthCheckTest.model.KubernetesDeploymentToDisable;
import com.cc.ccp.k8s.healthCheckTest.model.KubernetesDeploymentToScaleUp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HealthCheckService {

    public boolean createDeploymentSendCommand(KubernetesDeploymentToDisable kubernetesObjectToDisable) {
        log.info("service received request about deployment " + kubernetesObjectToDisable.getDeploymentName());
        KubernetesActionExecutor kubernetesActionExecutor = new KubernetesActionExecutor();
        kubernetesActionExecutor.executeOperation(new CreateDeploymentCommand(), kubernetesObjectToDisable.getDeploymentName(), kubernetesObjectToDisable.getNamespace());
        return true;
    }

    public boolean scaleDownDeploymentCommand(KubernetesDeploymentToDisable kubernetesObjectToDisable) {
        log.info("service received request about deployment " + kubernetesObjectToDisable.getDeploymentName());
        KubernetesActionExecutor kubernetesActionExecutor = new KubernetesActionExecutor();
        kubernetesActionExecutor.executeOperation(new ScaleDownDeploymentCommand(), kubernetesObjectToDisable.getDeploymentName(), kubernetesObjectToDisable.getNamespace());
        return true;
    }

    public boolean scaleUpDeploymentCommand(KubernetesDeploymentToScaleUp kubernetesDeploymentToScaleUp) {
        log.info("service received request about deployment " + kubernetesDeploymentToScaleUp.getDeploymentName() + " to have " +
                kubernetesDeploymentToScaleUp.getPodsToHave() + " pods");
        KubernetesActionExecutor kubernetesActionExecutor = new KubernetesActionExecutor();
        kubernetesActionExecutor.executeOperation(new ScaleUpDeploymentCommand(),
                kubernetesDeploymentToScaleUp.getDeploymentName(), kubernetesDeploymentToScaleUp.getNamespace(),
                kubernetesDeploymentToScaleUp.getPodsToHave());
        return true;
    }
}
