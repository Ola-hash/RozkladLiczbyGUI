import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RozkladLiczbyGUI extends JFrame implements ActionListener {
    JLabel lRozmiarSita, lLiczbaPrzedRozkladem, lLiczbaPoRozkladzie, lWyjatek;
    JTextField tRozmiarSita, tLiczbaPrzedRozkladem, tLiczbaPoRozkladzie;
    JButton bPrzelicz, bWyjscie;
    int n;
    int m;

    public RozkladLiczbyGUI() {
        setSize(400, 300);
        setTitle("Rozklad liczby na czynniki pierwsze");
        setLayout(null);

        lRozmiarSita = new JLabel("Podaj rozmiar sita");
        lRozmiarSita.setBounds(40, 40, 200, 20);
        add(lRozmiarSita);
        tRozmiarSita = new JTextField("");
        tRozmiarSita.setBounds(170, 40, 100, 20);
        add(tRozmiarSita);

        lLiczbaPrzedRozkladem = new JLabel("Podaj liczbe");
        lLiczbaPrzedRozkladem.setBounds(40, 80, 200, 20);
        add(lLiczbaPrzedRozkladem);
        tLiczbaPrzedRozkladem = new JTextField("");
        tLiczbaPrzedRozkladem.setBounds(170, 80, 100, 20);
        add(tLiczbaPrzedRozkladem);

        lLiczbaPoRozkladzie = new JLabel("Liczba po rozkaldzie");
        lLiczbaPoRozkladzie.setBounds(40, 190, 200, 20);
        add(lLiczbaPoRozkladzie);
        tLiczbaPoRozkladzie = new JTextField("");
        tLiczbaPoRozkladzie.setBounds(180, 190, 100, 20);
        add(tLiczbaPoRozkladzie);

        lWyjatek = new JLabel("");
        lWyjatek.setBounds(115, 150, 200, 20);
        lWyjatek.setForeground(Color.RED);
        add(lWyjatek);

        bPrzelicz = new JButton("Przelicz");
        bPrzelicz.setBounds(130, 120, 100, 20);
        add(bPrzelicz);
        bPrzelicz.addActionListener(this);
        bWyjscie = new JButton("Wyjscie");
        bWyjscie.setBounds(270, 230, 100, 20);
        add(bWyjscie);
        bWyjscie.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();

        try {
            if (zrodlo == bPrzelicz) {
                n = Integer.parseInt(tRozmiarSita.getText());
                RozkladLiczby rozkladLiczby = new RozkladLiczby(n);
                m = Integer.parseInt((tLiczbaPrzedRozkladem.getText()));
                int[] result = rozkladLiczby.czynnikiPierwsze(m);
                tLiczbaPoRozkladzie.setText(RozkladLiczbyUtil.zliczanieWystapien(result));
            } else {
                dispose();
            }
        } catch (NumberFormatException ex) {
            lWyjatek.setText("To nie jest liczba");
        } catch (Exception ex) {
            lWyjatek.setText(ex.getMessage());

        }
    }

}
