package com.cc.ccp.k8s.healthCheckTest.command;

import com.cc.ccp.k8s.healthCheckTest.fabric8.ScaleDownDeployment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScaleDownDeploymentCommand implements KubernetesAction {
    @Override
    public void execute(String deploymentName, String namespace) {
        // Scaling deployment down to have zero pod
        log.info("scaling down deployment: " + deploymentName);
        ScaleDownDeployment scaleDownDeployment = new ScaleDownDeployment();
        scaleDownDeployment.scaleDownWithNamespace(deploymentName, namespace);

    }
}
