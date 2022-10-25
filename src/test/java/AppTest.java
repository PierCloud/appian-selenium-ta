

import com.appiancorp.example.AppianTA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void getInit() {
      AppianTA test = new  AppianTA();
        boolean result = test.initTest();
        boolean expected = true;
        assertEquals(expected,result);
    }


}