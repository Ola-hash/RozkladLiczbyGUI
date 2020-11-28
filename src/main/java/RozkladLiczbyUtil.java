public class RozkladLiczbyUtil {

    public static String zliczanieWystapien(int[] tab) {
        StringBuilder wynik = new StringBuilder("");
        for (int i = 0; i < tab.length; i++) {
            int licznik = 1;
            int j = i + 1;
            while (j < tab.length && tab[i] == tab[j]) {
                licznik++;
                j++;
            }
            i = j - 1;
            if (licznik > 1) {
                wynik.append(tab[i]).append("^").append(licznik);
            } else {
                wynik.append(tab[i]);
            }
            if (i != tab.length - 1) {
                wynik.append("*");
            }
        }
        return wynik.toString();
    }

}