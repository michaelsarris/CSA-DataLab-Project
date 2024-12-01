import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //System.out.println("hello world");
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("colours_rgb_shades.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        System.out.println(records.get(1));
        System.out.println(records.get(1).get(1));
        System.out.println(records.get(1).get(2));
        System.out.println(records.get(1).get(3));
/* 
        for(int i =0;i<records.size();i++){
            System.out.println(records.get(i));
        }
*/
    }
}