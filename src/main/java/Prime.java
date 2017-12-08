import java.util.ArrayList;
import java.util.List;

public class Prime {

    public static List<Integer> calculatePrimeNumbers(int max) {
        int n; // Variablen fuer aktuellen Primzahlkandidaten und aktuellen Teiler
        List<Integer> resultList = new ArrayList<>();

        for (int i = 2; i <= max; i++) {
            n = 2;

            // Schleife ueber alle moeglichen Teiler n des Primzahlkandidaten i:
            while (i % n != 0 && n <= i / 2) {
                // Erhoehe n solange, wie i nicht nurch n teilbar ist und die
                // Obergrenze noch nicht erreicht ist
                n = n + 1;
            }

            // Falls die Schleife bis zur Obergrenze i/2 durchlaufen wurde:
            if (n >= i / 2 + 1 && i != 1) {
                System.out.println(i + " ist eine Primzahl.");
                resultList.add(i);
            }
            // andernfalls wurde die Schleife vorher abgebrochen, weil i durch n
            // teilbar war -> keine Primzahl
        }
        return resultList;
    }
}
