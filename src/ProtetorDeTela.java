import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ProtetorDeTela extends JPanel implements ActionListener{
	
	private final SecureRandom aleatorio = new SecureRandom();
	private Timer tempo ;
	private int limite;
	
	public ProtetorDeTela(int limite){
		
		tempo = new Timer(1000, this);
		tempo.start();
		this.limite = limite;
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		for(int i = 0; i < limite; i++) {
			
			g.setColor(new Color(aleatorio.nextInt(256), aleatorio.nextInt(256), aleatorio.nextInt(256)));
			
			int forma = aleatorio.nextInt(4);
			int pontoX = aleatorio.nextInt(getWidth());
			int pontoY = aleatorio.nextInt(getHeight());
			
			if(forma == 0) {
				
				g.drawLine(pontoX, pontoY, aleatorio.nextInt(getWidth()), aleatorio.nextInt(getHeight()));
				
			}else if(forma == 1) {
				
				g.fillRect(pontoX, pontoY, aleatorio.nextInt(getWidth() - pontoX), aleatorio.nextInt(getHeight() - pontoY));
				
			}else if(forma == 2) {
				
				g.fillOval(pontoX, pontoY, aleatorio.nextInt(getWidth() - pontoX), aleatorio.nextInt(getHeight() - pontoY));
				
			}else if(forma == 3) {
				
				g.fillArc(pontoX, pontoY, aleatorio.nextInt(getWidth() - pontoX), aleatorio.nextInt(getHeight() - pontoY), 
						aleatorio.nextInt(360), aleatorio.nextInt(360));
				
			}
			
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		repaint();
		
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	
}
