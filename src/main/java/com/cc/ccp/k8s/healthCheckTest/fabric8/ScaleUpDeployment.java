package com.cc.ccp.k8s.healthCheckTest.fabric8;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScaleUpDeployment {

    public void scaleUpDeployment(String deployment, String namespace, Integer podsToHave) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            log.info("namespace: " + namespace);
            log.info("deployment: " + deployment);
            log.info("podsToHave: " + podsToHave);
            client.apps().deployments().inNamespace(namespace).withName(deployment).scale(podsToHave, false);

        }
    }
}
