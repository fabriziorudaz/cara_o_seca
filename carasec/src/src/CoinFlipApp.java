package src;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CoinFlipApp extends JFrame {
    private JLabel coinLabel;
    private JButton flipButton;
    private ImageIcon headsIcon;
    private ImageIcon tailsIcon;
    private Random random;

    public CoinFlipApp() {
        // Configurar la ventana
        setTitle("Cara o Seca - Coin Flip");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cargar las imágenes (asegúrate de que estén en la carpeta del proyecto)
        headsIcon = new ImageIcon("src/moneda_cara.png");  // Ruta a la imagen de cara
        tailsIcon = new ImageIcon("src/moneda_cruz.png");  // Ruta a la imagen de seca

        // Etiqueta para mostrar la imagen de la moneda
        coinLabel = new JLabel();
        coinLabel.setHorizontalAlignment(JLabel.CENTER);
        coinLabel.setIcon(headsIcon);  // Empieza mostrando cara
        add(coinLabel, BorderLayout.CENTER);

        // Botón para lanzar la moneda
        flipButton = new JButton("¡Lanzar Moneda!");
        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flipCoin();
            }
        });
        add(flipButton, BorderLayout.SOUTH);

        // Inicializar el generador de números aleatorios
        random = new Random();
    }

    private void flipCoin() {
        // Generar un resultado aleatorio: 0 para cara, 1 para seca
        int result = random.nextInt(2);
        if (result == 0) {
            coinLabel.setIcon(headsIcon);
            JOptionPane.showMessageDialog(this, "¡Cara!");
        } else {
            coinLabel.setIcon(tailsIcon);
            JOptionPane.showMessageDialog(this, "¡Seca!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CoinFlipApp app = new CoinFlipApp();
            app.setVisible(true);
        });
    }
}