

import java.awt.print.Book;
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
	
	
	public Boolean isSplendidNumber(Vector<Long> numberToCheck)
	{
		Vector<Boolean> digitUsed = new Vector<Boolean>(numberToCheck.size());
		for (int i = 0; i < numberToCheck.size(); i++)
		{
			digitUsed.add(false);
		}

		ListIterator<Long> left = numberToCheck.listIterator();
		while(left.hasNext())
		{
			int indexOfCurrentPosition = left.nextIndex();
			long digitInCurrentPosition = left.next();
			
			
			//check if there is sequence that gives summ of 10 from current position
			long summAtSubPosition = 0;
			ListIterator<Long> subLeft = numberToCheck.listIterator(indexOfCurrentPosition);
			while ( subLeft.hasNext() )
			{
				int indexOfSubPosition = subLeft.nextIndex();
				summAtSubPosition += subLeft.next();
				if (summAtSubPosition < 10)
				{
					continue;
				}
				else if (summAtSubPosition == 10)
				{
					//there is this kind of sequence. Mark every digit thata it's used
					for (int i = indexOfCurrentPosition; i <= indexOfSubPosition; i++)
					{
						digitUsed.set(i, true);
						System.out.print(numberToCheck.get(i));
					}
					System.out.print(";");
				}
				else if (summAtSubPosition > 10)
				{
					break;
				}
			}

		}
		
		for (Boolean boolean1 : digitUsed) {
			if (boolean1 == false)
			{
				//at least one digit not used;
				return false;
			}
		}
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

		long splendidNumbersAmount = 0;
		for (long i=19; i< 6100000; i++)
		{
			Vector<Long> splendidNumberCandidate = new Vector<Long>();
			System.out.print("\t"+i+":");
			splendidNumberCandidate = getDigits(i);
			System.out.print(splendidNumberCandidate+":");
			if (isSplendidNumber(splendidNumberCandidate))
			{
				splendidNumbersAmount ++;
				System.out.print( "splendid" );
			}
			System.out.print("; \n");
			
			
		}
		System.out.print("\n"+splendidNumbersAmount+"\n size:"+splendidNumbersAmount);
	

		return 0;
	}
}
