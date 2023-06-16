import java.awt.Color;
import java.awt.image.BufferedImage;


public class BufferedImageBinary {	
	private int [][] matrizIMG;
	private int width;
	private int heigth;
	private int color1;
	private int color2;	
	
	public BufferedImageBinary(int [][]matrizIMG, int width, int heigth, int color1, int color2){
		this.matrizIMG = matrizIMG;
		this.width = width;
		this.heigth = heigth;
		this.color1 = color1;
		this.color2 = color2;
	}
	
	public BufferedImage getBufferedImage(){
		BufferedImage bufferedImage = new BufferedImage(this.width, this.heigth, BufferedImage.TYPE_BYTE_BINARY);
		int r;
		int g;
		int b;
		for(int i = 0; i < this.width ; i++){
	        for(int j = 0; j < this.heigth ; j++){
	        	r = matrizIMG[i][j] == 0 ? color1 : color2;
	        	g = matrizIMG[i][j] == 0 ? color1 : color2;
	        	b = matrizIMG[i][j] == 0 ? color1 : color2;
	        	
	        	bufferedImage.setRGB(i, j, new Color(r, g, b).getRGB());
	        }
		}
		return bufferedImage;
	}
}
