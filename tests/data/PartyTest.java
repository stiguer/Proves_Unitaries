package data;
import org.junit.Test;
import static org.junit.Assert.*;

public class PartyTest {

    @Test
    public void equalsTest(){
        Party p1 = new Party("name1");
        Party p2 = new Party("name1");
        assertTrue(p1.equals(p2));
    }

    @Test
    public void hashCodeTest(){
        Party p1 = new Party("name1");
        Party p2 = new Party("name1");
        assertTrue(p1.hashCode() == p2.hashCode());
    }

    @Test
    public void toStringTest(){
        Party p1 = new Party("name1");
        String s = "Party{name='name1'}";
        assertEquals(s, p1.toString());
    }
}