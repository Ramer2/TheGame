import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI extends JFrame {

    public UI() {
        setTitle("Belgium");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        getContentPane().setBackground(Color.DARK_GRAY);

        // Set BorderLayout for the content pane
        getContentPane().setLayout(new BorderLayout());

        JPanel leftPanel = createLeftPanel(2500);
        JPanel rightPanel = createRightPanel(Color.gray);

        // Add the left panel to the center of the content pane with appropriate weight
        getContentPane().add(leftPanel, BorderLayout.CENTER);

        // Add the right panel to the east side of the content pane with appropriate weight
        getContentPane().add(rightPanel, BorderLayout.LINE_END);

        // Add padding to the content pane
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10)); // 10 pixels of padding on all sides

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createRightPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);

        // Set preferred width to roughly 25% of the total width
        panel.setPreferredSize(new Dimension(getPreferredSize().width / 4, 0));

        // Padding
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return panel;
    }

    private JPanel createLeftPanel(int num) {
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        int size = (int) Math.sqrt(num);
        leftPanel.setLayout(new GridLayout(size, size, 1, 1));
        leftPanel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < num; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.gray);
            leftPanel.add(panel);
        }
        return leftPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UI window = new UI();
            window.setVisible(true);
        });
    }
}
