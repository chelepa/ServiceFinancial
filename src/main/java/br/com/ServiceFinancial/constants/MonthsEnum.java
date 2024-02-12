package br.com.ServiceFinancial.constants;

public enum MonthsEnum {

    JANEIRO("janeiro"),
    FEVEREIRO("fevereiro"),
    MARCO("março"),
    ABRIL("abril"),
    MAIO("maio"),
    JUNHO("junho"),
    JULHO("julho"),
    AGOSTO("agosto"),
    SETEMBRO("setembro"),
    OUTUBRO("outubro"),
    NOVEMBRO("novembro"),
    DEZEMBRO("dezembro");

    private final String message;

    MonthsEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
