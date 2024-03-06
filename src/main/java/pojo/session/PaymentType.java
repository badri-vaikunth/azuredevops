package pojo.session;

public class PaymentType 
{
	 public PayMethod getMethod() {
	        return method;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setMethod(PayMethod method) {
	        this.method = method;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    private PayMethod method;
	    private String name;
}
