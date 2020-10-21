package com.cc.ccp.k8s.healthCheckTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KubernetesObjectToDisable {

    private final String name;

    public KubernetesObjectToDisable(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
