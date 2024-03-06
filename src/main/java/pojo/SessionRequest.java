package pojo;

import pojo.session.ClientReferenceInformation;
import pojo.session.OrderInformation;
import pojo.session.PaymentInformation;
import pojo.session.ProcessingInformation;

public class SessionRequest 
{
	    private ClientReferenceInformation clientReferenceInformation;
	    private ProcessingInformation processingInformation;
	    private OrderInformation orderInformation;

	    private PaymentInformation paymentInformation;



	    //SETTER

	    public void setClientReferenceInformation(ClientReferenceInformation clientReferenceInformation) {
	        this.clientReferenceInformation = clientReferenceInformation;
	    }

	    public void setProcessingInformation(ProcessingInformation processingInformation) {
	        this.processingInformation = processingInformation;
	    }

	    public void setOrderInformation(OrderInformation orderInformation) {
	        this.orderInformation = orderInformation;
	    }

	    public void setPaymentInformation(PaymentInformation paymentInformation) {
	        this.paymentInformation = paymentInformation;
	    }



	    // GETTER

	    public ClientReferenceInformation getClientReferenceInformation() {
	        return clientReferenceInformation;
	    }

	    public ProcessingInformation getProcessingInformation() {
	        return processingInformation;
	    }

	    public PaymentInformation getPaymentInformation() {
	        return paymentInformation;
	    }

	    public OrderInformation getOrderInformation() {
	        return orderInformation;
	    }
}
