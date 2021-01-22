package demo;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String removedJsessionId =
            "https://accounts.google.com/o/oauth2/auth;jsessionid=1ltevqgkpzbyt16ubb2mckyp78?approval_prompt=auto&client_id=643378504561-o207o7hsp1me1n3rru6mp9367k8agmdc.apps.googleusercontent.com&redirect_uri=https://staging-app.gmailsharedcontacts.com/account/oauth2/callback&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email%20https://www.googleapis.com/auth/userinfo.profile";

        String correct =
            "https://accounts.google.com/o/oauth2/auth?approval_prompt=auto&client_id=643378504561-o207o7hsp1me1n3rru6mp9367k8agmdc.apps.googleusercontent.com&redirect_uri=https://staging-app.gmailsharedcontacts.com/account/oauth2/callback&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email%20https://www.googleapis.com/auth/userinfo.profile";

        int start = removedJsessionId.indexOf(";jsessionid");
        int end = removedJsessionId.indexOf("?", 0);
        String comUrl = removedJsessionId.substring(0, start) + removedJsessionId.substring(end);

        System.out.println(comUrl);
        System.out.println(comUrl.equals(correct));

    }
}
