import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class rsa{

    /**
     * @param args the command line arguments
     */
     public static boolean primo(int n){   
    if (n<2)   
      return false;
    if (n<=3)  
      return true;
    if (n%2==0)  
      return false;
    for (int i=3;i<n;i=i+2){      
      if ( n%i==0)  
        return false;    
    }
    return true;   
  }
public static double elevazione(double x, int y){
   double z = 1;
   for (int i = 1; i <= y;i++) {

	    z = z * x;
	}

	return z;
}
       
  
    public static void main(String args[]) throws IOException {
  
    Scanner in= new Scanner(System.in);    
      
    int p = 0;
    int q = 0;
    boolean a = true, b = true;
do {
    
   System.out.println("Inserisci due numeri primi il cui prodotto sia maggiore di 25");
    
do {
    
    System.out.println("Inserisci il primo dei due numeri primi");
    p = in.nextInt();}

    while (primo(p) == false);

do {
    
    System.out.println("Inserisci il secondo dei due numeri primi");
    q = in.nextInt();   
}

while (primo(q) == false);

}
while (p * q <= 25);
    
    int fi = (p - 1) * (q - 1);
    int n = 0;   
    int n1 = p * q;
    
    for (int i = 1; b == true; i++) {
         
        n =(fi * i) + 1;
        if (n < 2)   
         b = false;
        if (n<=3)  
         b = true;
        if (n%2==0)  
         b= false;
        for (int j=3;j<n;j=j+2){     
         if (n%j==0)  
          b= false; 
     }
        
    }
    
    int x = 0;
    int y = 0;
    
    System.out.println("Il numero 1 in modulo " + fi + " e' " + n);
    
    for(int i = 2; (i < n) && (n != 1) ; i++) { 
        if(n % i == 0) { 
        x = i; 
                   }              
                                 }
    
    y = n / x;
    
    System.out.println("Chiave pubblica: "+"("+y+","+n1+")"+" Chiave privata: "+"("+x+","+n1+")");
    
    System.out.println("Inserire la parola da codificare");
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int length = tmp.length();
        char c[] = new char[length];
        tmp.getChars(0, length, c, 0);
        CharArrayReader input1 = new CharArrayReader(c);
        
        int i;
        
    char Alfabeto[];
    
    Alfabeto = new char [27];
        
    Alfabeto[0] = 'a';
    Alfabeto[1] = 'b';
    Alfabeto[2] = 'c';
    Alfabeto[3] = 'd';
    Alfabeto[4] = 'e';
    Alfabeto[5] = 'f';
    Alfabeto[6] = 'g';
    Alfabeto[7] = 'h';
    Alfabeto[8] = 'i';
    Alfabeto[9] = 'j';
    Alfabeto[10] = 'k';
    Alfabeto[11] = 'l';
    Alfabeto[12] = 'm';
    Alfabeto[13] = 'n';
    Alfabeto[14] = 'o';
    Alfabeto[15] = 'p';
    Alfabeto[16] = 'q';
    Alfabeto[17] = 'r';
    Alfabeto[18] = 's';
    Alfabeto[19] = 't';
    Alfabeto[20] = 'u';
    Alfabeto[21] = 'v';
    Alfabeto[22] = 'w';
    Alfabeto[23] = 'x';
    Alfabeto[24] = 'y';
    Alfabeto[25] = 'z';
    Alfabeto[26] = ' ';      
        
    double t = 0;
    int j = 0;
        
    double cod[];
    cod=new double[c.length];
   
  
  
  for (j = 0; j < c.length; j++) {  
      for (i = 0; i < Alfabeto.length; i++) {
           if (c[j] == Alfabeto[i])
            t = i + 1;
       }
        
      t = elevazione (t,y);
      
      do {
          if((t != 1) && (t > n1))
          t = t - n1;
      }
      while(t >= n1);
      
              
      cod[j] = t;
       
   }  
      System.out.println("Il codice e': "+Arrays.toString(cod));
       
    } }