import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// @author Javier Mondragon Martin del Campo A01365137

public class EcuacionGUI extends JPanel{
	
	float coefA,coefB, coefC;
	float[] roots;
	
	public EcuacionGUI(){
		
		Calculos calculos = new Calculos();
		
		//Create the frame and its components
		
		JPanel frame = this;
		
		JLabel coefATxt = new JLabel("Coeficiente A = ");
		JLabel coefBTxt = new JLabel("Coeficiente B = ");
		JLabel coefCTxt = new JLabel("Coeficiente C = ");
		
		JTextField coefAField = new JTextField();
		JTextField coefBField = new JTextField();
		JTextField coefCField = new JTextField();
		JTextArea resultField = new JTextArea();
		
		JButton calculateButton = new JButton("Calcular Raices");
		JButton exitButton = new JButton("Salir");
		
		//Create actions for the buttons
		
		calculateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Calculates the roots
				coefA = Float.parseFloat(coefAField.getText());
				coefB = Float.parseFloat(coefBField.getText());
				coefC = Float.parseFloat(coefCField.getText());
				
				if(coefA==0&&coefB==0)
					resultField.setText("No se puede dividir entre 0");
				else
					if(calculos.getRoots(coefA, coefB, coefC)!=null){
						roots = calculos.getRoots(coefA, coefB, coefC);
						if(coefA!=0)
							resultField.setText("X1 = "+roots[0]+"\nX2 = "+roots[1]);
						else
							resultField.setText("X = "+roots[0]);
					}else
						resultField.setText("Numero Imaginario");
				
			}
			
		});
		
		exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Destroys the object itself to close the window and close the program
				System.exit(0);
			}
			
		});
		
		// Set dimensions and display the frame
		
		coefAField.setPreferredSize(new Dimension(100, 20));
		coefBField.setPreferredSize(new Dimension(100, 20));
		coefCField.setPreferredSize(new Dimension(100, 20));
		resultField.setPreferredSize(new Dimension(200, 100));
		
		frame.setLayout(new FlowLayout());
		frame.add(coefATxt); frame.add(coefAField);
		frame.add(coefBTxt); frame.add(coefBField);
		frame.add(coefCTxt); frame.add(coefCField);
		frame.add(resultField);
		frame.add(calculateButton); frame.add(exitButton);
		
		
	}
	
//	public static void main(String args[]){
//		
//		EcuacionGUI ec = new EcuacionGUI();
//		JFrame frame = new JFrame();
//		frame.add(ec);
//		frame.pack();
//		frame.setSize(230, 270);
//		frame.setResizable(false);
//		frame.setVisible(true);
//	}

}
