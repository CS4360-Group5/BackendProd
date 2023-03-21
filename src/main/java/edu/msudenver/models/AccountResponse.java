package edu.msudenver.models;

public class AccountResponse {

    private Long accountId;
    private String email;
    private String gamerTag;
    private String password;
    private String status;

    public AccountResponse(Long accountId, String email, String gamerTag, String password, String status) {
        this.accountId = accountId;
        this.email = email;
        this.gamerTag = gamerTag;
        this.password = password;
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public String getGamerTag() {
        return gamerTag;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }
}
