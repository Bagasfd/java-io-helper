import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.*;

public class io_util {

    public String  bacaFile(String type, int lineStart,String path) throws IOException{
        FileInputStream fin = new FileInputStream(path);
        int i = 0;
        String str = "";
        while ((i = fin.read()) != -1) {
            str += (char) i;
        }
        fin.close();
        String dataReturn = "";
        String[] data =  str.split("\\r?\\n");
        if(type == "jsonArray"){
            JSONArray datas = new JSONArray();
            String[] header =  data[0].split(",");
            for (int j = lineStart; j < data.length; j++) {
                String[] item = data[j].split(",");
                JSONObject student = new JSONObject();
                for (int k = 0; k < header.length; k++) {
                    student.put(header[k],item[k]);
                }
                datas.add(student);
            }
            dataReturn = datas.toJSONString();
            return  dataReturn;
        }else {
            for (int j = lineStart; j < data.length; j++) {
                dataReturn += data[j] + "\n";
            }
            return dataReturn;
        }
    }

    public Map bacaFileProperties(String path) throws  IOException{
        Map dataReturn = new HashMap();
        Properties props = new Properties();
        props.load(new FileInputStream(path));
        for (Enumeration<?> e = props.propertyNames(); e.hasMoreElements(); ) {
            String name = (String)e.nextElement();
            String value = props.getProperty(name);
            dataReturn.put(name,value);
        }
        return dataReturn;
    }

    public void tulisFile(String text,String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fw);
        bf.write(text);
        bf.close();
        System.out.println("File Succes created");
    }
}
