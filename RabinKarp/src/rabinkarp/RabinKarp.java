/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabinkarp;

/**
 *
 * @author luism
 */

public class RabinKarp {
    public final static int d = 256;
    
    static void search(String segment, String text, int q)
    {
        int M = segment.length();
        int N = text.length();
        int i, j;
        int p = 0; 
        int t = 0; 
        int h = 1;
        String modifiedText = text;
  

        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;
  

        for (i = 0; i < M; i++) {
            p = (d * p + segment.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (i = 0; i <= N - M; i++) {
  

            if (p == t) {

                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != segment.charAt(j))
                        break;
                }
  
                if (j == M)
                    modifiedText = modifiedText.subSequence(0, i ) + "" + modifiedText.subSequence(i , (i + M)).toString().toUpperCase() + "" + modifiedText.subSequence((i + M), modifiedText.length());
            }
  

            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;
                
                if (t < 0)
                    t = (t + q);
            }
        }
        System.out.println(modifiedText);
    }
  
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        String txt = "IDE (Integrated Development Environment) is a place where programmers can create their own applications by writing the code. Normally the IDEs come with debuggers and compilers, which makes the work of programmers much easier. It is a single software in which all parts of development are done. In earlier days the IDEs started with terminals and consoles, but later they have changed a lot due to user needs. Nowadays the IDEs are much more developed, they use machine learning to autocomplete our code and also provide suggestions while we are struck or face any issues.";
        String pat = "Normally the IDEs come with debuggers and compilers";
        int q = 101; // A prime number
        search(pat, txt, q);
    }
}