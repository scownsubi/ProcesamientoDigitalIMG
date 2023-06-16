
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener{	
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboIMG;
	private JLabel labelIMG;
	
	private Image originalImage;
	private Image borderImage;
	private Image transformedImage;
	
	private String []nameIMG = {"",
			"binarioIMG",
			"binarioIMG1",
			"binarioIMG2"};	
	
	private PanelImage panel;
	
	private LoadingPixelImage loadingIMG;
	private CuatroVecinosContorno cuatroVecinos;
	private BufferedImageBinary bufferedImage;
	private ZhangSuen zhangSuen;
	
	public MainWindow(){
		super();
		setTitle("Procesamiento Digital de Imágenes");
		setSize(1100,550);
		setLocation(50,30);

		labelIMG = new JLabel("Seleccione una Imagen: ");
		labelIMG.setBounds(10,30,140,25);
		add(labelIMG);
		
		comboIMG = new JComboBox<String>(nameIMG);
		comboIMG.setBounds(150,30,140,25);
		comboIMG.addActionListener(this);
		add(comboIMG);
		
		panel = new PanelImage();
		add(panel,BorderLayout.CENTER);

		this.setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class PanelImage extends JPanel{
		private static final long serialVersionUID = 1L;
	
		public void paint(Graphics g){
			if(originalImage != null){
				g.drawImage(originalImage, this.getInsets().left + 10, this.getInsets().top + 80, this); // imagen original				
				g.drawImage(borderImage, this.getInsets().left + 360, this.getInsets().top + 80, this); // imagen contorno				
				g.drawImage(transformedImage, this.getInsets().left + 760, this.getInsets().top + 80, this); // imagen esqueleto
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if( comboIMG.getSelectedItem().toString().compareTo("")!=0){
						
			originalImage = Toolkit.getDefaultToolkit().getImage( "imagen\\" + comboIMG.getSelectedItem().toString()+".jpg" );
		    
			MediaTracker tracker = new MediaTracker(this);
			tracker.addImage(originalImage, 1);
					    
		    loadingIMG = new LoadingPixelImage();
		    
		    // Cuatro vecinos para determinar el contorno
			loadingIMG.loadingIMG("imagen\\" + comboIMG.getSelectedItem().toString() + ".jpg"); // ruta de la imagen
			cuatroVecinos = new CuatroVecinosContorno(loadingIMG.matrizIMG, loadingIMG.width, loadingIMG.heigth);
			bufferedImage = new BufferedImageBinary(cuatroVecinos.matrizIMG, loadingIMG.width, loadingIMG.heigth, 0, 255);
			borderImage = bufferedImage.getBufferedImage();
		    
			// Algoritmo de esqueletizacion ZhangSuen
		    loadingIMG.loadingIMG("imagen\\" + comboIMG.getSelectedItem().toString() + ".jpg"); // ruta de la imagen
			zhangSuen = new ZhangSuen(loadingIMG.matrizIMG, loadingIMG.width, loadingIMG.heigth);
			zhangSuen.zhangSuen();
			bufferedImage = new BufferedImageBinary(zhangSuen.matrizIMG, loadingIMG.width, loadingIMG.heigth, 255, 0);
			this.transformedImage = bufferedImage.getBufferedImage();
			
			repaint();
		}else{
			System.out.println("Error al cargar la imagen");
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}
}
