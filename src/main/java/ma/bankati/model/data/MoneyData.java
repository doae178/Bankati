package ma.bankati.model.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MoneyData {
    private Double amount;
    private Devise devise;

    public MoneyData(Devise devise, Double amount) {
        this.devise = devise;
        this.amount = amount;
    }

    public String toString(){
        amount = Math.round(amount*100)/100.0;
        return amount + " " + devise.toString();
    }
}
