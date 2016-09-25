
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;



public class hhTask3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	CalculatingClass c = new CalculatingClass();
	c.calculate();

	}

}


class CalculatingClass
{
	Map<Integer,Integer> getDigits(int numberToParse)
	{
		Map<Integer,Integer> answer = new TreeMap<Integer,Integer>();
		
		while (numberToParse > 0)
		{
			int remainder = numberToParse % 10;
			numberToParse = numberToParse / 10;
			
			if (remainder == 0){
					continue;
			}

			if (answer.containsKey(remainder))
			{
				int storedValue = answer.get(remainder);
				answer.put(remainder, storedValue + 1);
			}
			else
			{
				answer.put(remainder, 1);
			}
		}
		
		return answer ;
	}
	
	int calculate()
	{
		final Logger LOGGER = Logger.getLogger(CalculatingClass.class.getName()); 
		LOGGER.setLevel(Level.FINEST); 
		
		
		System.out.print(getDigits(1)+"\n");
		System.out.print(getDigits(100)+"\n\n");
		
		
		for (int i =1; i< 4000; i++)
			if(getDigits(2*i).equals(getDigits(5*i)))
			{
				System.out.print(i + "*2="+2*i + " gives "+getDigits(i*2)+"\n");
				System.out.print(i + "*5="+5*i + " gives "+getDigits(i*5)+"\n\n");
			}

		LOGGER.log(Level.INFO,getDigits(1245566780).toString());
		
		
		
		return 0;
	}
}