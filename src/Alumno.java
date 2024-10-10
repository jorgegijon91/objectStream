import java.io.Serializable;

//Implementar Serializable para darle permiso a Java para que lo almacene en binario
//A largo plazo no es buena idea porque los programas pueden cambiar
public class Alumno implements Serializable {
   private String nombre;
   private String apellidos;
   private String email;

   public Alumno(String nombre, String apellidos, String email) {
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.email = email;
   }

   //Gerenar toString
   @Override
   public String toString() {
      return "Alumno{" +
              "nombre='" + nombre + '\'' +
              ", apellidos='" + apellidos + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
