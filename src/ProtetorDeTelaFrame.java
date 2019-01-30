import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProtetorDeTelaFrame extends JFrame{

	private final JPanel panelLinhas;
	private ProtetorDeTela prot;
	
	private final JTextField fieldLinhas;
	
	public ProtetorDeTelaFrame() {
		
		panelLinhas = new JPanel(new FlowLayout());
		
		fieldLinhas = new JTextField(5);
		fieldLinhas.setText("4");
		
		prot = new ProtetorDeTela(Integer.parseInt(fieldLinhas.getText()));
		
		fieldLinhas.addKeyListener(new LimiteListener());
		
		panelLinhas.add(fieldLinhas);
		
		add(panelLinhas, BorderLayout.NORTH);
		add(prot, BorderLayout.CENTER);
		
	}
	
	private class LimiteListener extends KeyAdapter{

		@Override
		public void keyReleased(KeyEvent arg0) {
			
			prot.setLimite(Integer.parseInt(fieldLinhas.getText()));
			
		}

		
	}
	
	
	
}
