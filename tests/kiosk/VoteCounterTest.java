package kiosk;
import data.Party;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class VoteCounterTest {
    @Test
    public void VCTest(){
        Set<Party> parties = new HashSet<>();
        Party p1 = new Party("name1");
        Party p2 = new Party("name2");
        Party p3 = new Party("");
        Party p4 = new Party(null);
        parties.add(p1);
        parties.add(p2);
        VoteCounter v = new VoteCounter(parties);

        v.scrutinize(p3);
        v.scrutinize(p3);
        v.scrutinize(p4);
        v.scrutinize(p1);
        v.scrutinize(p2);
        v.scrutinize(p2);
        v.scrutinize(p2);
        v.scrutinize(p1);
        v.scrutinize(p2);
        v.scrutinize(p1);
        assertEquals(3, v.getVotesFor(p1));
        assertEquals(4, v.getVotesFor(p2));
        assertEquals(2, v.getBlanks());
        assertEquals(1, v.getNulls());
        assertEquals(10, v.getTotal());
    }
}