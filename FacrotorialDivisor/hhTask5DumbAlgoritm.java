//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************


import java.math.BigInteger;

// one class needs to have a main() method
public class hhTask5DumbAlgoritm
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {

    System.out.println("oh lol"+args[0]+args[1]);
    BigInteger summ_of_divisors = new BigInteger ("0");

int start = Integer.parseInt(args[0]);
int end = Integer.parseInt(args[1]);

   for (int i=start; i <= end; i++)
    {
        System.out.print(i+": ");
        BigInteger cumulative_factorial= new BigInteger("1");
        for (int j=1; j <= i; j++)
        {
            cumulative_factorial = cumulative_factorial.multiply(BigInteger.valueOf(j) );
                BigInteger moduloRemainer =  cumulative_factorial.mod(BigInteger.valueOf(i) ) ;
                if ( moduloRemainer.compareTo(BigInteger.ZERO) == 0 )
                {
         //     System.out.println(j+ " j!=" + cumulative_factorial);
              System.out.println(j);
                summ_of_divisors = summ_of_divisors.add(BigInteger.valueOf(j));
              break;
            }

        }
    }
    System.out.println("\t The answer is: " + summ_of_divisors);
  }
}

