package adventday06_part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author patrik
 */
public class AdventDay06_part2 {
    static int column = 0;
    static List<String> list = new ArrayList<String>();
    static String c = "";
    static int min=0;
    static String done = "";

    
    public static <T> T lessCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> min = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (min == null || e.getValue() < min.getValue())
                min = e;
        }

        return min.getKey();
    }

    
    public static void loadArr(){
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
                        
            do {                
                line = br.readLine();
                if(line != null){
                    list.add(line.substring(column, column+1));
                    Collections.sort(list);
                }else{
                    done += lessCommon(list);
                    column++;
                    list.clear();
                }
            } while (line != null);
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line = "";
                        
            do {               
                line = br.readLine();
                loadArr();
            } while (line != null);
        } catch (Exception e) {}
        
        System.out.println(done);
    }
    
}
