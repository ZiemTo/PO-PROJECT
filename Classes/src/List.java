import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class List extends JFrame {
    private JPanel ListPanel;
    private JButton button1;

    public List() {
        this.setContentPane(this.ListPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}


