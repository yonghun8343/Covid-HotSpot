import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class Start {
    public static void start() throws IOException {

	String workPath = System.getProperty("user.dir");
	File folder = new File(workPath + "\\result");
	File[] listOfFiles = folder.listFiles();

	for (int i = 0; i < listOfFiles.length; i++) {
		String name = listOfFiles[i].getName();
		String newPath = folder.toString() + "\\" + name;
		File inFolder = new File(newPath);
		File[] inListOfFiles = inFolder.listFiles();

		FileWriter writer = new FileWriter(workPath + "\\result2\\" + listOfFiles[i].getName() + ".csv");
		for (int j = 0; j < inListOfFiles.length; j++) {
			Path path = Paths.get(newPath + "\\" + inListOfFiles[j].getName());

			CSVReader reader = new CSVReader(new FileReader(String.valueOf(path)));

			List<String[]> myEntries = reader.readAll();
			List<Punto> puntos = new ArrayList<Punto>();

			for (String[] strings : myEntries) {
				Punto p = new Punto(Arrays.copyOfRange(strings, 1, 3));
				puntos.add(p);
			}

			KMeans kmeans = new KMeans();
			for (int k = 1; k <= 1; k++) {
				KMeansResultado resultado = kmeans.calcular(puntos, k);

				int q = 0;
				for (Cluster cluster : resultado.getClusters()) {
					q++;
					writer.write(listOfFiles[i].getName()  + " " +inListOfFiles[j].getName().split("\\.")[0] + "시");
					writer.write("\n");
					writer.write(cluster.getCentroide().toString());
					writer.write("\n\n");
				}
			}
		}
		writer.close();
		}
	}
}