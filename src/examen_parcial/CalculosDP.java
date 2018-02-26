package examen_parcial;
//Javier Mondragon Martin del Campo A01365137

public class CalculosDP
{
    public float gradosCF(float centigrados)
    {
        float farenheit = (float)9/5 * centigrados + 32;
        
        return farenheit;
    }
    
    public float gradosFC(float farenheit)
    {
        float centigrados = (float)5/9 * (farenheit - 32);
        
        return centigrados;
    }
    
    public int factorial(int n)
    {
        int f=1;
        
        for(int i=1;i<=n;i++)
        {
            f=f*i;
        }
        
        return f;
    }
    
    public int exponencial(int b, int x)
    {
        int e=1;
        
        for(int i=1; i<=x; i++)
            e = e * b;
        
        return e;
    }
    
    public static String ecuacion(int a, int b, int c)
    {
        String strA, strB, strC;
        String resultado="";
        //int a, b, c,
        int radical;
        float x, x1, x2;
        
        // 2. Checar el valor del coeficiente y calcular raices
        if(a == 0)
        {
            if(b==0)
            {
                //JOptionPane.showMessageDialog(null,"No hay Ecuacion, por lo tanto no hay raices...");
                resultado = "No hay Ecuacion, por lo tanto no hay raices...";
            }
            else
            {
                x = -(float)c/b;
                //JOptionPane.showMessageDialog(null,"Ecuacion Lineal X = "+x);
                resultado = "Ecuacion Lineal X = "+x;
            }
        }
        else
        {
            radical = b*b - 4*a*c;
            
            if(radical < 0)
            {
                //JOptionPane.showMessageDialog(null,"Raices Imginarias...");
                resultado = "Raices Imginarias...";
            }
            else
            {
                x1 = (-b - (float)Math.sqrt(radical)) / (2*a);
                x2 = (-b + (float)Math.sqrt(radical)) / (2*a);
                
                //JOptionPane.showMessageDialog(null,"Raices Reales\nX1 = "+x1+"\nX2 = "+x2);
                resultado = "Raices Reales\nX1 = "+x1+"\nX2 = "+x2;
            }
        }
        
        return resultado;
    }
    
    public String tablaN(int n){
    	String tabla = "";
    	for(int i=1; i<=10; i++)
			tabla += n +" X "+i+" = "+n*i+"\n";
    	return tabla;
    }
}





