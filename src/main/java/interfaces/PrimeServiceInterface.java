package interfaces;

import java.util.List;

public interface PrimeServiceInterface {
    String getPrimesAsString(int max);

    long[] gerPrimesAsArray(int max);

    Object getPrimeAsObject(int max);

    List<Long> calculatePrimes(int max);
}
