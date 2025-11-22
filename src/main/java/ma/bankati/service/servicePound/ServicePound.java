package ma.bankati.service.servicePound;

import lombok.Getter;
import lombok.Setter;
import ma.bankati.dao.IDao;
import ma.bankati.model.Devise;
import ma.bankati.model.MoneyData;
import ma.bankati.service.IMoneyService;

@Getter @Setter
public class ServicePound implements IMoneyService {
    private IDao dao;

    public ServicePound() {

        System.out.println("Instanciation du Service \"Euro To Pound Converter\"");

    }

    public ServicePound(IDao dao) {
        this.dao = dao;
        System.out.println("Instanciation du Service \"Euro To Pound Converter\"");

    }

    @Override
    public MoneyData convertData(){

        var data =  dao.fetchData();
        var result =  data*0.84;
        return  new MoneyData(result, Devise.£);
    }
}
