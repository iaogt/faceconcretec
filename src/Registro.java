
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import sun.misc.BASE64Decoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardoi
 */
public class Registro {
    
    public static String procesaArchivo(String respuesta){
        String target="";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder b;
        try{
            b = dbf.newDocumentBuilder();
            Document doc = b.parse(new InputSource(new StringReader(respuesta)));
            Element root = doc.getDocumentElement(); 
            NodeList nList = doc.getElementsByTagName("pResultado");
            Element e = (Element)nList.item(0);
            if(e.getTextContent().matches("true")){
                nList = doc.getElementsByTagName("pSerie");
                e = (Element)nList.item(0);
                String nomarchivo = e.getTextContent();
                nList = doc.getElementsByTagName("pNoDocumento");
                e = (Element)nList.item(0);
                nomarchivo = nomarchivo + "_" + e.getTextContent()+".pdf";
                nList = doc.getElementsByTagName("pRespuesta");
                e = (Element)nList.item(0);
                
                Date fecha = new Date();
                SimpleDateFormat df = new SimpleDateFormat("MMYYYY");
                String path = df.format(fecha);
                File f = new File(path);
                if(!f.exists()){
                    System.out.println("creando carpeta");
                    f.mkdir();
                }
                
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] decodedBytes;
                FileOutputStream fop;
                decodedBytes = new BASE64Decoder().decodeBuffer(e.getTextContent());
                File file = new File(nomarchivo);
                fop = new FileOutputStream(path+"/"+file);

                fop.write(decodedBytes);

                fop.flush();
                fop.close();
                target = path+"/"+file;
            }else{
                nList = doc.getElementsByTagName("pResultado");
                e = (Element)nList.item(0);
                target = "error"+e.getTextContent();
            }
        }catch(Exception e){
            System.out.println("XML inválido");
        }
        return target;
    }
    
    public static String procesaAnular(String respuesta){
        String target="";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder b;
        try{
            b = dbf.newDocumentBuilder();
            Document doc = b.parse(new InputSource(new StringReader(respuesta)));
            Element root = doc.getDocumentElement(); 
            NodeList nList = doc.getElementsByTagName("pResultado");
            Element e = (Element)nList.item(0);
            if(e.getTextContent().matches("true")){
                nList = doc.getElementsByTagName("pDescripcion");
                e = (Element)nList.item(0);
                target = e.getTextContent();
            }else{
                nList = doc.getElementsByTagName("pDescripcion");
                e = (Element)nList.item(0);
                target = "error"+e.getTextContent();
            }
        }catch(Exception e){
            System.out.println("XML inválido");
        }
        return target;
    }
}
