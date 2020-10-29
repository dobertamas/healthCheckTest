package com.cc.ccp.k8s.healthCheckTest.fabric8;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScaleDownDeployment {

    public void scaleDownWithNamespace(String deployment, String namespace) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            log.info("namespace: " + namespace);
            log.info("deployment: " + deployment);
            client.apps().deployments().inNamespace(namespace).withName(deployment).scale(0, false);

        }
    }


}
