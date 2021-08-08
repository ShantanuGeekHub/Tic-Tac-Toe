package ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener{
	
	JButton b[] = new JButton[9];
	int count=0;
	int flag=0;
	
	TicTacToe(){
		
		setLayout(new GridLayout(3,3));
		
		//frame
		setBounds(100,200,400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Tic-Tac-Toe");
		
		//buttons
		for(int i=0; i<9; i++) {
			b[i] = new JButton();
			add(b[i]);
			b[i].addActionListener(this);
			b[i].setForeground(Color.magenta);
		}
		
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(flag == 0) {
			JButton b1 = (JButton)e.getSource();
			if(count%2==0) {
				b1.setLabel("X");
				b1.setBackground(Color.yellow);
			}
			else {
				b1.setLabel("O");
				b1.setBackground(Color.cyan);
			}
			b1.removeActionListener(this);
			count++;
			
			if(count == 9) {
				winner("Its a tie...!");
			}
			else {
				check();
			}
		}
		
	}
	
	void check() {
		if(
			(b[0].getLabel()=="X" && b[1].getLabel()=="X" && b[2].getLabel()=="X") ||
			(b[3].getLabel()=="X" && b[4].getLabel()=="X" && b[5].getLabel()=="X") ||
			(b[6].getLabel()=="X" && b[7].getLabel()=="X" && b[8].getLabel()=="X") ||
			(b[0].getLabel()=="X" && b[3].getLabel()=="X" && b[6].getLabel()=="X") ||
			(b[1].getLabel()=="X" && b[4].getLabel()=="X" && b[7].getLabel()=="X") ||
			(b[2].getLabel()=="X" && b[5].getLabel()=="X" && b[8].getLabel()=="X") ||
			(b[0].getLabel()=="X" && b[4].getLabel()=="X" && b[8].getLabel()=="X") ||
			(b[2].getLabel()=="X" && b[4].getLabel()=="X" && b[6].getLabel()=="X") 
				) {
			
			winner("X is a Winner...!");
			
		}
		else if(
				(b[0].getLabel()=="O" && b[1].getLabel()=="O" && b[2].getLabel()=="O") ||
				(b[3].getLabel()=="O" && b[4].getLabel()=="O" && b[5].getLabel()=="O") ||
				(b[6].getLabel()=="O" && b[7].getLabel()=="O" && b[8].getLabel()=="O") ||
				(b[0].getLabel()=="O" && b[3].getLabel()=="O" && b[6].getLabel()=="O") ||
				(b[1].getLabel()=="O" && b[4].getLabel()=="O" && b[7].getLabel()=="O") ||
				(b[2].getLabel()=="O" && b[5].getLabel()=="O" && b[8].getLabel()=="O") ||
				(b[0].getLabel()=="O" && b[4].getLabel()=="O" && b[8].getLabel()=="O") ||
				(b[2].getLabel()=="O" && b[4].getLabel()=="O" && b[6].getLabel()=="O") 
					) {
				winner("O is a Winner");
			}
		
	}
	
	void winner(String str) {
		//popup frame to declare winner
		JFrame f1 = new JFrame();
		f1.setLayout(null);
		f1.setBounds(150,300,300,200);
		f1.setTitle("Winner");
		
		//creating label
		JLabel l1 = new JLabel(str);
		l1.setBounds(120,80,100,10);
		f1.add(l1);
		
		flag++;
		
		f1.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		TicTacToe t1 = new TicTacToe();
		
	}
	
	
	
}
