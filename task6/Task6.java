
package task6;
import java.util.ListIterator;

import java.util.Vector;



public class Task6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CalculatingClass c = new CalculatingClass();
		c.calculate();

		
	}

}



class CalculatingClass
{
	
	
	public Boolean isGoodNumber(Vector<Long> numberToCheck)
	{
		ListIterator<Long> left = numberToCheck.listIterator();
		return true;
	}



	public Vector<Long> rotate( Vector<Long> numberToProcess )
	{
		Vector<Long> answer = new Vector<Long>();
		ListIterator<Long> right = numberToProcess.listIterator(numberToProcess.size());
		{
			while (right.hasPrevious())
			{
				answer.add(right.previous());
			}
		}
		
		return answer;
	}
	
	
	Vector<Long> getDigits(long numberToParse)
	{
		Vector<Long> answerReversed = new Vector<Long>();
		
		while (numberToParse > 0)
		{
			long remainder = numberToParse % 10;
			numberToParse = numberToParse / 10;
			
			answerReversed.add(remainder);
		}
		//order was reversed. Reverse it back

		Vector<Long> answer = rotate(answerReversed);
		return answer ;
	}

	
	
	
	
	
	long calculate()
	{
		
		System.out.print(getDigits(1)+"\n");
		System.out.print(getDigits(100)+"\n\n");

	
		for (long i=1; i< 12407; i++)
		{
			Vector<Long> goodNumberCandidate = new Vector<Long>();
			
		}
		System.out.print("\n"+hardlyConvertibe+"\n size:"+hardlyConvertibe.size());
	

		return 0;
	}
}
