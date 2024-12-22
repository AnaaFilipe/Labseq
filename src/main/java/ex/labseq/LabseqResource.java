package ex.labseq;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/labseq")
public class LabseqResource {

    @Inject
    LabseqService labseqService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Return the index of the sequence's value")
    public String getValue(@PathParam("id") int n) {
        if(n >= 0) {
            return "n = " + n + " => l(" + n + ") = ".concat(String.valueOf(labseqService.getValueIterative(n)));
        }
        else {
            return "Error: The index must be any non-negative integer number";
        }
    }
}
