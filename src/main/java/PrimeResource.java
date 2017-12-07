import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(PrimeResourceConstants.GET_PRIME_CLASS_PATH)
public class PrimeResource {

    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPrimeAsString(@QueryParam(PrimeResourceConstants.QUERY_PARAM_MAX_PRIME) String maxPrime){
        Prime.calculatePrimeNumbers(Integer.parseInt(maxPrime));
        return maxPrime;
    }
}
