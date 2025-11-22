package ma.bankati.service.moneyServices.servicePound;

import lombok.Getter;
import lombok.Setter;
import ma.bankati.dao.dataDao.IDao;
import ma.bankati.model.data.Devise;
import ma.bankati.model.data.MoneyData;
import ma.bankati.service.moneyServices.IMoneyService;

@Getter
@Setter
public class ServicePound implements IMoneyService {

    private IDao dao;

    public ServicePound() {}

    public ServicePound(IDao dao) {
        this.dao = dao;
    }

    @Override
    public MoneyData convertData() {
        // Récupère la donnée depuis le DAO (ici, on suppose qu'il s'agit d'un double)
        double data = dao.fetchData();

        // Multiplie la donnée par un facteur spécifique pour la conversion en GBP
        double result = data * 0.84;

        // Retourne un nouvel objet MoneyData avec la valeur convertie et la devise GBP


        return new MoneyData(Devise.GBP, (Double) result);
    }
}
