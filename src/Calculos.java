


//Javier Mondragon Martin del Campo A01365137
//01-28-2018

public class Calculos {
	
	//Gives the factorial of a number
	//@return The factorial number given
	//@param number An absolute number  
	public int getFactorial(int number){
		int factor=1;
		for(int i=1; i<=number; i++)factor*=i;
		return factor;
	}
	// Gives the degrees on celsius
	// @return The celsius number given
	// @param number Degrees on fahrenheit
	public float getCelsius(float number) {
		float celsius;
		celsius = ((number - 32) * 5 / 9)*100;
		celsius = Math.round(celsius)/(float)100;
		return celsius;
	}

	// Gives the degrees on fahrenheit
	// @return The fahrenheit number given
	// @param number Degrees on celsius
	public float getFahrenheit(float number) {
		float fahrenheit;
		fahrenheit = (number * 9 / 5 + 32)*100;
		fahrenheit = Math.round(fahrenheit)/(float)100;
		return fahrenheit;
	}
	
	public float getPow(float number, int pow){
		float result=number;
		for(int i=1; i<pow; i++)
			result*=number;
		return result;
	}
	
	/*
	 * Calculates the roots for a cuadratic equation
	 * @param a: first component of the ecuation as float
	 * @param b: second component of the ecuation as float
	 * @param c: third component of the ecuation as float
	 * @return roots: an array size of two with the square root of each result	 * 
	 */
	float[] getRoots(float a,float b,float c){
		float result;
		float roots[]={0,0};
		if(a==0){
			if(b==0){
				return roots;
			}else if(c/b>0){
				return null;				
			}else{
				roots[0]=(float) Math.sqrt(-c/b);
			}
		}else{
			result = b*b-4*a*c;
			if(result<0)
				return null;
			else{
				roots[0]=(float) ((-b+Math.sqrt(result))/(2*a));
				roots[1]=(float) ((-b-Math.sqrt(result))/(2*a));
			}
		}
		return roots;
	}

}
