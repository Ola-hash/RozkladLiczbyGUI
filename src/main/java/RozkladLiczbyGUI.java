import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RozkladLiczbyGUI extends JFrame {
    JLabel lRozmiarSita, lLiczbaPrzedRozkladem, lLiczbaPoRozkladzie, lWyjatek;
    JTextField tRozmiarSita, tLiczbaPrzedRozkladem, tLiczbaPoRozkladzie;
    JButton bPrzeliczSito, bPrzelicz, bWyjscie;
    int n;
    int m;
    RozkladLiczby rozkladLiczby = null;

    public RozkladLiczbyGUI() {
        setSize(550, 350);
        setTitle("Rozklad liczby na czynniki pierwsze");
        setLayout(null);

        lRozmiarSita = new JLabel("Podaj rozmiar sita");
        lRozmiarSita.setBounds(40, 30, 200, 20);
        add(lRozmiarSita);
        tRozmiarSita = new JTextField("");
        tRozmiarSita.setBounds(170, 30, 100, 20);
        add(tRozmiarSita);

        lLiczbaPrzedRozkladem = new JLabel("Podaj liczbe do rozkladu");
        lLiczbaPrzedRozkladem.setBounds(40, 100, 200, 20);
        add(lLiczbaPrzedRozkladem);
        lLiczbaPrzedRozkladem.setVisible(false);
        tLiczbaPrzedRozkladem = new JTextField("");
        tLiczbaPrzedRozkladem.setBounds(190, 100, 100, 20);
        add(tLiczbaPrzedRozkladem);
        tLiczbaPrzedRozkladem.setVisible(false);

        lLiczbaPoRozkladzie = new JLabel("Liczba po rozkladzie");
        lLiczbaPoRozkladzie.setBounds(40, 200, 200, 20);
        add(lLiczbaPoRozkladzie);
        tLiczbaPoRozkladzie = new JTextField("");
        tLiczbaPoRozkladzie.setBounds(180, 200, 100, 20);
        add(tLiczbaPoRozkladzie);

        lWyjatek = new JLabel("");
        lWyjatek.setBounds(130, 150, 200, 20);
        lWyjatek.setForeground(Color.RED);
        add(lWyjatek);

        bPrzeliczSito = new JButton("Przelicz sito");
        bPrzeliczSito.setBounds(290, 30, 130, 20);
        add(bPrzeliczSito);
        bPrzeliczSito.addActionListener(new stworzSitoListener());
        bPrzelicz = new JButton("Rozloz na czynniki");
        bPrzelicz.setBounds(300, 100, 140, 20);
        add(bPrzelicz);
        bPrzelicz.setVisible(false);
        bPrzelicz.addActionListener(new rozlozNaCzynnikiListener());
        bWyjscie = new JButton("Wyjscie");
        bWyjscie.setBounds(300, 200, 100, 20);
        add(bWyjscie);
        setVisibleRozkladLiczby(false);
        bWyjscie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void setVisibleRozkladLiczby(boolean Visible) {
        lLiczbaPrzedRozkladem.setVisible(true);
        tLiczbaPrzedRozkladem.setVisible(true);
        bPrzelicz.setVisible(true);

    }

    class stworzSitoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                n = Integer.parseInt(tRozmiarSita.getText());
                rozkladLiczby = new RozkladLiczby(n);
                setVisibleRozkladLiczby(true);
            } catch (NumberFormatException ex) {
                lWyjatek.setText("To nie jest liczba");
            } catch (Exception ex) {
                lWyjatek.setText(ex.getMessage());
            }
        }
    }

    class rozlozNaCzynnikiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m = Integer.parseInt((tLiczbaPrzedRozkladem.getText()));
                int[] result = rozkladLiczby.czynnikiPierwsze(m);
                tLiczbaPoRozkladzie.setText(RozkladLiczbyUtil.zliczanieWystapien(result));
            } catch (NumberFormatException ex) {
                lWyjatek.setText("To nie jest liczba");
            } catch (Exception ex) {
                lWyjatek.setText(ex.getMessage());

            }
        }

    }
}
