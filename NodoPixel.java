
public class NodoPixel {
	private int posXIn;
	private int posYIn;
	
	private int pixelPerimetroX;
	private int pixelPerimetroY;
	
	public void setX( int x){
		this.posXIn = x;
	}
	public int getX(){
		return this.posXIn;
	}
	public void setY( int y){
		this.posYIn = y;
	}
	public int getY(){
		return this.posYIn;
	}
	
	public void setPixelPerimetroX( int pixelPerimetroX){
		this.pixelPerimetroX = pixelPerimetroX;
	}
	public int getPixelPerimetroX(){
		return this.pixelPerimetroX;
	}
	public void setPixelPerimetroY( int pixelPerimetroY){
		this.pixelPerimetroY = pixelPerimetroY;
	}
	public int getPixelPerimetroY(){
		return this.pixelPerimetroY;
	}
}
