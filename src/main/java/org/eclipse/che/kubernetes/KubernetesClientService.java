package org.eclipse.che.kubernetes;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.che.CheWorkspace;
import org.eclipse.che.CheWorkspaceService;
import org.eclipse.che.model.CheMachines;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;

@Path("/k8s")
public class KubernetesClientService {

    @Inject
    @RestClient
    CheWorkspaceService cheAPIservice;

    @ConfigProperty(name = "CHE_WORKSPACE_ID")
    String workspaceId;

    @ConfigProperty(name = "CHE_MACHINE_TOKEN")
    String machineToken;

    @Context
    UriInfo uri;

    @GET
    public Response redirectToScratch() {
        // redirect to scratch + this uri
        String scratchRoute = getRoute("scratch");

        System.out.println("scratch Route: " + scratchRoute);
        return Response.seeOther(URI.create(scratchRoute + "?k8sServer=" + uri.getRequestUri())).build();
    }

    public String getRoute(final String routeName) {
        CheWorkspace workspace = cheAPIservice.getWorkspace(workspaceId, "Bearer " + machineToken);

        Map<String, CheMachines> machines = workspace.runtime.machines;
        for (Entry<String, CheMachines> mEntry : machines.entrySet()) {
            if (mEntry.getValue().servers != null && mEntry.getValue().servers.containsKey(routeName)) {
                return mEntry.getValue().servers.get(routeName).url;
            }
        }
        throw new RuntimeException("Couldn't find any route in the workspace that is matching " + routeName);
    }

    @Inject
    KubernetesClient kubernetesClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{namespace}")
    public List<Pod> pods(@PathParam("namespace") String namespace) {
        return kubernetesClient.pods().inNamespace(namespace).list().getItems();//.stream()
                //.map(p -> p.getMetadata().getName()).collect(Collectors.toList());
    }
}