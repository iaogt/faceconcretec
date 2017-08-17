
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
    
    public static String enviarData(String[] arrData){
        String resultado="";
        try{
            URL url = new URL("http://webymovil.com");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);
            Map<String,String> arguments = new HashMap<>();
            arguments.put("username", "root");
            arguments.put("password", "sjh76HSn!"); // This is a fake password obviously
            Iterator it = arguments.entrySet().iterator();
            String valorfinal = "param=1";
            while(it.hasNext()){
                Map.Entry pair = (Map.Entry)it.next();
                valorfinal.concat("&par="+URLEncoder.encode((String)pair.getValue(),"UTF-8"));
            }
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
            System.out.println(res.toString());
        }catch(Exception e){
            System.out.println("Error al enviar la información:"+e.getMessage());
        }
        return resultado;
    }
    
}
