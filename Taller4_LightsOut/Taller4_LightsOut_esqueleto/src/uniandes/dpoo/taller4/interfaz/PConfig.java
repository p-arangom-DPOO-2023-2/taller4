package uniandes.dpoo.taller4.interfaz;

import java.awt.FlowLayout;

import javax.swing.*;

public class PConfig extends JPanel {
	private JComboBox<Integer> tamanios;
	private ButtonGroup dificultad;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	private int tamanioElegido;
	private int nivelDif;
	
	public PConfig(){
		this.tamanioElegido = 5;
		this.nivelDif = 1;
		this.setLayout(new FlowLayout());
		Integer[] tamanio = {5, 6, 7, 8};
		this.tamanios = new JComboBox<>(tamanio);
		this.tamanios.addActionListener(e -> {
            this.tamanioElegido = (int) tamanios.getSelectedItem();
        });
		this.add(this.tamanios);
		
		this.dificultad = new ButtonGroup();
		this.facil = new JRadioButton("Facil");
		this.medio = new JRadioButton("Medio");
		this.dificil = new JRadioButton("Dificil");
		this.dificultad.add(facil);
		this.dificultad.add(medio);
		this.dificultad.add(dificil);
        facil.addActionListener(e -> {
        	this.nivelDif = 3;
        });

        medio.addActionListener(e -> {
        	this.nivelDif = 5;

        });

        dificil.addActionListener(e -> {
        	this.nivelDif = 7;

        });
		this.add(facil);
		this.add(medio);
		this.add(dificil);
	}

	public int getTamanioElegido() {
		return tamanioElegido;
	}

	public int getNivelDif() {
		return nivelDif;
	}

}
