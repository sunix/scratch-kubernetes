package org.eclipse.che.kubernetes;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;

@Path("/k8s")
public class KubernetesClientService {

    @ConfigProperty(name = "CHE_WORKSPACE_ID")
    String workspaceId;

    @ConfigProperty(name = "CHE_MACHINE_TOKEN")
    String machineToken;

    @ConfigProperty(name = "K8S_URL")
    String k8sRoute;

    @ConfigProperty(name = "SCRATCH_URL")
    String scratchRoute;

    @GET
    public Response redirectToScratch() {
        // redirect to scratch + this uri
        return Response.seeOther(URI.create(scratchRoute + "?k8sServer=" + k8sRoute)).build();
    }

    @Inject
    KubernetesClient kubernetesClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{namespace}")
    public List<Pod> pods(@PathParam("namespace") String namespace) {
        return kubernetesClient.pods().inNamespace(namespace).list().getItems();
    }
}