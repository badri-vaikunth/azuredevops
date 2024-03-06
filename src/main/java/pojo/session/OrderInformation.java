package pojo.session;

public class OrderInformation 
{
    private AmountDetails amountDetails;
    private ShipTo shipTo;


    // SETTER
    public void setAmountDetails(AmountDetails amountDetails) {
        this.amountDetails = amountDetails;
    }

    public void setShipTo(ShipTo shipTo) {
        this.shipTo = shipTo;
    }


    // GETTER
    public AmountDetails getAmountDetails() {
        return amountDetails;
    }

    public ShipTo getShipTo() {
        return shipTo;
    }

}
