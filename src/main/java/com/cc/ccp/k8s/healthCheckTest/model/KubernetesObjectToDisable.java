package com.cc.ccp.k8s.healthCheckTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KubernetesObjectToDisable {

    private final String deploymentName;
    private final String namespace;

    public KubernetesObjectToDisable(@JsonProperty("deploymentName") String deploymentName, @JsonProperty("namespace") String namespace) {
        this.deploymentName = deploymentName;
        this.namespace = namespace;
    }

    public String getDeploymentName() {
        return deploymentName;
    }

    public String getNamespace() {
        return namespace;
    }

}
