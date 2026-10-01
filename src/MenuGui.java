import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGui extends JFrame {
    private JLabel imageLabel;

    public MenuGui() {
        setLayout(new BorderLayout());

        // Main panel with layered pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Set close operation

        // Image label
        imageLabel = new JLabel(new ImageIcon("/Users/celinaarakji/IdeaProjects/Intro/src/Screenshot 2024-06-17 at 10.36.14 PM.png"));
        imageLabel.setBounds(0, 0, 600, 400);  // Adjust size as necessary
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        // Top panel with buttons
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 600, 50);
        topPanel.setOpaque(false);  // Make the panel transparent
        topPanel.setLayout(new BorderLayout());
        JButton button1 = new JButton("Instructions ");
        JButton button2 = new JButton("Play");

        button1.setPreferredSize(new Dimension(200, 100));
        button1.setFont(new Font("Times new roman", Font.BOLD, 20));
        button1.setForeground(Color.ORANGE);

        button2.setPreferredSize(new Dimension(200, 100));
        button2.setFont(new Font("Times new roman", Font.BOLD, 20));
        button2.setForeground(Color.ORANGE);


        topPanel.add(button1, BorderLayout.WEST);
        topPanel.add(button2, BorderLayout.EAST);
        layeredPane.add(topPanel, JLayeredPane.PALETTE_LAYER);

        add(layeredPane, BorderLayout.CENTER);

        setSize(600, 400); // Set the size of the frame
        setLocationRelativeTo(null); // Center the frame on the screen


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instructions l = new Instructions(); //take to instructions
                l.setVisible(true);

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // start game
                Universe uni= new Universe (2,2,2,2,2);
                uni.setVisible(true);

            }
        });
    }


}
