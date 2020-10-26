package com.cc.ccp.k8s.healthCheckTest.fabric8;

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ListDeployments {

    public static void main(String[] args) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            final DeploymentList list = client.apps().deployments().list();
            log.info(list.getApiVersion());
            final List<Deployment> deployments = list.getItems();
            for (Deployment deployment : deployments){
                log.info(deployment.getKind());
                log.info(deployment.getMetadata().getName());
                log.info("replicas: " + deployment.getSpec().getReplicas());
            }

            for(Deployment deployment : deployments ){
                String deploymentName = "core-deployment";
                if ( deployment.getMetadata().getName().equals(deploymentName)){
                    deployment.getSpec().setReplicas(1);
                }
            }

        }

    }
}
