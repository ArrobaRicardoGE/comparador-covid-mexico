import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class CSVManager{
    public static ArrayList<String[]> read(String filename) throws IOException, FileNotFoundException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"utf-8"));
        String line;
        ArrayList<String[]> contents = new ArrayList<>();
        while((line = br.readLine()) != null)
            contents.add(line.split(","));
        br.close();
        return contents;
    }
    public static void clearFile(String filename) throws IOException, FileNotFoundException{
        FileOutputStream clear = new FileOutputStream(filename);
        clear.close();
    }
    public static void writeRow(String filename,String[] row) throws IOException, FileNotFoundException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(filename,true),"utf-8"));
        boolean first = true;
        for(String element:row){
            if(!first)
                bw.write(",");
            else
                first = false;
            bw.write(element);
        }
        bw.write('\n');
        bw.close();
    }
}