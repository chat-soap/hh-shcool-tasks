
public class hhTask2 {

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		CalculateDiagonalValue h = new CalculateDiagonalValue();
		h.Calculate(5);
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
			
				
		
		
		return 0;
	}
}