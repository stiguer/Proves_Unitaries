package data;
import org.junit.Test;
import static org.junit.Assert.*;

public class MailAddressTest {

    @Test
    public void equalsTest(){
        MailAddress m1 = new MailAddress("abcd123@abcd.com");
        MailAddress m2 = new MailAddress("abcd123@abcd.com");
        assertTrue(m1.equals(m2));
    }

    @Test
    public void hashCodeTest(){
        MailAddress m1 = new MailAddress("abcd123@abcd.com");
        MailAddress m2 = new MailAddress("abcd123@abcd.com");
        assertTrue(m1.hashCode() == m2.hashCode());
    }

    @Test
    public void toStringTest(){
        MailAddress m1 = new MailAddress("abcd123@abcd.com");
        String s = "Address{address='abcd123@abcd.com'}";
        assertEquals(s, m1.toString());
    }
}