package pojo.session;

public class AmountDetails 
{
	private String totalAmount;
    private String currency;



    // SETTERS
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    // GETTERS
    public String getTotalAmount() {
        return totalAmount;
    }

    public String getCurrency() {
        return currency;
    }
}
