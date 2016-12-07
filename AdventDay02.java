package adventday02;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author patrik
 */
public class AdventDay02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("map.txt"));
            BufferedReader move = new BufferedReader(new FileReader("input.txt"));
            String line = "";
            String direction = "";
            int num = 5;
            String done = "";
            
            do {         
                line = move.readLine();
                for(int i = 0; i < line.length(); i++){
                    direction = line.substring(i, i+1);
                    
                    if(direction.equals("R") && num != 3 && num != 6 && num != 9)  
                        num++;
                    if(direction.equals("L") && num != 1 && num != 4 && num != 7)
                        num--;
                    if(direction.equals("D") && num < 7)
                        num += 3;
                    if(direction.equals("U") && num > 3)
                        num -= 3;
                }               
                
                done += Integer.toString(num);
                System.out.println(done);
            } while (line != null);     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
