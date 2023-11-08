package uniandes.dpoo.taller4.interfaz;


import java.awt.FlowLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PDatos extends JPanel {
	private JLabel lJugadas;
	private JLabel lJugador;
	private FPrincipal fPrincipal;
	
	public PDatos(FPrincipal fPrincipal) {
		this.lJugadas = new JLabel("Jugadas: 0");
		this.lJugador = new JLabel("Jugador: Invitado");
		this.fPrincipal = fPrincipal;
		this.setLayout(new FlowLayout());
		this.add(this.lJugadas);
		this.add(this.lJugador);
	}

	public void update() {
		Tablero tablero = this.fPrincipal.getTablero();
		this.lJugadas.setText("Jugadas: " + tablero.darJugadas());		
	}
}
