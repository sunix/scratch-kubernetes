package org.eclipse.che;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/workspace")
@RegisterRestClient
//@ClientHeaderParam(name = "Authorization", value = CheWorkspaceService.auth)
public interface CheWorkspaceService {

    @GET
    @Path("/{workspaceId}")
    @Produces("application/json")
    CheWorkspace getWorkspace(@PathParam("workspaceId") String workspaceId, @HeaderParam("Authorization") String authHeaderValue);

}
