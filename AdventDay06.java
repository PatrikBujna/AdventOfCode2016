package adventday06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author patrik
 */
public class AdventDay06 {
    static int column = 0;
    static List<String> list = new ArrayList<String>();
    static String c = "";
    static int max=0;
    static String done = "";

    
    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Entry<T, Integer> max = null;

        for (Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
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
                    done += mostCommon(list);
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
