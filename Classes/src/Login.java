import javax.swing.*;

public class Login extends JFrame{
    private JPasswordField passwordField;
    private JTextField loginField;
    private JButton clearButton;
    private JButton registerButton;
    private JButton logInButton;
    private JLabel errorLabel;
    private JPanel JPanelLogin;

    public static void main(String[] args) {
        Login loginPanel = new Login();
        loginPanel.setVisible(true);
        loginPanel.setSize(500,600);
    }
    public Login()
    {
        super("Welcome to MyNotes - Log in");
        this.setContentPane(this.JPanelLogin);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
