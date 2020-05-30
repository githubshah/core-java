package zainab;


public class Zainab {

    public static void main(String as[]) {
        String url = "http://localhost:3000/";
        int i = url.lastIndexOf("/");
        String substring = url.substring(0, i + 1);
        System.out.println(substring);


        String url12 = "http://localhost:8080/account/marketplace.ftl";
        String[] split = url12.split("/");
        System.out.println(split[0] + "//" + split[2]);

    }
}
