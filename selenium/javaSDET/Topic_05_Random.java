package javaSDET;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic_05_Random {
    String prefixEmail = "joebiden";

    String postFixEmail = "@gmail.com"; //web mail server

            @Test
    public void testEmail() {
                Random rand = new Random();
                //local
                String fullEmail = prefixEmail + rand.nextInt(9999)+ postFixEmail;

                //System.out.println(fullEmail);
                System.out.println(prefixEmail + rand.nextInt(9999)+ postFixEmail);
                System.out.println(prefixEmail + rand.nextInt(9999)+ postFixEmail);
                System.out.println(prefixEmail + rand.nextInt(9999)+ postFixEmail);
                System.out.println(prefixEmail + rand.nextInt(9999)+ postFixEmail);



            }
}
