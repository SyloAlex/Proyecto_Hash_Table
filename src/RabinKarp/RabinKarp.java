/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RabinKarp;

import javax.swing.JOptionPane;

/**
 *
 * @author luism
 */
public class RabinKarp {
    public final static int d = 256;
    
    static String search(String segment, String text, int q)
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
        return modifiedText;
    }
    
    public String rabinKarp(String text, String segment)
    {
        int q = 101; 
        return search(segment, text, q);
        
    }
}
