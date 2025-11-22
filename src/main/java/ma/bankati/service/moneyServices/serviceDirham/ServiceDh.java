package ma.bankati.service.moneyServices.serviceDirham;

import lombok.Getter;
import lombok.Setter;
import ma.bankati.dao.dataDao.IDao;
import ma.bankati.model.data.Devise;
import ma.bankati.model.data.MoneyData;
import ma.bankati.service.moneyServices.IMoneyService;

@Getter
@Setter
public class ServiceDh implements IMoneyService {

    private IDao dao;

    public ServiceDh() {}

    public ServiceDh(IDao dao) {
        this.dao = dao;
    }

    @Override
    public MoneyData convertData() {
        // Récupère la donnée depuis le DAO (ici, on suppose qu'il s'agit d'un double)
        double data = dao.fetchData();

        // Multiplie la donnée par un facteur spécifique
        double result = data * 10.0;

        // Retourne un nouvel objet MoneyData avec la valeur convertie et la devise DH

        return new MoneyData(Devise.DH, (Double) result);


    }
}
