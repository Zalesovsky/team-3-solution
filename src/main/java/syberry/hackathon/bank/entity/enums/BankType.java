package syberry.hackathon.bank.entity.enums;

public enum BankType {
    DEFAULT("DEFAULT"),
    NATIONAL_BELARUS_BANK("NBB"),
    ALFA_BANK("AB"),
    BELARUSBANK("BB");

    private String text;

    BankType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static BankType fromString(String text) {
        for (BankType b : BankType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return DEFAULT;
    }
}
