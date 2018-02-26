

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI extends JFrame{
	
	FCGUI fcPanel;
	FactorialGUI factorialPanel;
	ExponencialGUI expPanel;
	
	GUI(){
		
		JMenuBar menuBar = new JMenuBar();
		JMenuItem menuFC = new JMenuItem("Degrees");
		JMenuItem menuFactorial = new JMenuItem("Factorial");
		JMenuItem menuExp = new JMenuItem("Exponential");
		
		fcPanel = new FCGUI();
		factorialPanel = new FactorialGUI();
		expPanel = new ExponencialGUI();
		
		add(menuBar);
		add(fcPanel);
		add(factorialPanel);
		add(expPanel);
		
		menuFC.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hidePanels();
				fcPanel.setVisible(true);
			}
			
		});

		menuFactorial.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hidePanels();
				factorialPanel.setVisible(true);
			}
			
		});
		
		menuExp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hidePanels();
				expPanel.setVisible(true);
			}
			
		});
		
		menuBar.add(menuFC);
		menuBar.add(menuFactorial);
		menuBar.add(menuExp);
//		hidePanels();
		pack();
		setJMenuBar(menuBar);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		GUI gui = new GUI();
	}
	
	void hidePanels(){
		fcPanel.setVisible(false);
		factorialPanel.setVisible(false);
		expPanel.setVisible(false);
	}
}
