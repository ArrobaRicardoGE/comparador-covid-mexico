# Comparador COVID19 México
## Herramienta para comparar fácilmente la cantidad de casos y decesos de COVID19 de dos fechas distintas
Esta herramienta tiene como propósito obtener los casos y decesos ocurridos entre dos fechas especificadas a causa de COVID19. La información es obtenida directamente de los [Datos Abiertos de la Dirección General de Epidemiología del Gobierno de México](https://www.gob.mx/salud/documentos/datos-abiertos-152127), y es una alternativa a realizar el proceso de forma manual (tarea que no es simple, puesto que la base de datos cuenta con más de tres millones de registros, lo que excede la capacidad de programas comúnes como Excel).

Esta herramienta está disponible en Google Colab. Para acceder a ella, haz click [aquí](https://colab.research.google.com/drive/1ZZArwF3-emBs-PCSs8eO7zyCcwT153Nl?usp=sharing). Para utilizarla se tiene que contar con una cuenta de Google.

Utilizar la herramienta es bastante simple:
- Llenar los datos del formulario a continuación. Se puede presionar el ícono del calendario para hacerlo de forma más sencilla. Hay que tomar en cuenta que las fechas están en formato año/mes/día. De igual manera, la base de datos se actualiza cada día al rededor de las 20:00, hora de la CDMX. Si se ingresa una fecha que aún no está disponible, el comparador tomará la  el último registro disponible.
- Presionar el ícono de "reproducir" que está del lado izquierdo. El proceso puede tomar unos minutos puesto que tiene que descargar la información de la base de datos. 
- Cuando el proceso anterior ha terminado, hay que reproducir las celdas de la sección **Resultados del comparador**. Si se quiere descargar las tablas producidas, se tiene que reproducir la última celda.

Para dudas o comentarios, estoy en Twitter como [@ArrobaRicardoGE](https://twitter.com/ArrobaRicardoGE). 

Este proyecto es de código abierto, estoy abierto a pull requests. Cabe destacar que no soy un experto en el manejo de pandas, por lo que las sugerencias son siempre apreciadas. 
