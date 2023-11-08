package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class PFormulario extends JPanel {
	private FPrincipal fPrincipal;
	private JButton bNuevo;
	private JButton bReiniciar;
	private JButton bTop;
	private JButton bCambiar;

	public PFormulario(FPrincipal fPrincipal) {
		this.fPrincipal = fPrincipal;
		this.setLayout(new BorderLayout());
		JPanel pElementos = new JPanel();
		pElementos.setLayout(new GridLayout(4,1,10,5));		
		this.add(pElementos, BorderLayout.NORTH);
		this.bNuevo = new JButton("NUEVO");
		this.bReiniciar = new JButton("REINICIAR");
		this.bTop = new JButton("TOP 10");
		this.bCambiar = new JButton("CAMBIAR JUGADOR");
		pElementos.add(bNuevo);
		pElementos.add(bReiniciar);
		pElementos.add(bTop);
		pElementos.add(bCambiar);
		
		bNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		bReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		bTop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					top();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public FPrincipal getfPrincipal() {
		return fPrincipal;
	}
	
	public void nuevo() {
		Tablero tablero = new Tablero(this.fPrincipal.getpConfig().getTamanioElegido());
		tablero.desordenar(this.fPrincipal.getpConfig().getNivelDif());
		tablero.salvar_tablero();
		this.fPrincipal.setTablero(tablero);
		this.fPrincipal.update();
	}
	
	public void reiniciar() {
		Tablero tablero = this.fPrincipal.getTablero();
		tablero.reiniciar();
		this.fPrincipal.setTablero(tablero);
		this.fPrincipal.update();
	}
	
	public void top() throws FileNotFoundException, UnsupportedEncodingException {
		Top10 top = new Top10();
		File file = new File("data\top10.csv");
		top.cargarRecords(file);
		int cont = 0;
		JDialog popup = new JDialog();
        JPanel panel2 = new JPanel();
        Collection<RegistroTop10> registros = top.darRegistros();
        for (RegistroTop10 reg : registros) {
            String nombre = reg.darNombre();
            String puntos = String.valueOf(reg.darPuntos());
            cont++;
            panel2.add(new JLabel(String.valueOf(cont) + ". " + nombre + "...." + puntos));
        }
        popup.add(panel2);

        popup.setSize(100, 300);
        popup.setModal(true);
        popup.setLocationRelativeTo(null);
        popup.setVisible(true);
	}
}
