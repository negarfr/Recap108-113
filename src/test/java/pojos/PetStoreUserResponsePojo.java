package pojos;

public class PetStoreUserResponsePojo {
    private Integer Code;
    private String type;
    private String message;

    public PetStoreUserResponsePojo(Integer code, String type, String message) {
        Code = code;
        this.type = type;
        this.message = message;
    }

    public PetStoreUserResponsePojo() {
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PetStoreUserResponsePojo{" +
                "Code=" + Code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
