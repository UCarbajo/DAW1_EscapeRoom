package herramientas;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {
	String rutaImagen;
	public PanelImagen(String rutaImagen) {
		this.rutaImagen=rutaImagen;
		//"/imagenes/Koala.jpg"
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource(this.rutaImagen));
		//System.out.println(getClass().getResource(this.rutaImagen));
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}