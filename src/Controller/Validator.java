package Controller;
//IT16083424 Perera P.A.H.E     SHU ID=27045240

public class Validator {

    private static Validator ValidatorInstance;

    private Validator() {
    }
/**
 * 
 * @return ValidatorInstance
 */
    public static Validator getValidatorInstance() {
        if (ValidatorInstance == null) {
            ValidatorInstance = new Validator();
        }
        return ValidatorInstance;
    }
/**
 * 
 * @param name
 * @return name.matches("[a-zA-Z]+")
 */
    public boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }
/**
 * 
 * @param stID
 * @return stID.matches("^[ST]{2}[0-9]{3}$")
 */
    public boolean isValidStationID(String stID) {
        return stID.matches("^[ST]{2}[0-9]{3}$");
    }
/**
 * 
 * @param sID
 * @return sID.matches("^[S]{1}[0-9]{3}$")
 */
    public boolean isValidSensorID(String sID) {
        return sID.matches("^[S]{1}[0-9]{3}$");
    }
    /**
     * 
     * @param num
     * @return num.matches("[0-9]{1,13}(\\.[0-9]*)?")
     */
    public boolean isValidNumber(String num) {
        return num.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }
/**
 * 
 * @param email
 * @return email.matches("^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$")
 */
    public boolean isValidEmail(String email) {
        return email.matches("^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$");
    }
/**
 * 
 * @param mNumber
 * @return mNumber.matches("^((0|\\+94|94)7(0|1|2|5|6|7|8))\\d{7}$")
 */
    public boolean isValidMobileNo(String mNumber) {   //validates only for sri lankan mobile numbers
        return mNumber.matches("^((0|\\+94|94)7(0|1|2|5|6|7|8))\\d{7}$");
    }

}
