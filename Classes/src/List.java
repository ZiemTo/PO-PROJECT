import javax.swing.*;

public class List extends JFrame{
    private JPanel ListPanel;
    private JButton button1;

    public static void main(String[] args) {
        List list = new List();
        list.setVisible(true);
        list.setSize(600,800);
    }
    public List()
    {
        this.setContentPane(this.ListPanel);
    }
}
