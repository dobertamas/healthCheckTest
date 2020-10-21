package com.cc.ccp.k8s.healthCheckTest.fabric8;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class DeleteDeployment {

    // Based on Example 5 from https://developers.redhat.com/blog/2020/05/20/getting-started-with-the-fabric8-kubernetes-java-client/
    // Locally I could see on the Dashboard that the new Deployment was deleted
    public static void main(String[] args) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            Boolean isDeleted = client.apps().deployments()
                                      .inNamespace("default")
                                      .withName("nginx-deployment")
                                      .delete();

            // It gave me false correctly when there was no 'nginx-deployment'; otherwise I got true
            System.out.println(isDeleted);
        }


    }

}
