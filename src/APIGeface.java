
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardoi
 */
public class APIGeface {
    
    private static String XMLTemplate(Map<String,String> mapData,ArrayList lineas){
        String plantilla =  "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<FACTURA>\n" +
"  <ENCABEZADO>\n" +
"    <NOFACTURA>{nofactura}</NOFACTURA>\n" +
"    <RESOLUCION>{resolucion}</RESOLUCION>\n" +
"    <IDSERIE>{idserie}</IDSERIE>\n" +
"    <EMPRESA>{empresa}</EMPRESA>\n" +
"    <SUCURSAL>{sucursal}</SUCURSAL>\n" +
"    <CAJA>{caja}</CAJA>\n" +
"    <USUARIO>{usuario}</USUARIO>\n" +
"    <MONEDA>{moneda}</MONEDA>\n" +
"    <TASACAMBIO>{tasacambio}</TASACAMBIO>\n" +
"    <GENERACION>{generacion}</GENERACION>\n" +
"    <FECHAEMISION>{fechaemision}</FECHAEMISION>\n" +
"    <NOMBRECONTRIBUYENTE><![CDATA[{nombrecontribuyente}]]></NOMBRECONTRIBUYENTE>\n" +
"    <DIRECCIONCONTRIBUYENTE><![CDATA[{direccioncontribuyente}]]></DIRECCIONCONTRIBUYENTE>\n" +
"    <NITCONTRIBUYENTE>{nitcontribuyente}</NITCONTRIBUYENTE>\n" +
"    <VALORNETO>{valorneto}</VALORNETO>\n" +
"    <IVA>{iva}</IVA>\n" +
"    <TOTAL>{total}</TOTAL>\n" +
"    <DESCUENTO>{descuento}</DESCUENTO>\n" +
"    <EXENTO>{exento}</EXENTO>\n" +
"  </ENCABEZADO>\n"+
"  <DETALLE>\n" ;
        Iterator it = mapData.entrySet().iterator();
        String valorfinal = "";
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            String k = "\\{"+(String)pair.getKey()+"\\}";
            String v = (String)pair.getValue();
            plantilla = plantilla.replaceAll(k,v);
        }
        for(int i=0;i<lineas.size();i++){
            String l = "<LINEA>\n" +
"      <CANTIDAD>{quantity}</CANTIDAD>\n" +
"      <DESCRIPCION><![CDATA[{description}]]></DESCRIPCION>\n" +
"      <METRICA>{metric}</METRICA>\n" +
"      <PRECIOUNITARIO>{unitprice}</PRECIOUNITARIO>\n" +
"      <VALOR>{totalvalue}</VALOR></LINEA>\n" ;
            Map<String,String> tmp = (HashMap<String,String>)lineas.get(i);
        it = tmp.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            l = l.replaceAll("\\{"+pair.getKey()+"\\}", (String)pair.getValue());
        }            
            plantilla = plantilla.concat(l);
        }
        plantilla = plantilla.concat("</DETALLE></FACTURA>");
        System.out.println("plantilla: "+plantilla);
        try{
            valorfinal = URLEncoder.encode(plantilla,"UTF-8");
        }catch(Exception e){
            System.out.println("valores erroneos, imposible codificar");
            return "";
        }
        return valorfinal;
    }    
    
    public static String enviarData(Map<String,String> arrData,ArrayList lineas){
        Map<String,String> opciones = BDLocal.getOpciones();
        String pathurl = opciones.get("urlapigeface");
        String resultado="";
        try{
            URL url = new URL(pathurl+"RegistraFacturaXML_PDF");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);
            Map<String,String> arguments = new HashMap<>();
            String valorfinal = "pXmlFactura="+XMLTemplate(arrData,lineas);
            byte[] out = valorfinal.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            http.connect();
            OutputStream os = http.getOutputStream();
            os.write(out);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String inputLine;
            StringBuffer res = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                res.append(inputLine);
            }
            in.close();
            System.out.println("resultado:");
            resultado = res.toString();
        }catch(Exception e){
            System.out.println("Error al enviar la información:"+e.getMessage());
        }
        return resultado;
    }
    
    private static String XMLTemplateNCE(Map<String,String> mapData,ArrayList lineas){
        String plantilla =  "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<NOTACREDITO>\n" +
"  <ENCABEZADO>\n" +
"    <NODOCUMENTO>{nodocumento}</NODOCUMENTO>\n" +
"    <RESOLUCION>{resolucion}</RESOLUCION>\n" +
"    <IDSERIE>{idserie}</IDSERIE>\n" +
"    <EMPRESA>{empresa}</EMPRESA>\n" +
"    <SUCURSAL>{sucursal}</SUCURSAL>\n" +
"    <CAJA>{caja}</CAJA>\n" +
"    <USUARIO>{usuario}</USUARIO>\n" +
"    <MONEDA>{moneda}</MONEDA>\n" +
"    <TASACAMBIO>{tasacambio}</TASACAMBIO>\n" +
"    <GENERACION>{generacion}</GENERACION>\n" +
"    <FECHAEMISION>{fechaemision}</FECHAEMISION>\n" +
"    <NOMBRECONTRIBUYENTE><![CDATA[{nombrecontribuyente}]]></NOMBRECONTRIBUYENTE>\n" +
"    <DIRECCIONCONTRIBUYENTE><![CDATA[{direccioncontribuyente}]]></DIRECCIONCONTRIBUYENTE>\n" +
"    <NITCONTRIBUYENTE>{nitcontribuyente}</NITCONTRIBUYENTE>\n" +
"    <VALORNETO>{valorneto}</VALORNETO>\n" +
"    <IVA>{iva}</IVA>\n" +
"    <TOTAL>{total}</TOTAL>\n" +
"    <DESCUENTO>{descuento}</DESCUENTO>\n" +
"    <EXENTO>{exento}</EXENTO>\n" +
"    <NOFACTURA>{nofactura}</NOFACTURA>\n" +
"    <SERIEFACTURA>{seriefactura}</SERIEFACTURA>\n" +
"    <FECHAFACTURA>{fechafactura}</FECHAFACTURA>\n" +
"    <CONCEPTO>{nceconcepto}</CONCEPTO>\n" +
"  </ENCABEZADO>\n"+
"  <DETALLE>\n" ;
        Iterator it = mapData.entrySet().iterator();
        String valorfinal = "";
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            String k = "\\{"+(String)pair.getKey()+"\\}";
            String v = (String)pair.getValue();
            plantilla = plantilla.replaceAll(k,v);
        }
        for(int i=0;i<lineas.size();i++){
            String l = "<LINEA>\n" +
"      <CANTIDAD>{quantity}</CANTIDAD>\n" +
"      <DESCRIPCION><![CDATA[{description}]]></DESCRIPCION>\n" +
"      <METRICA>{metric}</METRICA>\n" +
"      <PRECIOUNITARIO>{unitprice}</PRECIOUNITARIO>\n" +
"      <VALOR>{totalvalue}</VALOR></LINEA>\n" ;
            Map<String,String> tmp = (HashMap<String,String>)lineas.get(i);
        it = tmp.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            l = l.replaceAll("\\{"+pair.getKey()+"\\}", (String)pair.getValue());
        }            
            plantilla = plantilla.concat(l);
        }
        plantilla = plantilla.concat("</DETALLE></NOTACREDITO>");
        System.out.println("plantilla: "+plantilla);
        try{
            valorfinal = URLEncoder.encode(plantilla,"UTF-8");
        }catch(Exception e){
            System.out.println("valores erroneos, imposible codificar");
            return "";
        }
        return valorfinal;
    }
    
    //dev https://www.ifacere.com/lineapruebas/sso_wsefactura.asmx/
