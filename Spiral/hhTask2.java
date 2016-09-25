import java.io.Console;


public class hhTask2 {

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		CalculateDiagonalValue h = new CalculateDiagonalValue();
		h.Calculate(Integer.parseInt((args[0]))); 
	}

}


class CalculateDiagonalValue
{
	int Calculate(int sideSize)
	{
		if (sideSize % 2 == 0){
			return -1;
		}
		
		int square [][] = new int [sideSize+1][sideSize+1];
		int center = (sideSize / 2) + 1;
		int xPosition, yPosition;
		xPosition = yPosition = center;
		int currentHalvSideSize = 0;
		int currentValue =1;
		square[center][center] =currentValue;
		
		while (xPosition < sideSize || yPosition >1 )
		{
			currentHalvSideSize += 1;
			while( xPosition < (center + currentHalvSideSize) )
			{
				currentValue++;
				xPosition ++;
				square[xPosition][yPosition]=currentValue;	
			}
			while( yPosition < (center + currentHalvSideSize) )
			{
				currentValue++;
				yPosition ++;
				square[xPosition][yPosition]=currentValue;	
			}
			while( xPosition > (center - currentHalvSideSize) )
			{
				currentValue++;
				xPosition --;
				square[xPosition][yPosition]=currentValue;	
			}
			while( yPosition > (center- currentHalvSideSize) )
			{
				currentValue++;
				yPosition --;
				square[xPosition][yPosition]=currentValue;	
			}
			while( xPosition < (center + currentHalvSideSize) )
			{
				currentValue++;
				xPosition ++;
				square[xPosition][yPosition]=currentValue;	
			}
		}
		for(int y=1; y<=sideSize; y++){
			for(int x=1; x<=sideSize; x++)
			{
				System.out.print(square[x][y] +"\t");
			}
			System.out.print("\n");
		}
		
		int diagSumm=0;
		for(int diag =1; diag<=sideSize; diag++){
			diagSumm+=square[diag][diag];
			System.out.print(square[diag][diag]+" ");
					
		}
		for(int diag =1; diag<=sideSize; diag++){
			diagSumm+=square[sideSize-diag+1][diag];
			System.out.print(square[sideSize-diag+1][diag]+" ");
					
		}
		System.out.print("\nTotal answer "+(diagSumm-1) + '\n');	
				
		
		
		return 0;
	}
}