import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;


public class Task8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeMap<BigInteger,Integer> allNumbers = new TreeMap<BigInteger, Integer>();
		
		for (int a = 3; a < 107; a++ )
		{
			for (int b =3; b < 116; b++)
			{
				System.out.print(a+"^"+b);
				BigInteger currentNumber = BigInteger.valueOf(a);
				currentNumber = currentNumber.pow(b);
				if (allNumbers.containsKey(currentNumber))
				{
					int currentNumberAmount = allNumbers.get(currentNumber);
					allNumbers.put(currentNumber, currentNumberAmount + 1);
					System.out.println("was "+currentNumberAmount + "times");
				}
				else
				{
					System.out.println("yet was not");
					allNumbers.put(currentNumber, 1);
				}
			}
		}
		System.out.print("answer: "+allNumbers.size());
		

	}

	
	
	
}
