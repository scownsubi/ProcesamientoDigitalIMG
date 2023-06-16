
public class ZhangSuen {
	public int [][]matrizIMG;
	private int width;
	private int heigth;
	
	public ZhangSuen(int [][]matrizIMG, int width, int heigth){
		this.matrizIMG = matrizIMG;
		this.width = width;
		this.heigth = heigth;
	}
	
	public void zhangSuen(){		
		for(int step = 1; step < 3; step++){
			for(int i = 0; i < this.width ; i++){
	            for(int j = 0; j < this.heigth ; j++){
	            	if(matrizIMG[i][j] != 0){
		            	int neighbors = sumNeighbors(i, j, 0);
		            	
		            	if(neighbors < 2 && neighbors > 6){
		            		continue;
		            	}
		            	
		            	if(sumTransition(i, j, -1) != 1){
		            		continue;
		            	}
		            	
		            	if(step == 1){
		            		if(proliferationStepOneA(i, j, 1) != 0){
		            			continue;
		            		}
		            		if(proliferationStepOneB(i, j, 1) != 0){
		            			continue;
		            		}
		            	}else{
		            		if(proliferationStepTwoA(i, j, 1) != 0){
		            			continue;
		            		}
		            		if(proliferationStepTwoB(i, j, 1) != 0){
		            			continue;
		            		}
		            	}
		            	matrizIMG[i][j] = 0;		            	
	            	}
	            }
			}
		}
	}
	
	public int[] neighbors(int i, int j, int valAux){
		int []vector = new int[8];
		
		vector[0] = i - 1 >= 0 ? matrizIMG[i-1][j] : valAux;
		vector[1] = i - 1 >= 0 && j + 1 < this.width ? matrizIMG[i-1][j+1] : valAux;
		vector[2] = j + 1 < this.width ? matrizIMG[i][j+1] : valAux;
		vector[3] = i + 1 < this.heigth && j + 1 < this.width ? matrizIMG[i+1][j+1] : valAux;
		vector[4] = i + 1 < this.heigth ? matrizIMG[i+1][j] : valAux;
		vector[5] = i + 1 < this.heigth && j - 1 >= 0 ? matrizIMG[i+1][j-1] : valAux;
		vector[6] = j - 1 >= 0 ? matrizIMG[i][j-1] : valAux;
		vector[7] = i - 1 >= 0 && j - 1 >= 0 ? matrizIMG[i-1][j-1] : valAux;
    	
    	return vector;
	}
	
	public int sumNeighbors(int i, int j, int valAux){
		int []vector = neighbors(i, j, valAux);
		int sum = 0;
		
		for(int cont = 0; cont < vector.length; cont++){
			sum += vector[cont];
		}
		
    	return sum;
	}
	
	public int sumTransition(int i, int j, int valAux){
		int []vector = neighbors(i, j, valAux);
		int sum = 0;
		
		for(int cont = 0; cont < vector.length - 1; cont++){
			if(vector[cont] == 0 && vector[cont+1] == 1){
				sum ++;
			}
		}
		
    	return sum;
	}
	
	public int proliferationStepOneA(int i, int j, int valAux){
		int []vector = neighbors(i, j, valAux);
		
    	return vector[1] * vector [3] * vector[5];
	}
	
	public int proliferationStepOneB(int i, int j, int valAux){
		int []vector = neighbors(i, j, valAux);
		
    	return vector[3] * vector [5] * vector[7];
	}
	
	public int proliferationStepTwoA(int i, int j, int valAux){
		int []vector = neighbors(i, j, valAux);
		
    	return vector[1] * vector [3] * vector[7];
	}
	
	public int proliferationStepTwoB(int i, int j, int valAux){
		int []vector = neighbors(i, j, valAux);
		
    	return vector[1] * vector [5] * vector[7];
	}
}
