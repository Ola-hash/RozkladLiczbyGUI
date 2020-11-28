public class RozkladLiczby {

    private int[] tab;

    public RozkladLiczby(int n) throws Exception {
        if (n < 2) throw new Exception("Niepoprawny zakres");
        this.tab = new int[n - 1];
        sitoErastostenesa(n + 1);
    }

    private void sitoErastostenesa(int n) {
        for (int i = 2; i < n; i++) {
            if (tab[i - 2] == 0) {
                for (int j = 2; j * i < n; j++) {
                    if (tab[j * i - 2] == 0) {
                        tab[j * i - 2] = i;
                    }
                }
                tab[i - 2] = i;
            }
        }
    }

    public int[] czynnikiPierwsze(int m) throws Exception {
        if (m > tab.length) {
            throw new Exception(m + " - jest za duża, nie utworzono sita");
        }
        if (m < 2) {
            throw new Exception(m + " - niepoprawna liczba");
        }
        int index = 0;
        int tablica[] = new int[32];
        while (m != 1) {
            int dzielnik = tab[m - 2];
            tablica[index] = dzielnik;
            index++;
            m = m / dzielnik;
        }
        int result[] = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = tablica[i];
        }
        return result;
    }

    public void wypiszLiczby() {
        for (int i = 0; i < tab.length; i++) {
            System.out.println((i + 2) + "- " + tab[i]);
        }
    }

}
