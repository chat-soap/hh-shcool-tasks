import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.event.TreeSelectionEvent;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class SumOfPrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		calculateAmount h = new calculateAmount();
		h.Calculate(Integer.parseInt((args[0]))); 
		
	}

}
class calculateAmount
{
	
	boolean isPrime(int numberToCheck)
	{
		for (int i =2; i<numberToCheck; i++)
		{
			if (numberToCheck % i == 0)
				return false;
		}
		return true;
	}
	
	
	int Calculate(int maxNumber)
	{
	
		TreeSet<Integer> primeNumbers = new TreeSet<Integer>();
		 
		//reverse order to check,if set is sorted;
		for (int i=maxNumber; i>=2; i--)
		{
			if (isPrime(i))
			{
				primeNumbers.add(i);
			}
		}
		
		System.out.print(" primes (for k=1): " );	
		for(int i : primeNumbers)
		{
			System.out.print(" "+i );	
		}
		
		System.out.println(" \n now calculation" );
		TreeSet<Integer>oldSummOfPrimeNumbers = primeNumbers;
		TreeSet<Integer>newSummOfPrimeNumbers = new TreeSet<Integer>();
		int amount = primeNumbers.size(); // for k=1
		
		for (int level=2; level <= maxNumber; level++)
		{
			System.out.print("level "+level+":" );
			
			outer:
			for(int outerPrime: oldSummOfPrimeNumbers)
			{
				for (int innerPrime: primeNumbers)
				{
					int summ = outerPrime + innerPrime;
					if ( summ > maxNumber)
					{
						//futher inner primes will be only greater
						continue outer;
					}
					else
					{
						if (newSummOfPrimeNumbers.contains(summ))
						{
						//	System.out.print(" dup:"+outerPrime+"+"+innerPrime+"="+summ );
						}
						else
						{
							newSummOfPrimeNumbers.add(summ);
						//	System.out.print(" "+outerPrime+"+"+innerPrime+"="+summ );
						}
						
					}
				}
			}
			System.out.println("\n at this level was "+newSummOfPrimeNumbers.size() );
			amount +=newSummOfPrimeNumbers.size();
			
			oldSummOfPrimeNumbers = newSummOfPrimeNumbers;
			newSummOfPrimeNumbers = new TreeSet<Integer>();
			
		}
		

		System.out.print("\nTotal answer "+amount + '\n');	
				
		
		
		return 0;
	}
}