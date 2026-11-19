import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Top-level container: JFrame.
 * Memakai BorderLayout (judul di NORTH, form di CENTER).
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Latihan GUI - Penjumlahan");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Penjumlahan Dua Angka", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(20f));
        add(title, BorderLayout.NORTH);

        add(new FormPanel(), BorderLayout.CENTER);
    }
}
