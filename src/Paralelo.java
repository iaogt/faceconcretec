
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
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
public class Paralelo extends Thread implements Runnable {
        private String urlservicio;
        private String valorfinal;
        
        public Paralelo(String us,String vf){
            urlservicio = us;
            valorfinal = vf;
        }
        
        public void run(){
            String resultado = "";
            try{
                URL url = new URL(urlservicio);
                URLConnection con = url.openConnection();
                HttpURLConnection http = (HttpURLConnection)con;
                http.setRequestMethod("POST"); // PUT is another valid option
                http.setDoOutput(true);
                Map<String,String> arguments = new HashMap<>();
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
        }
        
    }