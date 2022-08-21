import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe implements ActionListener{

    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel= new JPanel();
    JLabel textField=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.gray);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.LIGHT_GRAY);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Ink free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.getHSBColor(15,15,15));

        for(int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(player1_turn)
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textField.setText("0's Turn");
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("0");
                        player1_turn=true;
                        textField.setText("X's Turn");
                        check();
                    }
                }
            }
        }
    }


    public void firstTurn()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2)==0)
        {
            player1_turn=true;
            textField.setText("X 's turn");
        }
        else {
            player1_turn = false;
            textField.setText("0's turn");
        }
    }
    public void check()
    {
        //Check X win condition

        if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X"))
        {
            xWins(2,4,6);
        }


        if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X"))
        {
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X"))
        {
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X"))
        {
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X"))
        {
            xWins(2,4,6);
        }


        //check 0 win condition

        if((buttons[0].getText()=="0")&&(buttons[1].getText()=="0")&&(buttons[2].getText()=="0"))
        {oWins(2,4,6);
        }


        if((buttons[3].getText()=="0")&&(buttons[4].getText()=="0")&&(buttons[5].getText()=="0"))
        {
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="0")&&(buttons[7].getText()=="0")&&(buttons[8].getText()=="0"))
        {
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="0")&&(buttons[3].getText()=="0")&&(buttons[6].getText()=="0"))
        {
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="0")&&(buttons[4].getText()=="0")&&(buttons[7].getText()=="0"))
        {
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="0")&&(buttons[5].getText()=="0")&&(buttons[8].getText()=="0"))
        {
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="0")&&(buttons[4].getText()=="0")&&(buttons[8].getText()=="0"))
        {
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="0")&&(buttons[4].getText()=="0")&&(buttons[6].getText()=="0"))
        {
            oWins(2,4,6);
        }
    }
    public void xWins(int a,int b,int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
    }
    public void oWins(int a, int b,int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("0 wins");
    }
}
