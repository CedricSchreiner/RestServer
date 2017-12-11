package service;

import interfaces.PrimeServiceInterface;

import java.util.ArrayList;
import java.util.List;
import models.Primes;

public class PrimeService implements PrimeServiceInterface {
    @Override
    public String getPrimesAsString(int max) {
        StringBuilder primeResult = new StringBuilder();

        for (long prime : calculatePrimes(max)) {
            primeResult.append(prime).append(", ");
        }

        primeResult.deleteCharAt(primeResult.lastIndexOf(","));
        return primeResult.toString();
    }

    @Override
    public long[] getPrimesAsArray(int max) {
        return calculatePrimes(max).stream().mapToLong(i -> i).toArray();
    }

    @Override
    public Object getPrimeAsObject(int max) {

        Primes primes = new Primes();
        primes.setPrimesAsArray(getPrimesAsArray(max));
        primes.setPrimesAsString(getPrimesAsString(max));
        return primes;
    }

    public List<Long> calculatePrimes(int max) {
        int n; // Variablen fuer aktuellen Primzahlkandidaten und aktuellen Teiler
        List<Long> resultList = new ArrayList<>();

//        for (long i = 2; i <= max; i++) {
//            n = 2;
//
//            // Schleife ueber alle moeglichen Teiler n des Primzahlkandidaten i:
//            while (i % n != 0 && n <= i / 2) {
//                // Erhoehe n solange, wie i nicht nurch n teilbar ist und die
//                // Obergrenze noch nicht erreicht ist
//                n = n + 1;
//            }
//
//            // Falls die Schleife bis zur Obergrenze i/2 durchlaufen wurde:
//            if (n >= i / 2 + 1) {
//                resultList.add(i);
//            }
//            // andernfalls wurde die Schleife vorher abgebrochen, weil i durch n
//            // teilbar war -> keine Primzahl
//        }
        long i = 2;
        int primesFound = 0;
        while (primesFound < max) {
            n = 2;

            // Schleife ueber alle moeglichen Teiler n des Primzahlkandidaten i:
            while (i % n != 0 && n <= i / 2) {
                // Erhoehe n solange, wie i nicht nurch n teilbar ist und die
                // Obergrenze noch nicht erreicht ist
                n = n + 1;
            }

            // Falls die Schleife bis zur Obergrenze i/2 durchlaufen wurde:
            if (n >= i / 2 + 1) {
                primesFound++;
                resultList.add(i);
            }
            // andernfalls wurde die Schleife vorher abgebrochen, weil i durch n
            // teilbar war -> keine Primzahl
            i++;
        }
        return resultList;
    }
}
