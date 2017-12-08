package rest;

import Constants.PrimeResourceConstants;
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
import java.util.ArrayList;
import java.util.List;

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
        JSONArray jsonArray = new JSONArray();
        List<Long> primeList = new ArrayList<>();
        for (long prime : primeService.gerPrimesAsArray(Integer.parseInt(maxPrime))) {
            primeList.add(prime);
        }
        jsonArray.addAll(primeList);

        return Response.ok().entity(jsonArray.toJSONString()).build();
    }

    @GET
    @Path(PrimeResourceConstants.GET_PRIME_AS_OBJECT_PATH)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getPrimeAsObject(@QueryParam(PrimeResourceConstants.QUERY_PARAM_MAX_PRIME) String maxPrime){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(PrimeResourceConstants.OBJECT_KEY, primeService.getPrimeAsObject(Integer.parseInt(maxPrime)));
        return Response.ok().entity(jsonObject.toJSONString()).build();
    }
}