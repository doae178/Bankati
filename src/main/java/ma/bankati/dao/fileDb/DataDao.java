package ma.bankati.dao.fileDb;

import ma.bankati.dao.IDao;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataDao implements IDao {


    public DataDao() {
        System.out.println("Instanciation du Dao File");
    }


    @Override
    public double fetchData() {

        System.out.println("Appel au Dao File pour récupérer la donnée MoneyData");
        try {

            URL ressource = getClass().getClassLoader().getResource("FileBase/compte.txt");
            Path chemin = Paths.get(ressource.toURI());

            var r = Files.readAllLines(chemin)
                    .stream()
                    .skip(1)
                    .findFirst()
                    .get();

            return Double.parseDouble(r);

        } catch (Exception e) {
            return 0.0;
        }

    }
}
