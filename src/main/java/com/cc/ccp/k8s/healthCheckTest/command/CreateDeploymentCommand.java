package com.cc.ccp.k8s.healthCheckTest.command;

import com.cc.ccp.k8s.healthCheckTest.fabric8.CreateDeployment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateDeploymentCommand implements KubernetesAction {

    @Override
    public void execute(String deploymentName, String namespace) {
        // Look up the actual location of the service; probably from some mapping file
        // Name will be the action we need to perform like createDeployment.
        // Possible actions can be stored in enum.
        CreateDeployment createDeployment = new CreateDeployment();
        log.info("creating deployment with the name " + deploymentName);
        createDeployment.create(deploymentName,namespace);
    }
}
