import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class CSVReader{
    private FileInputStream fis; 
    public CSVReader(String filename) throws FileNotFoundException{
        fis = new FileInputStream(filename);
    }

    public ArrayList<String[]> getContents() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
        String line;
        ArrayList<String[]> contents = new ArrayList<>();
        while((line = br.readLine()) != null)
            contents.add(line.split(","));
        return contents;
    }
}