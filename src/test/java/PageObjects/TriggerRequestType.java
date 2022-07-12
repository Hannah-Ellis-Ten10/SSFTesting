package PageObjects;

public enum TriggerRequestType {
    ANY,
    AUTH,
    VERIFY_ENROLLED,
    VERIFY_SIG,
    VOID;
    public static String getSelectionText(TriggerRequestType type){
        switch (type){
            case ANY:
                return "any";
            case AUTH:
                return "auth";
            case VERIFY_ENROLLED:
                return "3ds-verifyenrolled";
            case VERIFY_SIG:
                return "3ds-verifysig";
            case VOID:
                return "void";
        }
        //should not get here
        return "";
    }
}
