/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package programmingclub;

import java.util.ArrayList;

/**
 *
 * @author chapo
 */
public class NumberGame {
    
    public static void main(String[] args){
        
        String moves = args[0];
        ArrayList<Integer> ints = new ArrayList<Integer>();
        int score = 0;
        String p1moves = "";
        for(int i = 1; i < args.length; i++){
            ints.add(Integer.parseInt(args[i]));
        }
        
        
            for(int i = 0; i < moves.length(); i++){
              if(moves.charAt(i) == 'B'){
                if(ints.get(1) > ints.get(0)){
                  
                  score = score + ints.get(ints.size() - 1);
                    ints.remove(ints.get(ints.size() - 1));
                    p1moves = p1moves + "E";
                }
                else{
                  score = score + ints.get(0);
                    ints.remove(0);
                    p1moves = p1moves + "B";
                }
                ints.remove(0);
              }
              else{
                if(ints.size() > 2){
                if(ints.get(ints.size() - 2) > ints.get(ints.size() - 1)){
                  score = score + ints.get(0);
                    ints.remove(0);
                    p1moves = p1moves + "B";
                }
                else{
                  score = score + ints.get(ints.size() - 1);
                    ints.remove(ints.size() - 1);
                    p1moves = p1moves + "E";
                }
                ints.remove(ints.get(ints.size() - 1));
              }
                else{
                  
                if(ints.get(ints.size() - 1) > ints.get(0)){
                  score = score + ints.get(ints.size() - 1);
                    ints.remove(ints.size() - 1);
                    p1moves = p1moves + "E";
                }
                else{
                  score = score + ints.get(0);
                    ints.remove(0);
                    p1moves = p1moves + "B";
                }
                }
                
              }
              
                
                    
            
        }
        System.out.println(p1moves + " " + score);
    }
    
}
