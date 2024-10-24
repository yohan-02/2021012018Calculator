import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalculator extends JFrame{
	JTextField numfield;
	JButton sum, sub, mult, div, cal, AC; 
	double result;
	String opt;
	MyCalculator() {
	this.setTitle("📱 계산기");
	
	
	showNorth();
	showCenter();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(400,200);
	setVisible(true);
}
void showNorth() {
	numfield = new JTextField(200);
	Font font = new Font("0", 0, 40);
	numfield.setFont(font);
	numfield.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			numfield.setText("");
		}
	});
	setLayout(new BorderLayout ());
	
	add(numfield, BorderLayout.NORTH);
}

void showCenter() {
	JPanel btnP = new JPanel(new GridLayout(5, 4));
//	JPanel panel = new JPanel(new GridLayout(5, 4));
	sum = new JButton("+");
	sub = new JButton("-");
	mult = new JButton("*");
	div = new JButton("/");
	cal = new JButton("=");
	AC = new JButton("A/C");
	
	
	btnP.add(AC);
	btnP.add(new JButton("+/-"));
	btnP.add(new JButton("%"));
	btnP.add(div);
	btnP.add(new JButton("7"));
	btnP.add(new JButton("8"));
	btnP.add(new JButton("9"));
	btnP.add(mult);
	btnP.add(new JButton("4"));
	btnP.add(new JButton("5"));
	btnP.add(new JButton("6"));
	btnP.add(sub);
	btnP.add(new JButton("1"));
	btnP.add(new JButton("2"));
	btnP.add(new JButton("3"));
	btnP.add(sum);
	btnP.add(new JButton("📱"));
	btnP.add(new JButton("0"));
	btnP.add(new JButton("."));
	btnP.add(cal);
	
	add(btnP, BorderLayout.CENTER);
	
	
	ActionListener sumAction = e -> {
		if(e.getSource() == sum) {
			String s = numfield.getText();
			double num = Double.parseDouble(s);
			opt = "sum";
			
			if (numfield.getText().isEmpty())
				numfield.setText("0");
			else {
				result = num + result;
				numfield.setText(""+ result);
			}
		}
	};
	ActionListener subAction = e -> {
		if(e.getSource() == sub) {
			String s = numfield.getText();
			double num = Double.parseDouble(s);
			opt = "sub";
			
			if (numfield.getText().isEmpty())
				numfield.setText("0");
			else if(result == 0) {
				result = num;
			}
			else {
				result = result - num;
				numfield.setText(""+ result);
			}
		}
	};ActionListener multAction = e -> {
		if(e.getSource() == mult) {
			String s = numfield.getText();
			double num = Double.parseDouble(s);
			opt = "mult";
			
			if (numfield.getText().isEmpty())
				numfield.setText("0");
			else if(result == 0){
				result = num;
			}
			else {
				result = num * result;
				numfield.setText(""+ result);
			}
		}
	};
	ActionListener divAction = e -> {
		if(e.getSource() == div) {
			String s = numfield.getText();
			double num = Double.parseDouble(s);
			opt = "div";
			
			if (numfield.getText().isEmpty())
				numfield.setText("0");
			else if (result == 0){
				result = num;
			}
			else if(num == 0){
				result = 0;
			}
			else {
				result = result / num;
			}
			numfield.setText(""+ result);
		}
	};
	ActionListener calAction = e -> {
		if(e.getSource() == cal) {
			String s = numfield.getText();
			double num = Double.parseDouble(s);
			
			if (numfield.getText().isEmpty())
				numfield.setText("0");
			if(opt == "sum") {
				result = result + num;
				}
			else if(opt == "sub") {
				result = result - num;
				}
			else if(opt == "mult") {
				result = result * num;
			}
			else if(opt == "div") {
				result = result / num;
			}
			else {
				result = num;
			}
			numfield.setText("" + result);
			}
		};
	ActionListener ACAction = e -> {
		if(e.getSource() == AC) {
		numfield.setText("");
		result =0;
		opt = "";
		}
		
	};
		
	sum.addActionListener(sumAction);
	sub.addActionListener(subAction);
	mult.addActionListener(multAction);
	div.addActionListener(divAction);
	cal.addActionListener(calAction);
	AC.addActionListener(ACAction);
}
	
	
	

	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyCalculator();
	}

}
