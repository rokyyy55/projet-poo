package examen;

public class client extends Modeluser {
    private String clientId;
    private int days;

    public client(String username, String password, String clientId, int days) {
        super(username, password,clientId,days);
        this.clientId = clientId;
        this.days = days;
    }

    public String getClientId() {
        return clientId;
    }
}