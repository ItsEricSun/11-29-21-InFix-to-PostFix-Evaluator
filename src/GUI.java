import java.util.Scanner;

public class GUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Infix Expression (One space between every number and operation):");
	    String ex = sc.nextLine();
	    InfixEvaluator IE = new InfixEvaluator();
	    LinkedQueue q = IE.toPostfix(ex);
	    System.out.println(q.toString());
//	    String[] input = ex.split(" ");
//	    System.out.println(input.length);
//	    for(int i = 0; i < input.length; i++) {
//	    	Double.parseDouble(input[i]);
//			System.out.println(input[i]);
//		}

	}

}
