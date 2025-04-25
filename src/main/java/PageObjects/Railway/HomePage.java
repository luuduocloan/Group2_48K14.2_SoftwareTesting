package PageObjects.Railway;

import common.Constant.Constant;

public class HomePage extends GeneralPage {
//    method
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

}