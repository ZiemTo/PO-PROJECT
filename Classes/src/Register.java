import javax.swing.*;

public class Register extends JFrame {
    private JPasswordField confirmPasswordField;
    private JTextField loginField;
    private JButton clearButton;
    private JButton registerButton;
    private JLabel errorLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPanel JPanelRegister;

    public static void main(String[] args) {
        Register registerPanel = new Register();
        registerPanel.setVisible(true);
        registerPanel.setSize(500,600);
    }
    public Register()
    {
        super("Welcome to MyNotes - Register");
        this.setContentPane(this.JPanelRegister);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
