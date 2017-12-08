import org.json.simple.JSONArray;

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
    @Path("/getAsString")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPrimeAsString(@QueryParam(PrimeResourceConstants.QUERY_PARAM_MAX_PRIME) String maxPrime){
        return primeService.getPrimeAsString(Integer.parseInt(maxPrime));
    }

    @GET
    @Path("/getAsArray")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrimeAsArray(@QueryParam(PrimeResourceConstants.QUERY_PARAM_MAX_PRIME) String maxPrime){
        JSONArray jsonArray = new JSONArray();
        List<Integer> primeList = new ArrayList<>();
        for (int prime : primeService.getPrimeAsIntArray(Integer.parseInt(maxPrime))) {
            primeList.add(prime);
        }
        jsonArray.addAll(primeList);

        return Response.ok().entity(jsonArray.toJSONString()).build();
    }

    @GET
    @Path("/getAsObject")
    @Produces(MediaType.TEXT_PLAIN)
    public Object getPrimeAsObject(@QueryParam(PrimeResourceConstants.QUERY_PARAM_MAX_PRIME) String maxPrime){
        return primeService.getPrimeAsObject(Integer.parseInt(maxPrime));
    }
}
