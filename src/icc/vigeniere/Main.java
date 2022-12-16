package icc.vigeniere;
import java.util.Scanner;

public class Main
{
    public static void main(String[]args)
    {
        Scanner leer = new Scanner(System.in);
        String cadena;
        char opcion;
        do{
        System.out.println("La clave a utilizar será HOLA");
        System.out.println("Escoge una opción");
        System.out.println("1. Cifrar mensaje");
        System.out.println("2. Descifar Mensaje");
        System.out.println("3. Salir");

        opcion=leer.nextLine().charAt(0); //Con esta línea leeremos la opción que nos indique el usuario
        
        if(opcion=='1'){ //Comprobamos que opción ha elegido el usuario
                System.out.println("¿Qué mensaje quieres codificar?");
                cadena=leer.nextLine();
                System.out.println(Codificar(cadena)); //Llamamos al metodo cifrar con la variable cadena
            }
        else if(opcion=='2'){ //Comprobamos la opción elegida
                System.out.println("¿Qué mensaje quieres descodificar?");
                cadena=leer.nextLine();
                System.out.println(Descodificar(cadena)); //Llamamos al metodo descodificar
                }
        }while(opcion!='3'); //Repetimos este ciclo hasta que el usuario nos marque 3
        
    }
    public static String Codificar(String Mensaje) //Método que nos ayudara a codificar 
    {
        String salida=""; //Creamos una variable vacía para que guarde ahí la cadena resultante
        String abecedario="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; //creamos una variable donde guardaremos el abecedario
        String clave="HOLA"; //Aquí ya definimos nuestra palabra clave con lo que codificaremos 


       char []claveIgual=new char [Mensaje.length()]; //Creamos nuestro arreglo con longitud del mensaje
       char []Msj=Mensaje.toUpperCase().toCharArray(); //Si el mensaje nos llega en minus lo pasamos a mayus

       int contador=0;
       for(int c=0;c<Mensaje.length();c++) //Ciclo for que nos ayuda a recorrer el mensaje
       {
           
           if(Mensaje.charAt(c)==' ') //EL if busca espacios
           {
               c++; //Agrega una unidad al contador cada que encuentra un espacio
           }
           claveIgual[c]=clave.charAt(contador);
           contador++;

           if(contador==clave.length()) //Aquí cuando nuestro contador llegue al tamaño del mensaje parara
           {
               contador=0;
           }
       }

       int a=0,b=0,d; //Declaramos variables que nos ayudaran a recorrer el abecedario
       for(int c=0;c<Mensaje.length();c++)
       {
           if(Mensaje.charAt(c)==' ')//Si el mensaje que nos mandan es vacio
           {
               salida+=" ";//La salida también sera vacion 
               c++;
           }
           for(int i=0;i<abecedario.length();i++) //Ciclo que recorrera la longitud del abecedario
           {
               if(Msj[c]==abecedario.charAt(i))
               {
                   a=i;
                   
               }
               if(claveIgual[c]==abecedario.charAt(i))
               {
                   b=i;
                   
               }
               
               
           }
           d=(a+b)%27;//Revisamos el residuo y lo concatenamos a la salida
           salida+=abecedario.charAt(d);
           
       }
       
       return salida; //Regresamos la salida 
    }
    public static String Descodificar(String Mensaje) //Método para descodificar los mensajes
    {
        String salida=""; //Variable salida donde guardaremos el resultado
        String abecedario="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; //Creamos nuestro abecedarios 
        String clave="HOLA"; //Definimos nuestra palabra clave 
        int contador=0;//Definimos un contador 


       char []claveIgual=new char [Mensaje.length()]; //Creamos nuestro arreglo con tamaño del mensaje
       char []Msg=Mensaje.toUpperCase().toCharArray();//Pasamos todo nuestro mensaje a mayúsculas

       for(int c=0;c<Mensaje.length();c++) //Ciclo for para recorrer la longitud del mensaje 
       { 
           if(Mensaje.charAt(c)==' ') //Si encuentra un espacio
           {
               c++;//Suma uno al contador 
           }
           claveIgual[c]=clave.charAt(contador);
           contador++;
           if(contador==clave.length()) //Cuando el contador llegue al tamaño de la clave 
           {
               contador=0; //contador sera igual a 0
           }
       }
       contador=0; //Reinciamos el valor del contador 
       int x=0,y=0,z,t;
       for(int c=0;c<Mensaje.length();c++) //For que recorre la longitud del mensaje
       {
           if(Mensaje.charAt(c)==' ') //Si nuestro mensaje es vacio
           {
               salida+=" ";//La salida sera un espacio 
               c++;
           }
           for(int f=0;f<abecedario.length();f++) //Ciclo for que recorre el tamaño de el abecedario
           {
               if(Msg[c]==abecedario.charAt(f))
               {
                   x=f;
                   
               }
               if(claveIgual[c]==abecedario.charAt(f))
               {
                   y=f;
                   
               }            
           }
           z=(y-x); //Guardamos el resultado de la diferencia de ambos valores
           if(z<=0)
           {
               if(z==0) //Si el resultado es igual a 0
               {
                   salida+="A"; //Imprimos la letra A
               }
               else //En cambio si el contador es distinto a 0
               {
                    for(int j=1;j<=abecedario.length();j++) //Hacemos n for que nuevamente nos recorra la longitud del abecedario
                    {
                    contador++; //Sumamos uno más a nuestro contador 
                    if(contador==(z*-1)) //Comparamos si el resultado del contador es igual a la multiplicación 
                    {
                        salida+=abecedario.charAt(j); //Nuestra salida sera el caracter situado del abecedario
                        break;
                    }
                    }    
               }
               
            } else { //Nuestro else con el ciclo for, donde si el índice es igual a 26
               for(int i=26;i>=0;i--)
                {
                    contador++; //el conatdor suma 1
                    if(contador==z) //Comparamos el resultado de contador con z 
                    {
                       salida+=abecedario.charAt(i); //EL resultado de salida sera el abecedario más el caracter situado en este caso de i
                       break;
                    }
                }
           }
                
                contador=0;
           
       }
       
       return salida; //Regresamos la variable salida
    }
} //No pude implementar el uso creación y lectura de documentos pero sí un algoritmo que codifica en Vigenere
