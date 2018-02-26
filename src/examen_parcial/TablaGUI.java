package examen_parcial;
//Javier Mondragon Martin del Campo A01365137

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

public class TablaGUI extends JPanel{
	
	int num;
	
	public TablaGUI(){
		
		CalculosDP calculos = new CalculosDP();
		
		//Create the frame and its components
		
		JLabel numTxt = new JLabel("Numero de la tabla = ");
		
		JTextField numField = new JTextField();
		JTextArea resultField = new JTextArea();
		
		JButton calculateButton = new JButton("Tabla de N");
		JButton exitButton = new JButton("Salir");
		
		//Create actions for the buttons
		
		calculateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Calculates the roots
				num = Integer.parseInt(numField.getText());
				resultField.setText(calculos.tablaN(num));
				
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
		
		numField.setPreferredSize(new Dimension(100, 20));
		resultField.setPreferredSize(new Dimension(200, 200));
		setPreferredSize(new Dimension(250, 400));
		setLayout(new FlowLayout());
		add(numTxt); add(numField);
		add(calculateButton); add(exitButton);
		add(resultField);
		
		
	}
	
	public static void main(String args[]){
		TablaGUI ec = new TablaGUI();
		JFrame frame = new JFrame("Tabla de N");
		JPanel panel = new JPanel();
		panel.add(ec);
		frame.add(panel);
		frame.pack();
		frame.setSize(260, 320);
		frame.setResizable(true);
		frame.setVisible(true);
	}

}
