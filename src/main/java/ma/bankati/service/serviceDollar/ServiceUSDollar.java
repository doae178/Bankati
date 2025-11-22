package ma.bankati.service.serviceDollar;

import lombok.Getter;
import lombok.Setter;
import ma.bankati.dao.IDao;
import ma.bankati.model.Devise;
import ma.bankati.model.MoneyData;
import ma.bankati.service.IMoneyService;

@Getter
@Setter
public class ServiceUSDollar implements IMoneyService {
    private IDao dao;

    public ServiceUSDollar() {

        System.out.println("Instanciation du Service \"Euro To US Dollar Converter\"");
    }

    public ServiceUSDollar(IDao dao) {
        this.dao = dao;

        System.out.println("Instanciation du Service \"Euro To US Dollar Converter\"");
    }

    @Override
    public MoneyData convertData(){

        var data =  dao.fetchData();

        var result =  data*1.08;
        return  new MoneyData(result, Devise.$);
    }
}
