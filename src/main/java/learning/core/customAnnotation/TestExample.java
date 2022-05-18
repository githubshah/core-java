package learning.core.customAnnotation;

@TesterInfo(
        priority = TesterInfo.Priority.HIGH,
        createdBy = "mkyong.com",
        tags = {"sales", "test"}
)
public class TestExample {

    @Test(name = "Hi Mac")
    void testA(String enabled) {
        System.out.println("executing testA: enabled: " + enabled);
    }

    @Test(enabled = false)
    void testB() {
        System.out.println("executing testB");
    }
}