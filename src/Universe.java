import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Universe extends JFrame{

    public Universe(){
        this(2,2,2,2,2);
    }

     public Universe(int p2, int p3, int p4, int p5, int p6){
         //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(600, 400);
         setLayout(new GridLayout(1, 2, 20, 20));
         setLocationRelativeTo(null); // Center the frame on the screen
         getContentPane().setBackground(Color.WHITE);

         // Create panels
         JPanel leftPanel = new JPanel();
         JPanel rightPanel = new JPanel();

         leftPanel.setLayout(new GridLayout(3, 1, 10, 10));
         rightPanel.setLayout(new GridLayout(3, 1, 10, 10));
         leftPanel.setBackground(Color.WHITE);
         rightPanel.setBackground(Color.WHITE);

         // Add buttons with images to the left panel
         addButtonWithImage(leftPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet1un.png", new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //activate first game when planet 1 is clicked
                 dispose();
                 Planet1Gui game1= new Planet1Gui();
                 game1.setVisible(true);
             }
         });


         // if planet 2 is unlocked have the unlcok image if not then have locked
         if (p2==1){
             addButtonWithImage(leftPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet2un.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 2 unlocked
                     dispose();
                     Planet2Gui game2= new Planet2Gui();
                     game2.setVisible(true);
                 }
             });

         }
         else{
             addButtonWithImage(leftPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet2lock.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 2 button locked
                     JOptionPane.showMessageDialog(null, "This planet is locked right now! Complete previous planet to Unlock.", "", JOptionPane.INFORMATION_MESSAGE);
                 }
             });
         }


         // if planet 3 is unlocked have the unlock image if not then have locked
         if (p3==1){
             addButtonWithImage(leftPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet3un.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet3 unlocked when pressed
                     dispose();
                     Planet3Gui game3= new Planet3Gui();
                     game3.setVisible(true);
                 }
             });

         }
         else{
             addButtonWithImage(leftPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet3lock.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 3 locked when pressed
                     JOptionPane.showMessageDialog(null, "This planet is locked right now! Complete previous planets to Unlock.", "", JOptionPane.INFORMATION_MESSAGE);
                 }
             });
         }



         // right panel
         // if planet 4 is unlocked have the unlcok image if not then have locked
         if (p4==1){
             addButtonWithImage(rightPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet4un.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 4 unlocked
                     dispose();
                     Planet4Gui game4= new Planet4Gui();
                     game4.setVisible(true);
                 }
             });

         }
         else{
             addButtonWithImage(rightPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet4lock.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 4 locked
                     JOptionPane.showMessageDialog(null, "This planet is locked right now! Complete previous planets to Unlock.", "", JOptionPane.INFORMATION_MESSAGE);
                 }
             });
         }

         // if planet 5 is unlocked have the unlcok image if not then have locked
         if (p5==1){
             addButtonWithImage(rightPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet5un.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 5 unlocked
                     dispose();
                     Planet5Gui game5= new Planet5Gui();
                     game5.setVisible(true);
                 }
             });

         }
         else{
             addButtonWithImage(rightPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet5lock.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 5 locked
                     JOptionPane.showMessageDialog(null, "This planet is locked right now! Complete previous planets to Unlock.", "", JOptionPane.INFORMATION_MESSAGE);
                 }
             });
         }


         // if planet 6 is unlocked have the unlcok image if not then have locked
         if (p6==1){
             addButtonWithImage(rightPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet6un.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 1 button
                     dispose();
                     Planet6Gui game6= new Planet6Gui();
                     game6.setVisible(true);
                 }
             });

         }
         else{
             addButtonWithImage(rightPanel, "/Users/celinaarakji/IdeaProjects/Summative./src/planet6lock.png", new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Code for Planet 6 locked
                     JOptionPane.showMessageDialog(null, "This planet is locked right now! Complete previous planets to Unlock.", "", JOptionPane.INFORMATION_MESSAGE);
                 }
             });
         }

         // Add panels to the frame
         add(leftPanel);
         add(rightPanel);




     }
    private static void addButtonWithImage(JPanel panel, String imagePath, ActionListener listener) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            JButton button = new JButton(icon);
            button.setPreferredSize(new Dimension(100, 100)); // Set preferred size of the button
            button.addActionListener(listener); // Add the action listener to the button
            panel.add(button);
        } catch (Exception e) {
            System.err.println("Could not load image: " + imagePath);
            e.printStackTrace();
        }
    }
}
