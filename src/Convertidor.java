import javax.swing.JOptionPane;

//Javier Mondragon Martin del Campo A01365137

public class Convertidor {
	
	public static void main(String args[]){
		boolean running=true;
		String number, awr;
		//Creates the object for the methods
		Convertidor obj = new Convertidor();
		while(running){
			//Ask the conversion type
			do{
				awr = JOptionPane.showInputDialog("Degrees converter.\n\nPlease write C to get from fahrenheit \nto celsius or F from celsius to fahrenheit.");
				if(!awr.equalsIgnoreCase("c")&&!awr.equalsIgnoreCase("f"))
					JOptionPane.showMessageDialog(null,"Answer not valid.");
			}while(!awr.equalsIgnoreCase("c")&&!awr.equalsIgnoreCase("f"));
			//Ask the degrees
			number=JOptionPane.showInputDialog("Please write the degrees below");
			//Shows the resulting degrees
			if(awr.equalsIgnoreCase("c"))
				JOptionPane.showMessageDialog(null, obj.getCelsius(Float.parseFloat(number))+" degrees");
			else
				JOptionPane.showMessageDialog(null, obj.getFahrenheit(Float.parseFloat(number))+" degrees");
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
	//@param number Degrees on fahrenheit  
	public float getCelsius(float number){
		float celsius;
		celsius = (number-32)*5/9;
		return celsius;
	}
	
	//Gives the factorial of a number
	//@return The factorial number given
	//@param number Degrees on celsius  
	public float getFahrenheit(float number){
		float fahrenheit;
		fahrenheit = number*9/5+32;
		return fahrenheit;
	}
}