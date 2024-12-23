package ex.labseq;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.math.BigInteger;

@Path("/labseq")
public class LabseqResource {

    @Inject
    LabseqService labseqService;

    @GET
    @Path("/{inputValue}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Return the index of the sequence's value")
    public String getValue(@PathParam("inputValue") String n) {
        BigInteger result = labseqService.getValueIterative(Integer.parseInt(n));

        if (result.equals(BigInteger.valueOf(-1))) {
            return "Input value must be a non-negative integer.";
        }
        return String.valueOf(labseqService.getValueIterative(Integer.parseInt(n)));
    }
}
