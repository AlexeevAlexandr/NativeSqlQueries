import commands.Clear;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyTest {

    @Test
    public void testCanProcessClear(){
        Clear clear = new Clear();
        assertTrue(clear.canProcess("clear"));
        assertFalse(clear.canProcess("select"));
    }

    @Test
    public void testProcessClear(){
        Clear clear = new Clear();
        clear.process();


    }
}
