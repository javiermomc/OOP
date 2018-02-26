


//Javier Mondragon Martin del Campo A01365137
//01-28-2018

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class FCGUI extends JPanel {

	static Calculos math;
	
	JLabel lResultado;
	JTextField tfGrados;
	JButton bCalcularCF, bCalcularFC, bSalir;

	FCGUI(){
//		super("Conversion de grados");
		
		//Create the objects and set dimensions
		
		math = new Calculos();
		tfGrados = new JTextField();
		lResultado = new JLabel ();
		bCalcularCF= new JButton("Centigrados a Fahrenheit");
		bCalcularFC= new JButton("Fahrenheit a Centigrados");
		bSalir = new JButton("Salir");
		
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		
		setLayout(layout);
		
		tfGrados.setPreferredSize(new Dimension(40,25));
		lResultado.setPreferredSize(new Dimension(40,25));
		
		//Button events on click
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bSalir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Destroys the object itself to close the window and close the program
//				dispose();
				System.exit(0);
			}
			
		});
		
		bCalcularCF.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Converts the degrees in tfGrados into fahrenheit and assign them to lResultado label
				lResultado.setText(Float.toString(math.getFahrenheit(Float.parseFloat(tfGrados.getText()))));
			}
			
		});
		
		bCalcularFC.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Converts the degrees in tfGrados into celsius and assign them to lResultado label
				lResultado.setText(Float.toString(math.getCelsius(Float.parseFloat(tfGrados.getText()))));
			}
			
		});
		
		//Set the layout of labels
		lResultado.setBackground(Color.white);
		lResultado.setOpaque(true);
		
		//Add objects to the layout
		add(new JLabel("Grados:"));
		add(tfGrados);
		add(new JLabel("Resultado:"));
		add(lResultado);
		add(bCalcularCF);
		add(bCalcularFC);
		add(bSalir);
		
		//Show the window
//		setSize(375, 150);
//		setResizable(false);
//		setVisible(true);
	}

//	public static void main(String args[]) {
//		math = new Calculos();
//		FCGUI gui = new FCGUI();
//	}

}