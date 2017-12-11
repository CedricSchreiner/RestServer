package rest;

import Constants.PrimeResourceConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.impl.orbutil.ObjectWriter;
import interfaces.PrimeServiceInterface;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.PrimeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(PrimeResourceConstants.GET_PRIME_CLASS_PATH)
public class PrimeResource {

    private PrimeServiceInterface primeService = new PrimeService();

    @GET
    @Path(PrimeResourceConstants.GET_PRIME_AS_STRING_PATH)
    @Produces(MediaType.TEXT_PLAIN)
    public String getPrimeAsString(@QueryParam(PrimeResourceConstants.QUERY_PARAM_MAX_PRIME) String maxPrime){
        return primeService.getPrimesAsString(Integer.parseInt(maxPrime));
    }

    @GET
    @Path(PrimeResourceConstants.GET_PRIME_AS_ARRAY_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrimeAsArray(@QueryParam(PrimeResourceConstants.QUERY_PARAM_MAX_PRIME) String maxPrime){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(primeService.getPrimesAsArray(Integer.parseInt(maxPrime)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.accepted().entity(jsonString).build();
    }

    @GET
    @Path(PrimeResourceConstants.GET_PRIME_AS_OBJECT_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrimeAsObject(@QueryParam(PrimeResourceConstants.QUERY_PARAM_MAX_PRIME) String maxPrime){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(primeService.getPrimeAsObject(Integer.parseInt(maxPrime)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.accepted().entity(jsonString).build();
    }
}
