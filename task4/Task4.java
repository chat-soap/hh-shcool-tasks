
public class Task4 {

	
	  public static void main(String []args){
	        System.out.println("Hello World");
	            int trueCounter = 0;
	    for (int r=1;r<10; r++)
	    {
	    	for (int z=0;z<10; z++)
	    	{
	      		for (int u=0;u<10; u++)
	            {
	             	for (int s=0;s<10; s++)
	                {
	                 	for (int x=0;x<10;x++)
	                    {
	                          System.out.print(r+""+z+""+u+
	                        		  			"+"
	                        		  			+r+""+s+""+z+""+x+
	                        		  			"="
	                        		  			+r+""+u+""+z+""+r+"   ");
	                      int a = r*100+z*10+u;
	                      int b = r*1000+s*100+z*10+x;
	                      int c = r*1000+u*100+z*10+r;
	                      if (a+b == c)
	                      {
	                        System.out.println("true");
	                        trueCounter++;
	                      }
	                      else
	                        System.out.println("false");
	                    }
	                }
	            }
	    	}  
	    }
	    System.out.print("total: "+trueCounter);
	        
	        
	        
	     }
	
}
