package ma.bankati.model.data;

public enum Devise {
    DH,
    USD,
    EUR,
    GBP;

    // Method to map string values from a file or other input sources to the enum values
    public static Devise fromString(String value) {
        switch (value) {
            case "Dh":
                return DH;
            case "$":
                return USD;
            case "€":
                return EUR;
            case "£":
                return GBP;
            default:
                throw new IllegalArgumentException("Unknown devise: " + value);
        }
    }

    // Method to convert enum values back to string for writing to a file or other output sources
    public String toStringValue() {
        switch (this) {
            case DH:
                return "Dh";
            case USD:
                return "$";
            case EUR:
                return "€";
            case GBP:
                return "£";
            default:
                return "null";
        }
    }
}
