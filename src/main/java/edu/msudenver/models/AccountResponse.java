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

    public AccountResponse(Account account) {
        this.accountId = account.getAccountId();
        this.email = account.getEmail();
        this.gamerTag = account.getGamerTag();
        this.password = account.getPassword();
        this.status = account.getStatus();
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

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
