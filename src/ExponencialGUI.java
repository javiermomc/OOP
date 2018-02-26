

//Javier Mondragon Martin del Campo A01365137
//01-28-2018

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ExponencialGUI extends JPanel {

	static Calculos math;
	JLabel lResultado;
	JTextField tfNumber, tfExp;
	JButton bCalcularP, bSalir;

	ExponencialGUI(){
//		super("Potencia");
		
		//Create the objects and set dimensions
		
		math = new Calculos();
		tfNumber = new JTextField();
		tfExp = new JTextField();
		lResultado = new JLabel ();
		bCalcularP= new JButton("Potencia");
		bSalir = new JButton("Salir");
		
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		
		setLayout(layout);
		
		tfNumber.setPreferredSize(new Dimension(40,25));
		tfExp.setPreferredSize(new Dimension(40,25));
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
		
		bCalcularP.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Get the Potencia from tfNumber and assign it to lResultado label
				lResultado.setText(Float.toString(math.getPow(Float.parseFloat(tfNumber.getText()), Integer.parseInt(tfExp.getText()))));
			}
			
		});
		
		//Set the layout of labels
		lResultado.setBackground(Color.white);
		lResultado.setOpaque(true);
		
		//Add objects to the layout
		add(new JLabel("Numero:"));
		add(tfNumber);
		add(new JLabel("Potencia:"));
		add(tfExp);
		add(new JLabel("Resultado:"));
		add(lResultado);
		add(bCalcularP);
		add(bSalir);
		
		//Show the window
//		setSize(375, 100);
//		setResizable(false);
//		setVisible(true);
	}

//	public static void main(String args[]) {
//		
//		ExponencialGUI gui = new ExponencialGUI();
//	}

}