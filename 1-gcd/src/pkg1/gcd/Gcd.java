/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.gcd;

/**
 *
 * @author elias
 */
public class Gcd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       int numbera[] = {1989,2979,3969,4959,5949};
        int numberb[] = {867,735,693,560,438};
        for(int cnt = 0; cnt < 5; cnt+=1)
        {            
            int number1 = gcdPrimeFactors(numbera[cnt],numberb[cnt]);
            int number2 = gcdEucledian(numbera[cnt],numberb[cnt]);
            String temp;
            if (number1 == number2) {
                temp = "gleich";
            }
            else
            {
                temp = "ungleich";
            }
            System.out.println(temp);
        }        
    }
    
    static int gcdPrimeFactors(int a, int b)
    {
        int result = 1;
        int list[] = primecalculator();
        int number1[] = new int[10];
        int temp = 0;
        int help = 0;
        int number = a;
        while(true)
        {           
            if (number == 1) 
            {
                break;
            }
            if (number / list[temp] == 1 && number % list[temp] == 0) 
            {
                number1[help] = list[temp];
                break;
            }
            if (number % list[temp] == 0)
            {
                number1[help] = list[temp];
                help += 1;
                number /= list[temp];
            }
            else
            {
                temp += 1;
            }
        }
        int number2[] = new int[10];
        temp = 0;
        help = 0;
        number = b;
        while(true)
        {           
            if (number == 1) 
            {
                break;
            }
            if (number / list[temp] == 1 && number % list[temp] == 0) 
            {
                number2[help] = list[temp];
                break;
            }
            if (number % list[temp] == 0)
            {
                number2[help] = list[temp];
                help += 1;
                number /= list[temp];
            }
            else
            {
                temp += 1;
            }
        }
        for (int i = 0; i < number1.length; i++) 
        {
            for (int k = 0; i < number2.length; k++) 
            {
                if (number1[i] == number2[k] && number1[i] != 0 && number2[k] != 0)
                {
                    result *= number1[i];
                    number1[i] = 0;
                    number2[k] = 0;
                }
            }
        }
        return result;
    }
   
    static int[] primecalculator()
    {
        int max = 100;
        int maxprim = (int)Math.sqrt(max)+2;
        boolean[] zahlen = new boolean[max];
        for (int i = 0; i < max; i += 1)
        {
            zahlen[i] = (i%2 == 1);
        }

        for (int prim = 3; prim < maxprim; prim += 2)
         if (zahlen[prim])
         {
            for (int i = prim; i <= max / prim; i++) {
            int zahl = i*prim;
            if (zahl < max)
            {
                zahlen[zahl] = false;
            }
         }
      }

      int anzahl = 0;
      for (boolean istPrim : zahlen)
      { 
        if (istPrim)
        {
            anzahl++;
        }
      }
      int[] primzahlen = new int[anzahl];
      int index = 0;
      for (int i = 0; i < zahlen.length; i++)
      {
        if (zahlen[i])
        {    
            primzahlen[index+1] = i;
        }
      }
      primzahlen[0] = 2;
      return primzahlen;
    }
    
    static int gcdEucledian(int a, int b)
    {
        while(b != 0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    
}
