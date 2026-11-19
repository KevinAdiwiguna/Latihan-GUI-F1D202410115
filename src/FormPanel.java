import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Intermediate container: JPanel.
 * Juga menjadi event listener dengan implements ActionListener.
 *
 * Layout yang dipakai:
 * - BorderLayout : menyusun input, tombol, dan hasil
 * - GridLayout   : menyusun label dan text field
 * - FlowLayout   : menyusun tombol dan label hasil
 */
public class FormPanel extends JPanel implements ActionListener {

    private final JTextField angka1 = new JTextField();
    private final JTextField angka2 = new JTextField();
    private final JLabel hasil = new JLabel("Hasil: -");
    private final JButton tombol = new JButton("Hitung");

    public FormPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // GridLayout: 2 baris, 2 kolom (label + text field).
        JPanel input = new JPanel(new GridLayout(2, 2, 8, 8));
        input.add(new JLabel("Angka 1:"));
        input.add(angka1);
        input.add(new JLabel("Angka 2:"));
        input.add(angka2);
        add(input, BorderLayout.NORTH);

        // FlowLayout: tombol dan hasil berderet ke samping.
        JPanel bawah = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        tombol.addActionListener(this);
        hasil.setFont(hasil.getFont().deriveFont(16f));
        bawah.add(tombol);
        bawah.add(hasil);
        add(bawah, BorderLayout.CENTER);
    }

    // Event listener: override method dari interface ActionListener.
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            int a = Integer.parseInt(angka1.getText().trim());
            int b = Integer.parseInt(angka2.getText().trim());
            hasil.setText("Hasil: " + (a + b));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
