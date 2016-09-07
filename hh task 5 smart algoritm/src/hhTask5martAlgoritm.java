//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************
import java.util.*;
import java.util.TreeMap;


// one class needs to have a main() method
public class hhTask5martAlgoritm
{
  
  
  // (m! mod n) == 0
 static boolean IsModuloDivisorOfFactorial( int n, int m )
  {
 
	 Map<Integer,Integer>  mapForFactorizedNumber  = new  TreeMap <Integer,Integer> ();
	 for (int i=2; i<=m; i++)
	 {
		 Map<Integer,Integer> mapForI = getPrimeMultipliers(i);
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
	//	 System.out.println("factorialized  = "+mapForFactorizedNumber);		 
	 }// here we have all multipliers of factorial
	 
	 //now check if there is more each of multiplliers in factorized number than in n
	 Map<Integer,Integer>  mapForN  = new  TreeMap <Integer,Integer> ();
	 mapForN = getPrimeMultipliers(n);
	 
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
  
 
 static Map.Entry<Integer,Integer>  getBiggestKey( Map<Integer,Integer> mapToGetBiggestElementFrom)
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
    Map<Integer,Integer> constituteMultiplier = getPrimeMultipliers(n);
    System.out.print("constitueMulitplier: " +constituteMultiplier);
    int biggestPrimeNumberInModuloDivisor = getBiggestKey(constituteMultiplier).getKey();
    System.out.print("biggest prime = "+biggestPrimeNumberInModuloDivisor);
    
    for (int i = biggestPrimeNumberInModuloDivisor; i<= n; i++)
    {
    	System.out.println("c"+i);
    	if(IsModuloDivisorOfFactorial(n, i))
    	{
    		return i;
    	}
    }
    
       return n;    
  }
  
  
  //all numbers in result are prime
static  Map<Integer,Integer> getPrimeMultipliers(int n)
  {
      Map<Integer,Integer>  result  = new  TreeMap <Integer,Integer> ();
  
      int nForCutting = n;
      
      while (nForCutting > 1)
    {
      for (int i=2; i<=nForCutting; i++)
      {
        if ( (nForCutting % i) == 0 )
        {
          nForCutting = nForCutting / i;
        //  System.out.print(i + "  ");
          if(result.containsKey(i))
          {
        	result.put( i, result.get( i ) + 1 ) ;
          }
          else
          {
        	  result.put(i, 1);
          }
          break;
        }
      }
       
    }
          
    
    return result;

  }
    
  
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
   
    
    int start = Integer.parseInt(args[0]);
    int end = Integer.parseInt(args[1]);
    int summOfN = 0;
    for (int i=start; i <= end; i++)
    {
    	System.out.print(i+": ");
    	int factorialBase = getFactorialBaseForModuloDivisor(i);
    	System.out.println("\t \t The answer is: " + factorialBase );
    	summOfN+=factorialBase;
    }
    System.out.println("\t \t The summary answer is: " + summOfN );
    
  }
  
  
}

