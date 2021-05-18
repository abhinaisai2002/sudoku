import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Frame extends JFrame implements ActionListener{
    JLabel label,label2;
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JButton button = new JButton();
    JTextField[][] textFields = new JTextField[9][9];
    Frame(){
        label = new JLabel();
        label.setFont(new Font("Ink Free", Font.BOLD, 75));
        label.setText("SUDOKU");
        label.setBackground(new Color(25, 25, 25));
        label.setForeground(new Color(25,255,0));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.add(label);

        panel2.setBackground(Color.red);
        panel2.setLayout(new GridLayout(9,9,5,5));

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                textFields[i][j] = new JTextField();
                textFields[i][j].setFont(new Font("MV Boli",Font.BOLD,35));
                panel2.add(textFields[i][j]);
            }
        }

        button.setSize(new Dimension(100,50));
        button.setBackground(Color.red);
        button.setFocusable(false);
        button.setFont(new Font("Ink Free", Font.BOLD, 20));
        button.setText("GET ANSWER");
        button.addActionListener(this);
        panel3.add(button);
        panel3.setBackground(Color.black);

        this.add(panel,BorderLayout.NORTH);
        this.add(panel2);
        this.add(panel3,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(textFields[i][j].getText().equals(""))
                        Sudoku.board[i][j]=0;
                    else
                        Sudoku.board[i][j] = Integer.parseInt(textFields[i][j].getText());
                    }
            }
            Sudoku.solve(Sudoku.board);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    textFields[i][j].setText(String.valueOf(Sudoku.board[i][j]));
                }
            }
        }
    }
}
