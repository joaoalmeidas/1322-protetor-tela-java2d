import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
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
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i = 0; i < limite; i++) {
			
			g2d.setColor(new Color(aleatorio.nextInt(256), aleatorio.nextInt(256), aleatorio.nextInt(256)));
			
			int forma = aleatorio.nextInt(2);
			int pontoX = aleatorio.nextInt(getWidth());
			int pontoY = aleatorio.nextInt(getHeight());
			
			if(forma == 0) {
				
				g2d.fill(new Ellipse2D.Double(pontoX, pontoY, aleatorio.nextInt(getWidth() - pontoX), aleatorio.nextInt(getHeight() - pontoY)));
				
			}else if(forma == 1) {
				
				g2d.fill(new Rectangle2D.Double(pontoX, pontoY, aleatorio.nextInt(getWidth() - pontoX), aleatorio.nextInt(getHeight() - pontoY)));
				
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
