import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamExample {
    public static void main(String[] args) {

        //escribirTiposDatos();
        //leerTiposDatos();
        //escribirUTF();
        //escribirArrays();
        //leerArrays();
        //escribirObjetosPersonalizados();
        leerObjetosPersonalizados();
    }

    private static void escribirTiposDatos() {
        try (OutputStream fos = new FileOutputStream("objects.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            //ObjectOutputStream nos permite escribir más cosas
            oos.writeInt(4);
            oos.writeDouble(3.1416);
            oos.writeBoolean(true);
            oos.writeLong(123456789L);
            //Si no hacemos un try with resources donde metemos ambos objetos
            //no se va a cerrar el proceso y deberíamos cerrarlo nosotros

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerTiposDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objects.txt"))) {
            {
                //ObjectInputStream nos permite leer más cosas
                System.out.println(ois.readInt());
                System.out.println(ois.readDouble());
                System.out.println(ois.readBoolean());
                System.out.println(ois.readLong());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirUTF() {
        try (OutputStream fos = new FileOutputStream("utf.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeUTF("Hola mundo");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirArrays() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("arrays.txt"))){
           //Crear un arrayList de String
            ArrayList<String> nombres = new ArrayList<>();
            nombres.add("Pepe");
            nombres.add("Juan");
            nombres.add("Maria");
            nombres.add("Luis");
            //Escribir cualquier tipo de objeto
            oos.writeObject(nombres);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerArrays() {
        //Leer arrays.txt
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("arrays.txt"))){
            //Requiere que el objeto leido sea un ArrayList
            //Hay que castearlo a un ArrayList
            ArrayList<String> listaLeida =(ArrayList<String>) ois.readObject();
            System.out.println(listaLeida.size());
            System.out.println(listaLeida);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirObjetosPersonalizados(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objetosPersonalizados.txt"))){
            //Crear una lista
            List<Alumno> alumnos = new ArrayList<Alumno>();
            alumnos.add(new Alumno("Steve", "Jobs", "estebancurros@gmail.com"));
            alumnos.add(new Alumno("William", "Gates", "williamgates@gmail.com"));
            alumnos.add(new Alumno("Sergey", "Bringelli", "sergeybrinelli@gmail.com"));
            oos.writeObject(alumnos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerObjetosPersonalizados(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objetosPersonalizados.txt"))){
            List<Alumno> alumnos = (List<Alumno>) ois.readObject();
            System.out.println(alumnos.size());
            //Bucle for each para alumnos
            for(Alumno alumno : alumnos){
                System.out.println(alumno);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
