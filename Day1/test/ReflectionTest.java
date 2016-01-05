import org.junit.*;


import static org.junit.Assert.*;

/**
 * Created by Oliver Coulson on 05/01/2016.
 */
public class ReflectionTest {
    private Reflection r;
    @Before
    public void setUp() throws Exception {
        r = new Reflection(12, "bob");
    }

    @org.junit.Test
    public void testSayHi() throws Exception {
        String temp = r.sayHi();
        assertNotNull(temp);
    }
}