package modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVController{
       public static List<String[]> readCSVFile(String filePath) {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                dataList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }


}

