package com.cc.ccp.k8s.healthCheckTest.command;

public interface KubernetesAction {

    void execute(String deploymentName, String namespace);

}
