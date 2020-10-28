package com.cc.ccp.k8s.healthCheckTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KubernetesDeploymentToScaleUp {

    private final String deploymentName;
    private final String namespace;
    private final Integer podsToHave;

    public KubernetesDeploymentToScaleUp(@JsonProperty("deploymentName") String deploymentName,
                                         @JsonProperty("namespace") String namespace,
                                         @JsonProperty("podsToHave") Integer podsToHave) {
        this.deploymentName = deploymentName;
        this.namespace = namespace;
        this.podsToHave = podsToHave;
    }

    public String getDeploymentName() {
        return deploymentName;
    }

    public String getNamespace() {
        return namespace;
    }

    public Integer getPodsToHave() {
        return podsToHave;
    }
}
