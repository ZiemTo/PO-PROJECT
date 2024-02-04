import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainPanel extends JFrame{
    private JButton logOutButton;
    public JButton listButton;
    private JButton noteButton;
    private JButton showAllButton;
    private JPanel MainPanel;
    private JButton importFromFileButton;
    private JButton exportToFileButton;

    public MainPanel()
    {
        super("DashboardForm");
        setContentPane(MainPanel);
        int width = 800, height = 600;
        setMinimumSize(new Dimension(width,height));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        noteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Note note = null;
                try {
                    note = new Note("");

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                note.setVisible(true);
                note.setSize(400,800);

            }
        });
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            List list = new List();
            list.setVisible(true);
            list.setSize(400,800);
            }
        });
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                final String DB_URL = "jdbc:postgresql://horton.db.elephantsql.com:5432/enuldsvo";
                final String USERNAME = "enuldsvo";
                final String PASSWORD = "P8Ni8mGMIJDPI3Xh7f67u-XKLV7bvN30";
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    Statement stmt = conn.createStatement();
                    int user_id = User.getUser_id();
                    String sql = "SELECT * from Notes WHERE user_id = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1,user_id);
                    ResultSet y = preparedStatement.executeQuery();
                    while (y.next()) {
                        Note note = new Note(y.getString("content"));
                        note.setVisible(true);
                        note.setSize(400,800);
                    }
                    stmt.close();
                    conn.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }
}
