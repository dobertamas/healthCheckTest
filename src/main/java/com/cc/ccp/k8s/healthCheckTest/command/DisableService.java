package com.cc.ccp.k8s.healthCheckTest.command;

import com.cc.ccp.k8s.healthCheckTest.fabric8.CreateDeployment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisableService implements KubernetesAction {

    @Override
    public void execute(String name, String location) {
        // Look up the actual location of the service; probably from some mapping file
        // Name can be the action we need to perform like createDeployment.
        // Possible actions will be stored in enum.
        CreateDeployment createDeployment = new CreateDeployment();
        createDeployment.create(name);
    }
}
