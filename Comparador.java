import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

class Comparador{
    private HashMap<String,String[]> past, recent; 
    private String[] header = {"FECHA_ACTUALIZACION","ID_REGISTRO","ORIGEN","SECTOR","ENTIDAD_UM","SEXO",
        "ENTIDAD_NAC","ENTIDAD_RES","MUNICIPIO_RES","TIPO_PACIENTE","FECHA_INGRESO","FECHA_SINTOMAS",
        "FECHA_DEF","INTUBADO","NEUMONIA","EDAD","NACIONALIDAD","EMBARAZO","HABLA_LENGUA_INDIG","DIABETES",
        "EPOC","ASMA","INMUSUPR","HIPERTENSION","OTRA_COM","CARDIOVASCULAR","OBESIDAD","RENAL_CRONICA",
        "TABAQUISMO","OTRO_CASO","TOMA_MUESTRA","RESULTADO","MIGRANTE","PAIS_NACIONALIDAD","PAIS_ORIGEN","UCI"};
    
    private HashMap<String,String[]> readContents(String filename, String state) 
    throws IOException, FileNotFoundException{
        System.out.println("Into readContents");
        ArrayList<String[]> reader = CSVManager.read(filename);
        System.out.println("Past read");
        HashMap<String,String[]> dict = new HashMap<>();

        for(String[] row:reader){
            if(row.length < 5)continue;
            if(row[4] == state)
                dict.put(row[4],row);
        }
        
        return dict; 
    }

    public Comparador(String pastFileName, String recentFileName, String state) 
    throws IOException, FileNotFoundException{
        System.out.println("Leyendo archivo 1...");
        past = readContents(pastFileName,state);
        System.out.println("Leyendo archivo 2...");
        recent = readContents(recentFileName,state);
    }

    public void writeNewRegisters(String filename) throws IOException, FileNotFoundException{
        System.out.println("Escribiendo...");
        CSVManager.writeRow(filename,header,true);
        for(String i:recent.keySet()){
            if(!past.containsKey(i)){
                CSVManager.writeRow(filename,recent.get(i),false);
            }
        }
    }

}