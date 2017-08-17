
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardoi
 */
public class BDLocal {
    
    public static Map getOpciones(){        
        Map<String,String> opciones = new HashMap<String,String>();
        try {
            FileInputStream fin = new FileInputStream("facturacionelectronica.dat");
            ObjectInputStream ois = new ObjectInputStream(fin);
            opciones = (Map<String,String>) ois.readObject();
            ois.close();
        }
        catch(Exception e){
            System.out.println("Error al cargar las opciones");
        }
        return opciones;
    }
    
    public static boolean saveOpciones(Map<String,String> opciones){
        boolean resultado=false;
        try{
            FileOutputStream fout = new FileOutputStream("facturacionelectronica.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(opciones);
            oos.close();
            resultado=true;
        }catch(Exception e){
            resultado=false;
        }
        return resultado;
    }
    
}
