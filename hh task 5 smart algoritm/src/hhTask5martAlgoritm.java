//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************
import java.util.*;
import java.math.BigInteger;

// one class needs to have a main() method
public class hhTask5martAlgoritm
{
  
  //get m for given n
 static  int getFactorialBaseForModuloDivisor( int n)
  {
	 TreeMap<Integer,Integer> constituteMultiplier = getPrimeMultipliers(n);
    System.out.print("constitueMulitplier: " +constituteMultiplier);
    
    //be aware of powers ( 9! incluldes 3 six times (9, 6, 3*3) , not 3 as you can suggest
    int biggestPrimeNumberInModuloDivisorMultipliedByOccurTimes = 0;
    
    for(Map.Entry<Integer,Integer> entry: constituteMultiplier.entrySet())
    {
    	int key = entry.getKey();
		int amountKeyShouldBeInFactorial = entry.getValue();
		int keyTimesCounterValue = 0;
		int keyInFactorialAmountCounter = 0;
		//outer loop for powers
			for (int powerCounter = 1; keyInFactorialAmountCounter < amountKeyShouldBeInFactorial; powerCounter ++ )
			{
				//for every power (power 1 too) add only "key" to value, but "power" to counter
				// check for 81 and 3; value				3	6	9	12	15	18		21	24	3*3*3
				//											3	3*2	3*3	3*4	3*5	3*3*2	3*7	3*8	3*3*3
				//						timesInFactorial 	1	2	4	5	6	7		8	9	12
				keyInFactorialAmountCounter += powerCounter;
				keyTimesCounterValue += key ;
				
				//inner usual addition
				//if we multiplied key times - we reached power
				for (int timesKeyWasAdded = 0; timesKeyWasAdded 		< 	key  &&
													keyInFactorialAmountCounter	<	amountKeyShouldBeInFactorial; timesKeyWasAdded ++) 
				{
					keyInFactorialAmountCounter += 1;
					keyTimesCounterValue += key;
				}
			}
		System.out.print("\n\tfor key "+key+"thoHave "+amountKeyShouldBeInFactorial
							+"times used "+keyTimesCounterValue+"which gives "+keyInFactorialAmountCounter);
		
		if (biggestPrimeNumberInModuloDivisorMultipliedByOccurTimes < keyTimesCounterValue)
		{
			biggestPrimeNumberInModuloDivisorMultipliedByOccurTimes = keyTimesCounterValue;
		}
    }
    
    return biggestPrimeNumberInModuloDivisorMultipliedByOccurTimes;
 
  }
  
  
  //all numbers in result are prime
static  TreeMap<Integer,Integer> getPrimeMultipliers(int n)
  {
	TreeMap<Integer,Integer>  result  = new  TreeMap <Integer,Integer> ();
  
      int nForCutting = n;
      
      outerWhile:
      while (nForCutting > 1)
    {
      for (int i=2; i<=Math.ceil( Math.sqrt(nForCutting) ); i++)
      {
        if ( (nForCutting % i) == 0 )
        {
          nForCutting = nForCutting / i;
          if(result.containsKey(i))
          {
        	result.put( i, result.get( i ) + 1 ) ;
          }
          else
          {
        	  result.put(i, 1);
          }
          continue outerWhile;
        }
      }
      //if we reached here - nForCutting is prime
      
      if(result.containsKey(nForCutting))
      {
    	result.put( nForCutting, result.get( nForCutting ) + 1 ) ;
      }
      else
      {
    	  result.put(nForCutting, 1);
      }
      nForCutting = nForCutting / nForCutting;
    }
          
    
    return result;

  }
    
  
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
	  
	int start = Integer.parseInt(args[0]);
    int end = Integer.parseInt(args[1]);
    BigInteger summOfN = BigInteger.valueOf(0);
    for (int i=start; i <= end; i++)
    {
    	System.out.print(i+": ");
    	int factorialBase = getFactorialBaseForModuloDivisor(i);
    	System.out.println("\n \t \t The answer for " + i + "  is: " + factorialBase );
    	summOfN = summOfN.add(BigInteger.valueOf(factorialBase));
    }
    System.out.println("\t \t The summary answer is: " + summOfN );
    
  }
  
  
}

