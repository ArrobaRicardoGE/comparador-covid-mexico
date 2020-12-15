import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Comparador{
    public static void main(String args[]){
        HashMap<Integer,String> dictionary = new HashMap<>();
        try{
            ArrayList<String[]> arr = CSVManager.read("test.csv");
            CSVManager.clearFile("outputTest.csv");
            for(String[] row:arr){
                CSVManager.writeRow("outputTest.csv",row);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}