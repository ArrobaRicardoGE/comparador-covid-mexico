import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Comparador{
    public static void main(String args[]){
        HashMap<Integer,String> dictionary = new HashMap<>();
        try{
            CSVReader csv = new CSVReader("test.csv");
            ArrayList<String[]> arr = csv.getContents();
            for(String[] row:arr){
                for(String i:row)
                    System.out.printf("[%s]",i);
                System.out.println();
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}