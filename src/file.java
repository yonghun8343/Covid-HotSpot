import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class file {
    public static void toDate() throws IOException {
        File folder = new File("C:\\Users\\hun\\Downloads\\Geolife Trajectories 1.3\\Data");
        File[] listOfFiles = folder.listFiles();
        Charset cs = StandardCharsets.UTF_8;

        for (int i = 0; i < listOfFiles.length; i++) {
            String name = listOfFiles[i].getName();
            String newPath = folder.toString() + "\\" + name + "\\Trajectory";
            File inFolder = new File(newPath);
            File[] inListOfFiles = inFolder.listFiles();
            for (int j = 0; j < inListOfFiles.length; j++) {
                Path path = Paths.get(newPath + "\\" + inListOfFiles[j].getName());
                List<String> list = new ArrayList<String>();
                list = Files.readAllLines(path,cs);
                for(int k = 6; k < list.size(); k++){
                    List<String> newList = new ArrayList<String>();
                    String[] temp = list.get(k).split(",");
                    newList.add(name);
                    newList.add(temp[0]);
                    newList.add(temp[1]);
                    newList.add(temp[5]);
                    newList.add(temp[6]);
                    writeFile(temp[5], temp[6], String.join(", ", newList));
                }
            }
        }
    }

    public static void writeFile(String date, String time, String value) {
        try{
            //파일 객체 생성
            time = time.split(":")[0];
            String workPath = System.getProperty("user.dir");
            File file = new File(workPath + "\\result\\" + date + "\\" + time + ".plt");
            file.getParentFile().mkdirs();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(bufferedWriter, true);

            if(file.isFile() && file.canWrite()){
                pw.write(value + "\n");
                pw.flush();
                pw.close();
            }
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
