package ma.bankati.config;

import ma.bankati.dao.IDao;
import ma.bankati.service.IMoneyService;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class NativeApplicationContext {

    private static final Map<Class<?>, Object> context = new HashMap<>();
    private static final Map<String, Object> contextByName = new HashMap<>(); // Ajout d'une deuxième map

    static {
        var configFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("configFiles/beans.properties");

        if (configFile != null) {
            Properties properties = new Properties();
            try {
                properties.load(configFile);
                String daoClassName = properties.getProperty("dao");
                String servClassName = properties.getProperty("service");

                Class<?> cDao = Class.forName(daoClassName);
                IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

                Class<?> cService = Class.forName(servClassName);
                IMoneyService service = (IMoneyService) cService.getDeclaredConstructor(IDao.class).newInstance(dao);


                // Stockage des beans dans le contexte
                context.put(IDao.class, dao);
                context.put(IMoneyService.class, service);


                // Enregistrement des beans aussi avec des noms explicites
                contextByName.put("dao", dao);
                contextByName.put("service", service);


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Erreur : Le fichier beans.properties est introuvable !");
        }
    }

    /**
     * Retourne un bean en fonction de son nom (String).
     */
    public static Object getBean(String beanName) {
        return contextByName.get(beanName);
    }

    /**
     * Retourne un bean en fonction de sa classe.
     */
    public static <T> T getBean(Class<T> beanClass) {
        return beanClass.cast(context.get(beanClass));
    }
}
