
import java.util.ListIterator;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.ReverbType;


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
	
	
	public Boolean isPalyndrome(Vector<Long> numberToCheck)
	{
		ListIterator<Long> left = numberToCheck.listIterator();
		ListIterator<Long> right = numberToCheck.listIterator(numberToCheck.size());
		
		while (left.nextIndex() < right.previousIndex() )
		{
			if ( left.next() != right.previous() )
			{
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
	
	long convertToNumber(Vector<Long> numberToConvert)
	{
		long answer = 0;
		ListIterator<Long> right = numberToConvert.listIterator(numberToConvert.size());
		long currentPositionWeight = 1;
		while(right.hasPrevious())
		{
			answer += right.previous() * currentPositionWeight;
			currentPositionWeight *= 10;
		}
		
		return answer;
		
	}
	
	
	Vector<Long> add(Vector<Long> leftNumberToAdd, Vector<Long> rightNumberToAdd )
	{
		Vector<Long> answerReversed = new Vector<Long>();
		long carry = 0;
		ListIterator<Long> left = leftNumberToAdd.listIterator(leftNumberToAdd.size());
		ListIterator<Long> right = rightNumberToAdd.listIterator(rightNumberToAdd.size());
		
		while (left.hasPrevious() || right.hasPrevious() || carry != 0)
		{
			long leftNumberInPosition = 0;
			if(left.hasPrevious())
			{
				leftNumberInPosition = left.previous();
			}
			
			long rightNumberInPosition = 0;
			if( right.hasPrevious())
			{
				 rightNumberInPosition =  right.previous();
			}
			
			long summInPosition = leftNumberInPosition + rightNumberInPosition + carry;
			carry = 0;
			
			if (summInPosition > 9)
			{
				summInPosition = summInPosition % 10;
				carry = 1;
			}
			answerReversed.add(summInPosition);
		}
		
		
		return rotate(answerReversed);
		
	}
	
	
	long calculate()
	{
		final Logger LOGGER = Logger.getLogger(CalculatingClass.class.getName()); 
		LOGGER.setLevel(Level.FINEST); 
		
		
		System.out.print(getDigits(1)+"\n");
		System.out.print(getDigits(100)+"\n\n");

		Vector<Long> hardlyConvertibe = new Vector<Long>();
		
		long timesRepeated =0;
		outerFor:
		for (long i=1; i< 12407; i++)
		{
			System.out.print("\n start new number:" +i+": ");
			timesRepeated=0;
			Vector<Long> processingNumber = getDigits(i);
			do
			{	
				timesRepeated++;
				System.out.print("\t" +timesRepeated+": "+processingNumber);
				Vector<Long> mirroredNumber = rotate(processingNumber);
				System.out.print(" "+mirroredNumber);
				processingNumber = add(processingNumber, mirroredNumber);
				System.out.print(" "+processingNumber);
				System.out.print(" "+isPalyndrome(processingNumber)+";\n");
				if(isPalyndrome(processingNumber))
				{
					continue outerFor;
				}
			}
			while
				(timesRepeated < 50)
				;
			// after 50 attempts there were no one palyndrome
			hardlyConvertibe.add(i);
				
		}
		System.out.print("\n"+hardlyConvertibe+"\n size:"+hardlyConvertibe.size());
		LOGGER.log(Level.INFO,getDigits(1245566780).toString());

		return 0;
	}
}
