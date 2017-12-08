public class PrimeService implements PrimeServiceInterface{
    @Override
    public String getPrimeAsString(int max) {
        StringBuilder primeResult = new StringBuilder();

        for (int prime : Prime.calculatePrimeNumbers(max)) {
            primeResult.append(prime).append(", ");
        }

        primeResult.indexOf(",");
        return primeResult.toString();
    }

    @Override
    public int[] getPrimeAsIntArray(int max) {
        return Prime.calculatePrimeNumbers(max).stream().mapToInt(i -> i).toArray();
    }

    @Override
    public Object getPrimeAsObject(int max) {
        return null;
    }
}
