import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FortuneCookieApp extends JFrame {
    private final String[] fortunes = {
            "Cada día es una nueva oportunidad para alcanzar tus sueños.",
            "El éxito no es un destino, es un camino que se recorre con esfuerzo y constancia.",
            "La felicidad se encuentra en las pequeñas cosas de la vida.",
            "La vida es un regalo, disfrútala al máximo cada día.",
            "Nunca es tarde para aprender algo nuevo.",
            "No te rindas nunca, incluso en los momentos más difíciles."
    };

    private final Random random = new Random();
    private final JButton fortuneButton;
    private final JLabel fortuneLabel;

    public FortuneCookieApp() {
        setTitle("Galleta de la fortuna");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        fortuneButton = new JButton("Obtener mensaje");
        fortuneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRandomFortune();
            }
        });

        fortuneLabel = new JLabel("Presiona el botón");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(fortuneButton, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(fortuneLabel, BorderLayout.SOUTH);
    }

    private void displayRandomFortune() {
        int index = random.nextInt(fortunes.length);
        String fortune = fortunes[index];
        fortuneLabel.setText(fortune);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FortuneCookieApp().setVisible(true);
            }
        });
    }
}
