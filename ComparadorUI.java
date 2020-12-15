class ComparadorUI{
    public static void main(String[] args){
        try{
            System.out.println("Init");
            Comparador cmp = new Comparador("02-11-2020 - copia.csv","03-11-2020 - copia.csv","01");
            cmp.writeNewRegisters("NuevosRegistros.csv");
            System.out.println("End");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}