import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class Note extends JFrame{
    private JButton button1;
    private JButton saveButton;
    private JPanel NotePanel;
    private JButton button2;
    private JButton deleteButton;
    private javax.swing.JTextArea JTextArea;
    private JButton updateButton;

    public Note(String content) throws SQLException {
        nNote nnote = new nNote();
        this.setContentPane(this.NotePanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if(!Objects.equals(content, ""))
        {
            JTextArea.setText(content);
            nnote.content = content;
            nnote.user_id = User.getUser_id();
            nnote.notes_id = nnote.getNote_id();
        }
        button1.addActionListener(new ActionListener() {
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
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = JTextArea.getText();
                addToDatabase(content);
                nnote.content=content;
                try {
                    nnote.user_id=User.getUser_id();
                    nnote.notes_id = nnote.getNote_id();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFromDatabase(nnote);
                dispose();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = JTextArea.getText();
                updateDatabase(content, nnote.notes_id);
            }
        });
    }
    private void updateDatabase(String content, int id)
    {
        try {
            Connection conn = Database.getCon();
            Statement stmt = conn.createStatement();
            String sql = "UPDATE Notes SET content = ? WHERE notes_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,content);
            preparedStatement.setInt(2,id);
            int x = preparedStatement.executeUpdate();
            if (x>0)
            {
                nNote note = new nNote();
                note.content = content;
                note.user_id = User.getUser_id();
                note.notes_id = note.getNote_id();
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void addToDatabase(String content)
    {

        try {
            Connection conn = Database.getCon();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Notes (content,user_id) VALUES (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,content);
            preparedStatement.setInt(2,User.getUser_id());
            int x = preparedStatement.executeUpdate();
            if (x>0)
            {
                nNote note = new nNote();
                note.content = content;
                note.user_id = User.getUser_id();
                note.notes_id = note.getNote_id();
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void deleteFromDatabase(nNote nnote)
    {
        try {
            Connection conn = Database.getCon();
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Notes WHERE notes_id= ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,nnote.notes_id);
            preparedStatement.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
