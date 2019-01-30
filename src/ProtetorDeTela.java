import java.awt.Color;
import java.awt.GradientPaint;
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
			
			
			
			int forma = aleatorio.nextInt(2);
			int pontoX1 = aleatorio.nextInt(getWidth());
			int pontoY1 = aleatorio.nextInt(getHeight());
			
			g2d.setPaint(new GradientPaint(getWidth()/8, getHeight()/8,
					new Color(aleatorio.nextInt(256), aleatorio.nextInt(256), aleatorio.nextInt(256)),
					getWidth()/2, getHeight()/2,
					new Color(aleatorio.nextInt(256), aleatorio.nextInt(256), aleatorio.nextInt(256))));
			
			
			if(forma == 0) {
				
				g2d.fill(new Ellipse2D.Double(pontoX1, pontoY1, aleatorio.nextInt(getWidth() - pontoX1), aleatorio.nextInt(getHeight() - pontoY1)));
				
			}else if(forma == 1) {
				
				g2d.fill(new Rectangle2D.Double(pontoX1, pontoY1, aleatorio.nextInt(getWidth() - pontoX1), aleatorio.nextInt(getHeight() - pontoY1)));
				
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
