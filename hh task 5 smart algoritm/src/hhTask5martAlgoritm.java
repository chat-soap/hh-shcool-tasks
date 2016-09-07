//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************
import java.util.*;


// one class needs to have a main() method
public class hhTask5martAlgoritm
{
  
	static TreeMap<Integer,Integer> first100NumbersFactorized;
	
	static boolean FactorialAlreadyCouldBeDividedWithotRemainder(  TreeMap<Integer,Integer>  mapForFactorizedNumber 
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
 
	 TreeMap<Integer,Integer>  mapForFactorizedNumber  = new  TreeMap <Integer,Integer> ();
//	 if (m > 200)
//	 {
//		 mapForFactorizedNumber = new TreeMap <Integer,Integer> (first100NumbersFactorized);
//	 }
	 for (int i=m; i>=2; i--)
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
		 //after multiplyint by every new number, check, if it's enought
		if( FactorialAlreadyCouldBeDividedWithotRemainder(mapForFactorizedNumber, mapForN) )
		{
			return true;
		}
		
		//System.out.print(" f" +i); 
	 }// here we have all multipliers of factorial
	 
//if we get here, it means we tried full factorial, but it couldn't be divided by n without remainder
	 return false;
  }
  
 
 static Map.Entry<Integer,Integer>  getBiggestKey( TreeMap<Integer,Integer> mapToGetBiggestElementFrom)
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
    int biggestPrimeNumberInModuloDivisor = getBiggestKey(constituteMultiplier).getKey();
    System.out.print("biggest prime = "+biggestPrimeNumberInModuloDivisor);
    
    for (int i = biggestPrimeNumberInModuloDivisor; i<= n; i++)
    {
    	//System.out.print("\n\tc"+i);
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
	  for (int i=2; i<100; i++)
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
    int summOfN = 0;
    for (int i=start; i <= end; i++)
    {
    	System.out.print(i+": ");
    	int factorialBase = getFactorialBaseForModuloDivisor(i);
    	System.out.println("\n \t \t The answer for " + i + "  is: " + factorialBase );
    	summOfN+=factorialBase;
    }
    System.out.println("\t \t The summary answer is: " + summOfN );
    
  }
  
  
}