public static String enviarDataNCE(Map<String,String> arrData,ArrayList lineas){
        Map<String,String> opciones = BDLocal.getOpciones();
        String pathurl = opciones.get("urlapigeface");
        String resultado="";
        try{
            URL url = new URL(pathurl+"RegistraNotaCreditoXML_PDF");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);
            Map<String,String> arguments = new HashMap<>(); 
            String valorfinal = "pXmlNotaCredito="+XMLTemplateNCE(arrData,lineas);
            System.out.println("XML a mandar:"+valorfinal);
            byte[] out = valorfinal.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            http.connect();
            OutputStream os = http.getOutputStream(); 
            os.write(out);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String inputLine;
            StringBuffer res = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                res.append(inputLine);
            }
            in.close();
            System.out.println("resultado:");
            resultado = res.toString();
        }catch(Exception e){
            System.out.println("Error al enviar la información:"+e.getMessage());
        }
        return resultado;
    }

private static String XMLTemplateNDE(Map<String,String> mapData,ArrayList lineas){
        String plantilla =  "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<NOTADEBITO>\n" +
"  <ENCABEZADO>\n" +
"    <NODOCUMENTO>{nodocumento}</NODOCUMENTO>\n" +
"    <RESOLUCION>{resolucion}</RESOLUCION>\n" +
"    <IDSERIE>{idserie}</IDSERIE>\n" +
"    <EMPRESA>{empresa}</EMPRESA>\n" +
"    <SUCURSAL>{sucursal}</SUCURSAL>\n" +
"    <CAJA>{caja}</CAJA>\n" +
"    <USUARIO>{usuario}</USUARIO>\n" +
"    <MONEDA>{moneda}</MONEDA>\n" +
"    <TASACAMBIO>{tasacambio}</TASACAMBIO>\n" +
"    <GENERACION>{generacion}</GENERACION>\n" +
"    <FECHAEMISION>{fechaemision}</FECHAEMISION>\n" +
"    <NOMBRECONTRIBUYENTE><![CDATA[{nombrecontribuyente}]]></NOMBRECONTRIBUYENTE>\n" +
"    <DIRECCIONCONTRIBUYENTE><![CDATA[{direccioncontribuyente}]]></DIRECCIONCONTRIBUYENTE>\n" +
"    <NITCONTRIBUYENTE>{nitcontribuyente}</NITCONTRIBUYENTE>\n" +
"    <VALORNETO>{valorneto}</VALORNETO>\n" +
"    <IVA>{iva}</IVA>\n" +
"    <TOTAL>{total}</TOTAL>\n" +
"    <NOFACTURA>{nofactura}</NOFACTURA>\n" +
"    <SERIEFACTURA>{seriefactura}</SERIEFACTURA>\n" +
"    <FECHAFACTURA>{fechafactura}</FECHAFACTURA>\n" +
"    <CONCEPTO>{nceconcepto}</CONCEPTO>\n" +
"  </ENCABEZADO>\n"+
"  <DETALLE>\n" ;
        Iterator it = mapData.entrySet().iterator();
        String valorfinal = "";
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            String k = "\\{"+(String)pair.getKey()+"\\}";
            String v = (String)pair.getValue();
            plantilla = plantilla.replaceAll(k,v);
        }
        for(int i=0;i<lineas.size();i++){
            String l = "<LINEA>\n" +
"      <CANTIDAD>{quantity}</CANTIDAD>\n" +
"      <DESCRIPCION><![CDATA[{description}]]></DESCRIPCION>\n" +
"      <METRICA>{metric}</METRICA>\n" +
"      <PRECIOUNITARIO>{unitprice}</PRECIOUNITARIO>\n" +
"      <VALOR>{totalvalue}</VALOR></LINEA>\n" ;
            Map<String,String> tmp = (HashMap<String,String>)lineas.get(i);
        it = tmp.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            l = l.replaceAll("\\{"+pair.getKey()+"\\}", (String)pair.getValue());
        }            
            plantilla = plantilla.concat(l);
        }
        plantilla = plantilla.concat("</DETALLE></NOTADEBITO>");
        System.out.println("plantilla: "+plantilla);
        try{
            valorfinal = URLEncoder.encode(plantilla,"UTF-8");
        }catch(Exception e){
            System.out.println("valores erroneos, imposible codificar");
            return "";
        }
        return valorfinal;
    }

public static String enviarDataNDE(Map<String,String> arrData,ArrayList lineas){
        Map<String,String> opciones = BDLocal.getOpciones();
        String pathurl = opciones.get("urlapigeface");
        String resultado="";
        try{
            URL url = new URL(pathurl+"RegistraNotaDebitoXML_PDF");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);
            Map<String,String> arguments = new HashMap<>(); 
            String valorfinal = "pXmlNotaDebito="+XMLTemplateNDE(arrData,lineas);
            System.out.println("XML a mandar:"+valorfinal);
            byte[] out = valorfinal.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            http.connect();
            OutputStream os = http.getOutputStream(); 
            os.write(out);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String inputLine;
            StringBuffer res = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                res.append(inputLine);
            }
            in.close();
            System.out.println("resultado:");
            resultado = res.toString();
        }catch(Exception e){
            System.out.println("Error al enviar la información:"+e.getMessage());
        }
        return resultado;
    }
    
}
