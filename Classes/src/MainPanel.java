import javax.swing.*;

public class MainPanel extends JFrame{
    private JButton logOutButton;
    private JButton listButton;
    private JButton noteButton;
    private JButton showAllButton;
    private JPanel MainPanel;

    public static void main(String[] args) {
        MainPanel dashboard = new MainPanel();
        dashboard.setVisible(true);
        dashboard.setSize(800,600);
    }
    public MainPanel()
    {
        super("MyNotes - dashboard");
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
