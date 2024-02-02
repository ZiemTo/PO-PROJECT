import javax.swing.*;

public class Note extends JFrame{
    private JButton button1;
    private JButton saveButton;
    private JPanel NotePanel;
    private JButton button2;

    public static void main(String[] args) {
        Note note = new Note();
        note.setVisible(true);
        note.setSize(400,800);
    }
    public Note()
    {
        this.setContentPane(this.NotePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
