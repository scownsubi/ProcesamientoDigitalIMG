import java.util.ArrayList;
import java.util.Iterator;

public class CuatroVecinosContorno {
	public int [][]matrizIMG;
	private int width = 0;
	private int heigth = 0;
	
	public ArrayList< NodoPixel > pixelImagenArea = new ArrayList< NodoPixel >();
	public ArrayList< NodoPixel > pixelContorno = new ArrayList< NodoPixel >();
	
	public CuatroVecinosContorno(int [][]MATRIZ_IMAGEN, int width, int height){
		this.matrizIMG = MATRIZ_IMAGEN;
		this.width = width;
		this.heigth = height;

		calcularBordeImagen();
		rellenarImagenFondo();
	}
	
	public void rellenarImagenFondo(){
		Iterator< NodoPixel > iterador = pixelImagenArea.iterator();
		while ( iterador.hasNext() ) {
			NodoPixel pos = iterador.next();
			int i = pos.getX();
			int j = pos.getY();
			matrizIMG[ i ][ j ] = 1;
		}
	}
	
	public void calcularBordeImagen(){
		NodoPixel nodoPixel;
		for( int i = 0; i < heigth; i++ ){
            for( int j = 0; j < width; j++ ){
            	if( matrizIMG[ i ][ j ]  == 0 ){
            		nodoPixel = new NodoPixel();
            		if( cuatroVecinos( i, j ) ){
            			nodoPixel.setX( i );
            			nodoPixel.setY( j );
            			
            			pixelImagenArea.add( nodoPixel );
            		}
            		else{
            			nodoPixel.setPixelPerimetroX( i );
            			nodoPixel.setPixelPerimetroY( j );
            			
            			pixelContorno.add( nodoPixel );
            		}
            	}
           }
		}
	}
	
	boolean cuatroVecinos( int i, int j ){
		int vecino = 0;
		if( ( j - 1 ) > -1 )
			if( matrizIMG[ i ][ j - 1] == 0 )
				vecino++;
		
		if( ( i - 1 ) > -1 )
			if( matrizIMG[ i - 1 ][ j ] == 0 )
				vecino++;

		if( ( j + 1 ) < width )
			if( matrizIMG[ i ][ j + 1] == 0 )
				vecino++;

		if( ( i + 1 ) < heigth )
			if( matrizIMG[ i + 1 ][ j ] == 0 )
				vecino++;
			
		
		if( vecino == 4 )
			return true;
		else
			return false;
	}
}
