public class task1{

     public static void main(String []args){
        System.out.println("Hello World");
            int trueCounter = 0;
    for (int r=0;r<10; r++)
    {
    	for (int s=0;s<10; s++)
    	{
      		for (int u=0;u<10; u++)
            {
             	for (int v=0;v<10; v++)
                {
                 	for (int w=0;w<10; w++)
                    {
                          System.out.print(r+""+r+""+s+""+u+"+"+u+""+u+""+s+"="+r+""+v+""+w+""+w+"   ");
                      int a = r*1000+r*100+s*10+u;
                      int b = u*100+u*10+s;
                      int c = r*1000+v*100+w*10+w;
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

