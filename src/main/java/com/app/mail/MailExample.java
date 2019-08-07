package com.app.mail;

import com.app.mail.SendEmail;

/**
 * Created by wly on 2018/3/7.
 */

public class MailExample {

    public static void main (String args[]) throws Exception {
        String email = "";
        String validateCode = "";
        SendEmail.sendEmailMessage(email,validateCode);

    }
}
