//Javier Mondragon Martin del Campo A01365137

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ProyectoGUI extends JFrame implements ActionListener{

	JMenuItem audioItem, exponencialItem, factorialItem, convertidorItem, ecuacionItem;
	
	AudioGUI audioGUI;
	ExponencialGUI exponencialGUI;
	FactorialGUI factorialGUI;
	FCGUI convertidorGUI;
	EcuacionGUI ecuacionGUI;
	
	JPanel container;
	
	
	ProyectoGUI(){
		
		//Creates the GUI objects
		
		audioGUI = new AudioGUI();
		exponencialGUI = new ExponencialGUI();
		factorialGUI = new FactorialGUI();
		convertidorGUI = new FCGUI();
		ecuacionGUI = new EcuacionGUI();
		
		container = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		JMenu opciones = new JMenu("Opciones");
		
		setLayout(new BorderLayout());
		
		audioItem = new JMenuItem("Audio");
		exponencialItem = new JMenuItem("Exponencial");
		factorialItem = new JMenuItem("Factorial");
		convertidorItem = new JMenuItem("Convertidor");
		ecuacionItem = new JMenuItem("Ecuacion");
		
		//Add the listener for the items
		
		audioItem.addActionListener(this);
		exponencialItem.addActionListener(this);
		factorialItem.addActionListener(this);
		convertidorItem.addActionListener(this);
		ecuacionItem.addActionListener(this);
		
		//Set the layout
		
		opciones.add(audioItem);
		opciones.add(exponencialItem);
		opciones.add(factorialItem);
		opciones.add(convertidorItem);
		opciones.add(ecuacionItem);
		
		menuBar.add(opciones);
		
		add(menuBar, BorderLayout.NORTH);
		
		container.add(audioGUI);
		container.add(exponencialGUI);
		container.add(factorialGUI);
		container.add(convertidorGUI);
		container.add(ecuacionGUI);
		
		add(container, BorderLayout.CENTER);
		
		hidePanels();
				
		//Display the window
		pack();
		audioGUI.setPreferredSize(new Dimension(220, 220));
		setSize(220, 220);
		setTitle("App: Audio");
		audioGUI.setVisible(true);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProyectoGUI app = new ProyectoGUI();
	}
	
	//Hide all panels
	
	public void hidePanels(){
		audioGUI.setVisible(false);
		exponencialGUI.setVisible(false);
		factorialGUI.setVisible(false);
		convertidorGUI.setVisible(false);
		ecuacionGUI.setVisible(false);
	}
	
	//Action listener for each item
	
	public void actionPerformed(ActionEvent e){
		hidePanels();
		if(e.getSource()==audioItem){
			audioGUI.setPreferredSize(new Dimension(220, 220));
			setSize(220, 220);
			setTitle("App: Audio");
			audioGUI.setVisible(true);
		}else if(e.getSource()==exponencialItem){
			exponencialGUI.setPreferredSize(new Dimension(375, 140));
			setSize(375, 140);
			setTitle("App: Exponencial");
			exponencialGUI.setVisible(true);
		}else if(e.getSource()==factorialItem){
			factorialGUI.setPreferredSize(new Dimension(375, 115));
			setSize(375, 115);
			setTitle("App: Factorial");
			factorialGUI.setVisible(true);
		}else if(e.getSource()==convertidorItem){
			convertidorGUI.setPreferredSize(new Dimension(375, 190));
			setSize(375, 190);
			setTitle("App: Convertidor");
			convertidorGUI.setVisible(true);
		}else if(e.getSource()==ecuacionItem){
			ecuacionGUI.setPreferredSize(new Dimension(230, 290));
			setSize(230, 290);
			setTitle("App: Ecuacion");
			ecuacionGUI.setVisible(true);
		}
	}

}
