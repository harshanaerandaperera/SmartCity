package Controller;

public class validator {
//IT16083424 Perera P.A.H.E     SHU ID=27045240
public  boolean isValidName(String name){
    return name.matches("[a-zA-Z]+");
}


public  boolean isValidStationID(String bID){
    return bID.matches("^[ST]{1}[0-9]{3}$");
}

public  boolean isValidSensorID(String mID){
    return mID.matches("^[S]{1}[0-9]{3}$");
}

public  boolean isValidEmail(String email){
    return email.matches("^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$");
}

public  boolean isValidMobileNo(String mNumber){   //validates only for sri lankan mobile numbers
    return mNumber.matches("^((0|\\+94|94)7(0|1|2|5|6|7|8))\\d{7}$");
}
    
}
