import java.util.HashMap;
import java.util.Map;

class Comparador{
    public static void main(String args[]){
        HashMap<Integer,String> dictionary = new HashMap<>();
        try{
            CSVReader csv = new CSVReader("README.md");
            csv.getContents(dictionary);
            for(Map.Entry<Integer,String> element:dictionary.entrySet()){
                System.out.printf("Entry %d: %s\n",element.getKey(), element.getValue());
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}