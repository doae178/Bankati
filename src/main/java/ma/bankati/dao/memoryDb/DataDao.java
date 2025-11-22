package ma.bankati.dao.memoryDb;

import ma.bankati.dao.IDao;


public class DataDao implements IDao {

    public DataDao() {
        System.out.println("Instanciation du Dao Memory");
    }

    @Override
    public double fetchData() {
        System.out.println("Appel au Dao Memory pour récupérer la donnée MoneyData");
        return db();}

    static double db(){
        double solde = 500.0;

        return solde;
    }
}
