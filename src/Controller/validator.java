package Controller;

public class validator {
//IT16083424 Perera P.A.H.E     SHU ID=27045240
public  boolean isValidName(String name){
    return name.matches("[a-zA-Z]+");
}

public  boolean isValidBookTitle(String bTitle){
    return bTitle.matches("[a-zA-Z]+");
}

public  boolean isValidMobileNo(String mNumber){   //validates only for sri lankan mobile numbers
    return mNumber.matches("^((0|\\+94|94)7(0|1|2|5|6|7|8))\\d{7}$");
}
public  boolean isValidMemberID(String mID){
    return mID.matches("^[M]{1}[0-9]{3}$");
}

public  boolean isValidBookID(String bID){
    return bID.matches("^[B]{1}[0-9]{3}$");
}

public  boolean isValidISBN(String isbn){  //ISBN 10 and 13
    return isbn.matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$");
}

public  boolean isValidEmail(String email){
    return email.matches("^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$");
}
    
}
