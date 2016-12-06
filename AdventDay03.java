package adventday03;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author patrik
 */
public class AdventDay03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int yes = 0;
        int count = 0;
        String temp = "";
        boolean bol = false;
        
        int a = 0; int b = 0; int c = 0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line = "";
            do{
                line = br.readLine();
                
                for(int i = 0; i < line.length(); i++){     
                    if(line.substring(i, i+1).matches("-?\\d+(\\.\\d+)?")){
                        temp += line.substring(i, i+1);
                        bol = true;
                        if(i == line.length()-1){
                            c = Integer.parseInt(temp);
                            count = 0;
                            temp = "";
                            bol = false;
                        }
                    }else{
                        if(bol){
                            count++;
                            if(count == 1){
                                a = Integer.parseInt(temp);
                                temp = "";
                                bol = false;
                            }
                            if(count == 2){
                                b = Integer.parseInt(temp);
                                temp = "";
                                bol = false;
                            }
                        }                        
                    }
                }
                                
                if(a+b > c && a+c > b && c+b > a)
                    yes++;
            }while(line != null);
        } catch (Exception e) {
        }
        System.out.println(yes);
    }
    
}
