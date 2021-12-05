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
		JLabel inputLabel = addLabel("Enter Infix Expression (Operations Allowed: ( ) ^ * / + - ) :", 1,1,1,1);
		inputField = addTextField("", 2,1,1,1);
		CalcButton = addButton("Calculate", 3,1,1,1);
	}

	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == CalcButton) {
			try {
				String ex = inputField.getText();
				PE = new PostfixEvaluator();
				IE = new InfixEvaluator();
				LinkedQueue<String> q = IE.toPostfix(ex);
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
	}
}
