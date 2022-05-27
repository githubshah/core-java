package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

    Logger logger = LoggerFactory.getLogger(SimpleDateFormatDemo.class);

    void a(){
        logger.info("hello");
    }



    public static void main(String[] args) throws ParseException, InterruptedException {


        new SimpleDateFormatDemo().a();

    }
}
