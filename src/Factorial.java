//	Javier Mondragon Martin del Campo A01365137
//	01/21/2018

import javax.swing.JOptionPane;

public class Factorial{
	
	public static void main(String args[]){
		boolean running=true;
		String number, awr;
		//Creates the object for the methods
		Factorial obj = new Factorial();
		while(running){
			//Ask the number
			number = JOptionPane.showInputDialog("Get the factorial of a number.\nPlease write the number below.");
			//Shows the factorial using the getFactorial method
			JOptionPane.showMessageDialog(null, obj.getFactorial(Integer.parseInt(number)));
			//Ask for another iteration
			do{
				awr=JOptionPane.showInputDialog("Do you want to try again?\nUse y as yes or n for no");
				if(!(awr.equalsIgnoreCase("y")||awr.equalsIgnoreCase("n")))
					JOptionPane.showMessageDialog(null, "The answer was not y or n...");
			}while(!(awr.equalsIgnoreCase("y")||awr.equalsIgnoreCase("n")));
			if(awr.equalsIgnoreCase("n"))running=false;
		}		
	}
	
	//Gives the factorial of a number
	//@return The factorial number given
	//@param number An absolute number  
	public int getFactorial(int number){
		int factor=1;
		for(int i=1; i<=number; i++)factor*=i;
		return factor;
	}
}