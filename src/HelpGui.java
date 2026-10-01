import javax.swing.*;
import javax.swing.ImageIcon;

public class HelpGui {
    HelpGui(){

        JFrame f = new JFrame();
        ImageIcon ikon= new ImageIcon("/Users/celinaarakji/IdeaProjects/untitled18/src/help.png");
        f.add(new JLabel(ikon));
        f.pack();
        f.setVisible(true);


    }
}
