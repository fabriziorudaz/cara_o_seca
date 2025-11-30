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
    private JRadioButton caraButton;
    private JRadioButton secaButton;
    private ButtonGroup choiceGroup;

    public CoinFlipApp() {
        // Configurar la ventana
        setTitle("Cara o Seca - Coin Flip");
        setSize(300, 450);  // Aumenté la altura para acomodar los nuevos elementos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cargar las imágenes (asegúrate de que estén en la carpeta del proyecto)
        headsIcon = new ImageIcon("src/moneda_cara.png");  // Ruta a la imagen de cara
        tailsIcon = new ImageIcon("src/moneda_cruz.png");  // Ruta a la imagen de seca

        // Panel para la selección de cara o seca
        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new FlowLayout());
        caraButton = new JRadioButton("Cara");
        secaButton = new JRadioButton("Seca");
        choiceGroup = new ButtonGroup();
        choiceGroup.add(caraButton);
        choiceGroup.add(secaButton);
        choicePanel.add(new JLabel("Elige:"));
        choicePanel.add(caraButton);
        choicePanel.add(secaButton);
        add(choicePanel, BorderLayout.NORTH);

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
        // Verificar si el usuario ha seleccionado una opción
        if (!caraButton.isSelected() && !secaButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Por favor, elige Cara o Seca antes de lanzar.");
            return;
        }

        // Obtener la elección del usuario
        boolean userChoseCara = caraButton.isSelected();

        // Generar un resultado aleatorio: 0 para cara, 1 para seca
        int result = random.nextInt(2);
        boolean isCara = (result == 0);

        // Actualizar la imagen
        if (isCara) {
            coinLabel.setIcon(headsIcon);
        } else {
            coinLabel.setIcon(tailsIcon);
        }

        // Determinar si ganó o perdió
        String resultText = isCara ? "Cara" : "Seca";
        String verdict;
        if ((userChoseCara && isCara) || (!userChoseCara && !isCara)) {
            verdict = "¡Ganaste!";
        } else {
            verdict = "¡Perdiste!";
        }

        // Mostrar mensaje con resultado y veredicto
        JOptionPane.showMessageDialog(this, "Resultado: " + resultText + "\n" + verdict);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CoinFlipApp app = new CoinFlipApp();
            app.setVisible(true);
        });
    }
}
