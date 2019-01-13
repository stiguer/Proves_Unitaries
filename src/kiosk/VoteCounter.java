package kiosk;
import data.Party;
import java.util.*;

/**
 * A class that represents the result in an election site
 */

public class VoteCounter {
    private Hashtable<Party, Integer> parties;
    private int blanks;
    private int nulls;
    private int total;

    public VoteCounter(Set<Party> validParties) {
        this.parties = new Hashtable<>();
        Iterator<Party> it = validParties.iterator();

        while (it.hasNext()){
            parties.put(it.next(), 0);
        }

        this.blanks = 0;
        this.nulls = 0;
        this.total = 0;
    }
    public void countParty(Party party) {
        parties.put(party, parties.get(party) + 1 );
        total++;
    }
    public void countNull() {
        nulls++;
        total++;
    }
    public void countBlank() {
        blanks++;
        total++;
    }
    public void scrutinize(Party party) {
        if(party.getName()==null)
            countNull();
        else if(party.getName()=="")
            countBlank();
        else
            countParty(party);

    }
    public int getVotesFor(Party party) {
        return parties.get(party);
    }
    public int getNulls() { return nulls; }
    public int getBlanks() { return blanks; }
    public int getTotal() { return total; }
}
