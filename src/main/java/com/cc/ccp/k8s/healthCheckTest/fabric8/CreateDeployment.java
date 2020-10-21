package com.cc.ccp.k8s.healthCheckTest.fabric8;

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateDeployment {

    // Based on Example 3 from https://developers.redhat.com/blog/2020/05/20/getting-started-with-the-fabric8-kubernetes-java-client/
    // Locally I could see on the Dashboard that the new Deployment was added
    public void create(String name) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            log.info("creating deployment");
            Deployment deployment = new DeploymentBuilder()
                    .withNewMetadata()
                    .withName(name + "-deployment")
                    .addToLabels("app", "nginx")
                    .endMetadata()
                    .withNewSpec()
                    .withReplicas(1)
                    .withNewSelector()
                    .addToMatchLabels("app", "nginx")
                    .endSelector()
                    .withNewTemplate()
                    .withNewMetadata()
                    .addToLabels("app", "nginx")
                    .endMetadata()
                    .withNewSpec()
                    .addNewContainer()
                    .withName("nginx")
                    .withImage("nginx:1.7.9")
                    .addNewPort().withContainerPort(80).endPort()
                    .endContainer()
                    .endSpec()
                    .endTemplate()
                    .endSpec()
                    .build();

            client.apps().deployments().inNamespace("default").createOrReplace(deployment);
        }
    }

}
