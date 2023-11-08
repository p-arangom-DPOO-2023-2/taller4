package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.Tablero;

public class FPrincipal extends JFrame {
	private PDatos pDatos;
	private PLienzo pLienzo;
	private PFormulario pFormulario;
	private PConfig pConfig;
	private Tablero tablero;
	
	public FPrincipal() {
		this.tablero = new Tablero(5);
		this.setTitle("LightsOut");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.pDatos = new PDatos(this);
		this.pLienzo = new PLienzo(this);
		this.pConfig = new PConfig();
		this.pFormulario = new PFormulario(this);
		this.add(this.pDatos, BorderLayout.SOUTH);
		this.add(this.pLienzo, BorderLayout.CENTER);
		this.add(this.pFormulario, BorderLayout.EAST);
		this.add(this.pConfig, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	public PConfig getpConfig() {
		return pConfig;
	}

	public PDatos getpDatos() {
		return pDatos;
	}
	
	public PLienzo getpLienzo() {
		return pLienzo;
	}

	public Tablero getTablero() {
		return tablero;
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public void update() {
		this.pDatos.update();
		this.pLienzo.update();
	}
	
	public static void main(String[] args) {
		new FPrincipal();
	}
}
