package ERP.Project.TrialBalance;

public class Figure {
    public String Code;
    public Long Amount;

    public Figure(String code, Long amount) {
        Code = code;
        Amount = amount;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Long getAmount() {
        return Amount;
    }

    public void setAmount(Long amount) {
        Amount = amount;
    }
}
