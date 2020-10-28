package com.cc.ccp.k8s.healthCheckTest.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KubernetesActionExecutor {

    public void executeOperation(KubernetesAction kubernetesAction, String deploymentName, String namespace) {
        log.info("executing kubernetesAction ");
        kubernetesAction.execute(deploymentName, namespace);
    }

    public void executeOperation(KubernetesAction kubernetesAction, String deploymentName, String namespace, Integer podsToHave) {
        log.info("executing kubernetesAction ");
        kubernetesAction.execute(deploymentName, namespace, podsToHave);
    }

}
