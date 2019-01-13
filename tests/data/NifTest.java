package data;
import org.junit.Test;
import static org.junit.Assert.*;

public class NifTest {

    @Test
    public void equalsTest(){
        Nif n1 = new Nif("12345678A");
        Nif n2 = new Nif("12345678A");
        assertTrue(n1.equals(n2));
    }

    @Test
    public void hashCodeTest(){
        Nif n1 = new Nif("12345678A");
        Nif n2 = new Nif("12345678A");
        assertTrue(n1.hashCode() == n2.hashCode());
    }

    @Test
    public void toStringTest(){
        Nif n1 = new Nif("12345678A");
        String s = "Nif{nif='12345678A'}";
        assertEquals(s, n1.toString());
    }
}