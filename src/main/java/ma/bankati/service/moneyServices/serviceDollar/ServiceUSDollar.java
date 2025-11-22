package ma.bankati.service.moneyServices.serviceDollar;

import lombok.Getter;
import lombok.Setter;
import ma.bankati.dao.dataDao.IDao;
import ma.bankati.model.data.Devise;
import ma.bankati.model.data.MoneyData;
import ma.bankati.service.moneyServices.IMoneyService;

@Getter
@Setter
public class ServiceUSDollar implements IMoneyService {

    private IDao dao;

    public ServiceUSDollar() {}

    public ServiceUSDollar(IDao dao) {
        this.dao = dao;
    }

    @Override
    public MoneyData convertData() {
        // Récupère la donnée depuis le DAO (ici, on suppose qu'il s'agit d'un double)
        double data = dao.fetchData();

        // Multiplie la donnée par un facteur spécifique pour la conversion en USD
        double result = data * 1.08;

        // Retourne un nouvel objet MoneyData avec la valeur convertie et la devise USD

        return new MoneyData(Devise.USD, (Double) result);


    }
}
