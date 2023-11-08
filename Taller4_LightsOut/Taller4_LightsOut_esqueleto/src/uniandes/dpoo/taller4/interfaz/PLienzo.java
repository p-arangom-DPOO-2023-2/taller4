package uniandes.dpoo.taller4.interfaz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PLienzo extends JPanel implements MouseListener {
	
	private FPrincipal fPrincipal;
	private int size;
	private int tamanio;
	private int ultima_fila; 
	private int ultima_colum; 
	private final int w = 400;
	private final int h = 400;
	
	public PLienzo(FPrincipal fPrincipal) {
		this.fPrincipal = fPrincipal;
		this.addMouseListener(this);
		repaint();	
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, w, h);
		for (int fila = 0; fila < size; fila++) {
			for (int colum = 0; colum < size; colum++) {
				if (this.fPrincipal.getTablero().darTablero()[fila][colum]) {
					g2d.setColor (Color.YELLOW);
				} else {
					g2d.setColor(Color.BLACK);
				}
				g2d.fillRect((colum * tamanio)+1, (fila * tamanio)+1, tamanio-1, tamanio-1);
			}
		}
	}

	public void update() {
		Tablero tablero = this.fPrincipal.getTablero();
		this.size = tablero.darTablero().length;
		this.tamanio = w / size;
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(h > e.getY() && e.getY() > 0 && e.getX() > 0 && w > e.getX() ) {
			this.fPrincipal.getTablero().jugar(obtenerFila(e.getY()), obtenerColum(e.getX()));
			this.ultima_fila = obtenerFila(e.getY());
			this.ultima_colum = obtenerColum(e.getX());
			this.fPrincipal.update();
			repaint();
		}
	}

	private int obtenerColum(int x) {
		return (int) ( x / tamanio);
	}
	
	private int obtenerFila(int y) {
		return (int) (y / tamanio);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
