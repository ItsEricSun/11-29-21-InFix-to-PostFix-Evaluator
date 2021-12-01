import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBFrame;

public class GUI extends GBFrame {

	static JFrame frm;
	InfixEvaluator IE = new InfixEvaluator();
	PostfixEvaluator PE = new PostfixEvaluator();
	JTextField inputField;
	JButton CalcButton;
	
	public void MainMenu() {
		JLabel inputLabel = addLabel("Enter Infix Expression (One space between every number and operation):", 1,1,1,1);
		JLabel input2Label = addLabel("Operations Allowed: ( ) ^ * / + -", 2,1,1,1);
		inputField = addTextField("", 3,1,1,1);
		CalcButton = addButton("Calculate", 4,1,1,1);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == CalcButton) {
			try {
			String ex = inputField.getText();
			LinkedQueue<String> q = IE.toPostfix(ex);
//		    double result = PE.evaluate(q);
		    messageBox("Postfix: " + q.toString() + "\nResult: " + PE.evaluate(q));
			} catch (Exception e) {
				messageBox("Input Error");
			}
		}
	}
	
	public GUI() {
		MainMenu();
	}
	
	public static void main(String[] args) {
		frm = new GUI();
		frm.setTitle("Infix Calculator");
		frm.setSize(450, 200);
		frm.setVisible(true);
		
		try {
			Double.parseDouble("234f");
		} catch (NumberFormatException e) {
			System.out.println("A");
		}
		System.out.println("B");
		
//		Scanner sc = new Scanner(System.in);
//	    System.out.println("Enter Infix Expression (One space between every number and operation):");
//	    String ex = sc.nextLine();
//	    InfixEvaluator IE = new InfixEvaluator();
//	    PostfixEvaluator PE = new PostfixEvaluator();
//	    LinkedQueue q = IE.toPostfix(ex);
//	    
//	    System.out.println(q.toString());
//	    System.out.println(PE.evaluate(q));
	    
	    
//	    String[] input = ex.split(" ");
//	    System.out.println(input.length);
//	    for(int i = 0; i < input.length; i++) {
//	    	Double.parseDouble(input[i]);
//			System.out.println(input[i]);
//		}

	}

}
