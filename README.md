# Proyecto 2: Verificador de Artículos
## Problema:
### La empresa Code4U ha recibido un encargo de un blog de programadores, ya que actualmente han aumentado los casos de plagio hacia sus artículos. Detectar posibles casos de plagio. Además, la empresa también desea conocer la frecuencia de uso de cada palabra contenida en sus artículos, por eso también se ha solicitado a la empresa que el programa sea capaz de contar las repeticiones de cada término.
### Para solucionar este problema se contactó con su equipo para que implemente un programa en java que mediante el uso de una Hash Table o Tablas de Dispersión pueda encontrar las repeticiones de cada palabra contenida en artículos de programación. Además, debe utilizar el algoritmo de Rabin-Karp para alertar de plagios.
### Para llevar a cabo este proyecto deberá realizar una investigación documental sobre Hash Tables, Hash Functions y el algoritmo de Rabin-Karp, en el texto anterior se le proporcionan algunos enlaces con los que poder iniciar esta búsqueda de información. 
### Tenga en cuenta que la solución al problema debe ser implementada con un TDA de una Hash Table con manejo de colisiones. 
## Requerimientos funcionales:
  1. Leer documento: El usuario podrá seleccionar un archivo txt mediante un JFileChooser, por ejemplo un artículo de programación, el programa deberá ser capaz de leer todas las palabras contenidas en el archivo e insertarlas en la estructura de datos. Cabe destacar que las lecturas de archivos son acumulativas, es decir, que al leer un segundo artículo los contadores de repetición no serán reiniciados. Recuerden eliminar los signos de puntuación del texto.
  2. Contar repeticiones: El usuario debe poder conocer cuántas veces se repite una palabra del texto. Recordando que al guardar en la Estructura de Datos, se deberán tener en cuenta las repeticiones. No debe haber redundancia de información.
  3. Buscar palabra: El usuario debe poder consultar la existencia de una palabra en un determinado texto, con este fin se realizará una búsqueda en la Hash Table con una complejidad de O(1) o lo más cercana posible. Al realizar esta búsqueda se le notificará al usuario si la palabra se encuentra en el texto, y en caso de existir la cantidad de veces que se repite
  4. Verificar originalidad del artículo: La violación de la propiedad intelectual es un gran problema en la actualidad, por lo tanto los artículos son sometidos a inspecciones. Para realizar una inspección se realiza el siguiente procedimiento:
  a- El usuario debe poder seleccionar el artículo que desee inspeccionar mediante un JFileChooser.
  b- Para inspeccionar un artículo se utiliza el algoritmo de   Rabin-Karp , el cual es capaz de detectar si un fragmento determinado se encuentra dentro de todo el texto. Para ello el usuario introduce el fragmento de texto que desea verificar y el programa le indicará en qué parte del texto este se encuentra
  5. Mostrar palabras más usadas: Finalmente, se requiere ver todas las palabras introducidas en la Hash Table ordenadas descendentemente por el número de repeticiones. Para la implementación de esta función NO se puede recorrer la Tabla de Dispersión, ya que sería extremadamente ineficiente. Para dar solución a este apartado será necesario implementar una lista simplemente enlazada utilizando los MISMOS nodos que la Hash Table para evitar la redundancia de información.
## Requerimientos técnicos:
  1. La solución debe ser implementada con un TDA de una Hash Table.
  2. Su estructura de datos debe manejar las colisiones de forma eficiente.
  3. Puede utilizar cualquier otra estructura auxiliar de ser necesario. Sin embargo, NO podrá emplear librerías para la implementación de las estructuras de datos.
  4. La aplicación debe ofrecer una interfaz gráfica al usuario.
  5. El programa debe poder leer un archivo de texto para introducir artículos de programación. Para ello, es requerido el uso del componente JFileChooser.
  6. Debe documentar el proyecto con Javadoc.
  7. Junto al programa, cada equipo deberá presentar un Diagrama de clases (arquitectura detallada) que explique la solución obtenida.  
  8. El proyecto deberá tener un repositorio en Github y su enlace deberá ser cargado en Canvas junto con un archivo comprimido del proyecto. El nombre del archivo deberá contener los apellidos de los integrantes del equipo.
