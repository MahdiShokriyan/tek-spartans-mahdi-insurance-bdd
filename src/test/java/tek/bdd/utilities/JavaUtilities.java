package tek.bdd.utilities;

import tek.bdd.base.BaseSetup;

public class JavaUtilities extends BaseSetup {


    public static String emailGenerator(String name){
        int randomNumber = (int) (Math.random()*10000);
        return name + randomNumber + "@email.com";
    }
}
