package ma.bankati.service.serviceDirham;

import lombok.Getter;
import lombok.Setter;
import ma.bankati.dao.IDao;
import ma.bankati.model.Devise;
import ma.bankati.model.MoneyData;
import ma.bankati.service.IMoneyService;


@Getter @Setter
public class ServiceDh   implements IMoneyService {

   private IDao dao;

    public ServiceDh() {
        System.out.println("Instanciation du Service \"Euro To Dirham Converter\"");
    }

    public ServiceDh(IDao dao) {
        this.dao = dao;
        System.out.println("Instanciation du Service \"Euro To Dirham Converter\"");
    }

    @Override
   public MoneyData convertData(){

       var data =  dao.fetchData();

        var result =  data*10.0;
        return  new MoneyData(result, Devise.Dh);
    }


}
