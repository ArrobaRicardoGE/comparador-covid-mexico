def read_csv(filename,state):
    dictionary = {}
    with open(filename, encoding='ISO-8859-1') as f:
        reader = csv.reader(f, skipinitialspace=True, quotechar='"')
        flag = False
        for row in reader:
            if(row[4] == state):
                dictionary[row[1]] = row
    return dictionary
 
def write_new_deaths(filename,recent,past,directory = 'csv/in_process/'):
    past_registers = []
    recent_registers = []
    for i in recent:
        if recent[i][12] != '9999-99-99' and (not i in past  or past[i][12] == '9999-99-99'):
            if not i in past:
                past_registers.append(['Registro no existente'])
            else: 
                past_registers.append(past[i])
            recent_registers.append(recent[i])
    with open(directory + filename, mode='w',newline='')as f:
        writer = csv.writer(f, skipinitialspace=True, quotechar='"', quoting=csv.QUOTE_NONNUMERIC)
        writer.writerow(["FECHA_ACTUALIZACION","ID_REGISTRO","ORIGEN","SECTOR","ENTIDAD_UM","SEXO","ENTIDAD_NAC","ENTIDAD_RES","MUNICIPIO_RES","TIPO_PACIENTE","FECHA_INGRESO","FECHA_SINTOMAS","FECHA_DEF","INTUBADO","NEUMONIA","EDAD","NACIONALIDAD","EMBARAZO","HABLA_LENGUA_INDIG","DIABETES","EPOC","ASMA","INMUSUPR","HIPERTENSION","OTRA_COM","CARDIOVASCULAR","OBESIDAD","RENAL_CRONICA","TABAQUISMO","OTRO_CASO","TOMA_MUESTRA","RESULTADO","MIGRANTE","PAIS_NACIONALIDAD","PAIS_ORIGEN","UCI"])
        writer.writerow(['Registros anteriores'])
        for i in past_registers:
            writer.writerow(i)
        writer.writerow(['Registros recientes'])
        for i in recent_registers:
            writer.writerow(i)

def write_new_registers(filename, recent, past, directory = 'csv/in_process/'):
    with open(directory + filename, mode ='w', newline='') as f:
        writer = csv.writer(f, skipinitialspace=True, quotechar='"', quoting=csv.QUOTE_NONNUMERIC)
        writer.writerow(["FECHA_ACTUALIZACION","ID_REGISTRO","ORIGEN","SECTOR","ENTIDAD_UM","SEXO","ENTIDAD_NAC","ENTIDAD_RES","MUNICIPIO_RES","TIPO_PACIENTE","FECHA_INGRESO","FECHA_SINTOMAS","FECHA_DEF","INTUBADO","NEUMONIA","EDAD","NACIONALIDAD","EMBARAZO","HABLA_LENGUA_INDIG","DIABETES","EPOC","ASMA","INMUSUPR","HIPERTENSION","OTRA_COM","CARDIOVASCULAR","OBESIDAD","RENAL_CRONICA","TABAQUISMO","OTRO_CASO","TOMA_MUESTRA","RESULTADO","MIGRANTE","PAIS_NACIONALIDAD","PAIS_ORIGEN","UCI"])
        for i in recent:
            if not i in past:
                writer.writerow(recent[i])