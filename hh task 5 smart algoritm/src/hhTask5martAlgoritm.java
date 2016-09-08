//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************
import java.util.*;
import java.math.BigInteger;

// one class needs to have a main() method
public class hhTask5martAlgoritm
{
  
	static TreeMap<Integer,Integer> first100NumbersFactorized;
	static TreeMap<Integer, TreeMap<Integer,Integer>> factorialsCache;
	
	static boolean FactorialAlreadyCouldBeDividedWithoutRemainder(  TreeMap<Integer,Integer>  mapForFactorizedNumber 
																	, TreeMap<Integer,Integer>  mapForN)
	{
		for( Map.Entry<Integer,Integer> entry: mapForN.entrySet()  )
		 {
			 int key = entry.getKey();
			 int value = entry.getValue();
			 if(mapForFactorizedNumber.containsKey(key) == false) // there is no at least one prime multiplier of n in factorial number 
			 {
				 return false;
			 }
			 if( mapForFactorizedNumber.get(key) < value ) // there is no enough current prime numbers in factorial
			 {
				 return false;
			 }
		 }
		
		 return true;
	
	}
  
  // (m! mod n) == 0
 static boolean IsModuloDivisorOfFactorial( int n, int m )
  {
	 TreeMap<Integer,Integer>  mapForN  = new  TreeMap <Integer,Integer> ();
	 mapForN = getPrimeMultipliers(n);
 
	 int lowestNumber = 2;
	 TreeMap<Integer,Integer>  mapForFactorizedNumber  = new  TreeMap <Integer,Integer> ();
	 if (m > 200)
	 {
		 mapForFactorizedNumber = new TreeMap <Integer,Integer> (first100NumbersFactorized);
		 lowestNumber = 101;
	 }
	 for (int i=m; i>= lowestNumber ; i--)
	 {
		 TreeMap<Integer,Integer> mapForI = getPrimeMultipliers(i);
		 //merging maps
		 for(Map.Entry<Integer,Integer> entry: mapForI.entrySet())
		 {
			 if(mapForFactorizedNumber.containsKey(entry.getKey() ) )
			 {
				 int key = entry.getKey();
				 int value = entry.getValue();
				 int valueInFactorizedNumber = mapForFactorizedNumber.get(key);
				 mapForFactorizedNumber.put(key, value + valueInFactorizedNumber);
			 }
			 else
			 {
				 int key = entry.getKey();
				 int value = entry.getValue();
				 mapForFactorizedNumber.put(key, value );
			 }
		 }
		 //after multiplying by every new number, check, if it's enought
		if( FactorialAlreadyCouldBeDividedWithoutRemainder(mapForFactorizedNumber, mapForN) )
		{
			return true;
		}
		
		System.out.print(" f" +i); 
	 }// here we have all multipliers of factorial
	 
//if we get here, it means we tried full factorial, but it couldn't be divided by n without remainder
	 return false;
  }
  
 
 static Map.Entry<Integer,Integer>  getEntryWithBiggestKey( TreeMap<Integer,Integer> mapToGetBiggestElementFrom)
 {
	 Map.Entry<Integer,Integer> biggestElement = null;
	 for(Map.Entry<Integer,Integer> entry: mapToGetBiggestElementFrom.entrySet())
	 {
		 if(biggestElement == null)
		 {
			 biggestElement = entry;
		 }
		 else if (biggestElement.getKey() < entry.getKey())
		 {
			 biggestElement = entry;
		 }

	 }
	 return biggestElement;
 }
 
  //get m for given n
 static  int getFactorialBaseForModuloDivisor( int n)
  {
	 TreeMap<Integer,Integer> constituteMultiplier = getPrimeMultipliers(n);
    System.out.print("constitueMulitplier: " +constituteMultiplier);
    
    Map.Entry<Integer,Integer> entry = getEntryWithBiggestKey(constituteMultiplier);
    int key = entry.getKey();
	int value = entry.getValue();
    
    int biggestPrimeNumberInModuloDivisor = key;
    int biggestPrimeNumberInModuloDivisorMultipliedByOccurTimes = biggestPrimeNumberInModuloDivisor ;
    // multiply only if occurrences less than value of key; or you'll have bugs with 81 and 9!    (you get 12(wrong) instead of 9(correct)
    if (value < key){
    	biggestPrimeNumberInModuloDivisorMultipliedByOccurTimes*= value;
    	 System.out.print("multiplied by" + value);
    }
    else
    {
    	System.out.println("scip Multiplication" + value);
    }
    
    System.out.print("biggest prime = "+key);
    System.out.print(" biggest prime*n = "+biggestPrimeNumberInModuloDivisorMultipliedByOccurTimes);
    
    for (int i = biggestPrimeNumberInModuloDivisorMultipliedByOccurTimes; i<= n; i++)
    {
    	System.out.print("\n\tc"+i);
    	if(IsModuloDivisorOfFactorial(n, i))
    	{
    		return i;
    	}
    }
    
       return n;    
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
	  
	  
	 //initing 
	  TreeMap<Integer,Integer>  mapForFactorizedNumber  = new  TreeMap <Integer,Integer> ();
	  for (int i=2; i<=100; i++)
		 {
			 TreeMap<Integer,Integer> mapForI = getPrimeMultipliers(i);
			 //merging maps
			 for(Map.Entry<Integer,Integer> entry: mapForI.entrySet())
			 {
				 if(mapForFactorizedNumber.containsKey(entry.getKey() ) )
				 {
					 int key = entry.getKey();
					 int value = entry.getValue();
					 int valueInFactorizedNumber = mapForFactorizedNumber.get(key);
					 mapForFactorizedNumber.put(key, value + valueInFactorizedNumber);
				 }
				 else
				 {
					 int key = entry.getKey();
					 int value = entry.getValue();
					 mapForFactorizedNumber.put(key, value );
				 }
			 }
		 }
	  first100NumbersFactorized = mapForFactorizedNumber;
	  
	  //end initing
	  
	  
   
    
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

