import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI extends JFrame {

    public UI() {
        setTitle("Belgium");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        getContentPane().setLayout(new GridLayout(1, 2, 10, 10));//add 10, 10 for padding of the elements

        Color[] colors = {new Color(252, 186, 3), new Color(235, 64, 52),
                new Color(50, 168, 82), new Color(66, 135, 245)};
        getContentPane().add(createLeft(colors));
        getContentPane().add(createSection(Color.yellow));

        // Add padding to the content pane
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10)); // 10 pixels of padding on all sides

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createSection(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);

        //padding
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return panel;
    }

    private JPanel createLeft(Color[] colors){
        JPanel left = new JPanel();
        left.setLayout(new GridLayout(2, 2, 10, 10));

        for(Color color : colors){
            JPanel panel = new JPanel();
            panel.setBackground(color);
            left.add(panel);
        }
        return left;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UI window = new UI();
            window.setVisible(true);
        });
    }
}
