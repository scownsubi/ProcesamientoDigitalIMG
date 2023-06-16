
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadingPixelImage {
	public int width;
	public int heigth;
	public int [][]matrizIMG;
	private BufferedImage image;
	
	public void loadingIMG( String ruta ){
		try{
            image = ImageIO.read(new File(ruta));
            this.width = image.getWidth();
            this.heigth = image.getHeight();
            this.matrizIMG = new int[this.width][this.heigth];
            
            for(int i = 0; i < this.width; i++){
                for(int j = 0; j < this.heigth; j++){
                    if(image.getRaster().getSample(i, j, 0) >= 127){
                    	this.matrizIMG[ i ][ j ] = 0;
                    }else{
                    	this.matrizIMG[ i ][ j ] = 1;
                    }
                } 
            }
        }catch( IOException e ){
            System.out.println( e );
        }
	}
}
