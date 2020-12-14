import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;

class CSVReader{
    private FileInputStream fis; 
    public CSVReader(String filename) throws FileNotFoundException{
        fis = new FileInputStream(filename);
    }

    public void getContents(HashMap<Integer,String> dictionary) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
        String line;
        int idx = 0; 
        while((line = br.readLine()) != null)
            dictionary.put(idx++,line);
        
    }
}