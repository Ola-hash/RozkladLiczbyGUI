import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RozkladLiczbyGUI extends JFrame  {
    JLabel lRozmiarSita, lLiczbaPrzedRozkladem, lLiczbaPoRozkladzie, lWyjatek;
    JTextField tRozmiarSita, tLiczbaPrzedRozkladem, tLiczbaPoRozkladzie;
    JButton bPrzeliczSito, bPrzelicz, bWyjscie;
    int n;
    int m;
    RozkladLiczby rozkladLiczby = null;

    public RozkladLiczbyGUI() {
        setSize(400, 300);
        setTitle("Rozklad liczby na czynniki pierwsze");
        setLayout(null);

        lRozmiarSita = new JLabel("Podaj rozmiar sita");
        lRozmiarSita.setBounds(40, 30, 200, 20);
        add(lRozmiarSita);
        tRozmiarSita = new JTextField("");
        tRozmiarSita.setBounds(170, 30, 100, 20);
        add(tRozmiarSita);

        lLiczbaPrzedRozkladem = new JLabel("Podaj liczbe do rozkladu");
        lLiczbaPrzedRozkladem.setBounds(40, 110, 200, 20);
        add(lLiczbaPrzedRozkladem);
        lLiczbaPrzedRozkladem.setVisible(false);
        tLiczbaPrzedRozkladem = new JTextField("");
        tLiczbaPrzedRozkladem.setBounds(190, 110, 100, 20);
        add(tLiczbaPrzedRozkladem);
        tLiczbaPrzedRozkladem.setVisible(false);

        lLiczbaPoRozkladzie = new JLabel("Liczba po rozkaldzie");
        lLiczbaPoRozkladzie.setBounds(40, 200, 200, 20);
        add(lLiczbaPoRozkladzie);
        tLiczbaPoRozkladzie = new JTextField("");
        tLiczbaPoRozkladzie.setBounds(180, 200, 100, 20);
        add(tLiczbaPoRozkladzie);

        lWyjatek = new JLabel("");
        lWyjatek.setBounds(115, 170, 200, 20);
        lWyjatek.setForeground(Color.RED);
        add(lWyjatek);

        bPrzeliczSito = new JButton("Przelicz sito");
        bPrzeliczSito.setBounds(100, 70, 140, 20);
        add(bPrzeliczSito);
        bPrzeliczSito.addActionListener(new stworzSitoListener());
        bPrzelicz = new JButton("Przelicz");
        bPrzelicz.setBounds(120, 140, 100, 20);
        add(bPrzelicz);
        bPrzelicz.setVisible(false);
        bPrzelicz.addActionListener(new rozlozNaCzynnikiLisner());
        bWyjscie = new JButton("Wyjscie");
        bWyjscie.setBounds(270, 230, 100, 20);
        add(bWyjscie);
        bWyjscie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
    }

    public void setVisible(boolean Visible) {
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
                setVisible(true);
            } catch (NumberFormatException ex) {
                lWyjatek.setText("To nie jest liczba");
            } catch (Exception ex) {
                lWyjatek.setText(ex.getMessage());
            }

        }
    }

    class rozlozNaCzynnikiLisner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m = Integer.parseInt((tLiczbaPrzedRozkladem.getText()));
                int[] result = rozkladLiczby.czynnikiPierwsze(m);
                tLiczbaPoRozkladzie.setText(RozkladLiczbyUtil.zliczanieWystapien(result));
            } catch (
                    NumberFormatException ex) {
                lWyjatek.setText("To nie jest liczba");
            } catch (Exception ex) {
                lWyjatek.setText(ex.getMessage());

            }
        }

    }
}
