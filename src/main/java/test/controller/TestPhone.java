package test.controller;

import org.testng.annotations.Test;
import test.service.*;
import test.service.servicePhone.TexasHoldemPhone;

/**
 * @author wq
 */
public class TestPhone {

    @Test(priority = 0, description = "德州扑克自动化")
    public static void userInformation() throws Exception {
        TexasHoldemPhone.texasHoldemPhone();
    }



}
