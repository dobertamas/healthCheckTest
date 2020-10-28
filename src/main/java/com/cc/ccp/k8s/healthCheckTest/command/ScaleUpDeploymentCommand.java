package com.cc.ccp.k8s.healthCheckTest.command;

import com.cc.ccp.k8s.healthCheckTest.fabric8.ScaleUpDeployment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScaleUpDeploymentCommand implements KubernetesAction {
    @Override
    public void execute(String deploymentName, String namespace) {
        // currently an empty implementation
    }

    @Override
    public void execute(String deploymentName, String namespace, Integer podsToHave) {
        // Scaling deployment up to have the specified number of pods
        log.info("scaling up deployment: " + deploymentName + " to have " + podsToHave + " pods");
        ScaleUpDeployment scaleUpDeployment = new ScaleUpDeployment();
        scaleUpDeployment.scaleUpDeployment(deploymentName, namespace, podsToHave);

    }

}
