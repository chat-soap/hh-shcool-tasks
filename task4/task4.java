
import java.util.ListIterator;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class task4 {

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
	
	
	public Boolean isPalyndrome(Vector<Integer> numberToCheck)
	{
		ListIterator<Integer> left = numberToCheck.listIterator();
		ListIterator<Integer> right = numberToCheck.listIterator(numberToCheck.size());
		
		while (left.nextIndex() < right.previousIndex() )
		{
			if ( left.next() != right.previous() )
			{
				return false;
			}
		}
		
		
		return true;
	}


	public Vector<Integer> rotate( Vector<Integer> numberToProcess )
	{
		Vector<Integer> answer = new Vector<Integer>();
		ListIterator<Integer> right = numberToProcess.listIterator(numberToProcess.size());
		{
			while (right.hasPrevious())
			{
				answer.add(right.previous());
			}
		}
		
		return answer;
	}
	
	
	Vector<Integer> getDigits(int numberToParse)
	{
		Vector<Integer> answerReversed = new Vector<Integer>();
		
		while (numberToParse > 0)
		{
			int remainder = numberToParse % 10;
			numberToParse = numberToParse / 10;
			
			answerReversed.add(remainder);
		}
		//order was reversed. Reverse it back

		Vector<Integer> answer = rotate(answerReversed);
		return answer ;
	}
	
	int convertToNumber(Vector<Integer> numberToConvert)
	{
		int answer = 0;
		ListIterator<Integer> right = numberToConvert.listIterator(numberToConvert.size());
		int currentPositionWeight = 1;
		while(right.hasPrevious())
		{
			answer += right.previous() * currentPositionWeight;
			currentPositionWeight *= 10;
		}
		
		return answer;
		
	}
	
	int calculate()
	{
		final Logger LOGGER = Logger.getLogger(CalculatingClass.class.getName()); 
		LOGGER.setLevel(Level.FINEST); 
		
		
		System.out.print(getDigits(1)+"\n");
		System.out.print(getDigits(100)+"\n\n");

		for (int i=1; i< 100000; i++)
		{
			
			System.out.print(i + " "+getDigits(i)+ " "+ convertToNumber(getDigits(i))
								+(i == convertToNumber(getDigits(i)) )+ "\n");
		}

		LOGGER.log(Level.INFO,getDigits(1245566780).toString());

		return 0;
	}
}
