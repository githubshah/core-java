import org.junit.Test;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class UncaughtExceptionHandlerTestBaseImplSerialLizationTest {

    public static void main(String[] s) {
        //Long a = new Integer(2);

    }

    @Test
    public void someOpenCVTest() {
        System.out.printf("java.library.path: %s%n", System.getProperty("java.library.path"));
        nu.pattern.OpenCV.loadShared(); //add this
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
        System.loadLibrary("opencv_java320");
    }
}
