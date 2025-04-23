package za.co.cascade.model;

public class ValidationRequest {
    private String idNumber;

    public ValidationRequest() {}

    public ValidationRequest(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
