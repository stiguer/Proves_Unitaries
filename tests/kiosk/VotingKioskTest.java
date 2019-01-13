package kiosk;

import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import org.junit.jupiter.api.Test;
import services.ElectoralOrganism;
import services.ElectoralOrganismImpl;
import services.MailerService;
import services.MailerServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

class VotingKioskTest {

    public static class correctDigitalSignature extends ElectoralOrganismImpl{
        DigitalSignature digitalSignature = new DigitalSignature("signed".getBytes());

        @Override
        public DigitalSignature askForDigitalSignature(Party party) {
            return digitalSignature;
        }
    }

    @Test
    public void correctVote() {
        VotingKiosk votingKiosk = new VotingKiosk();
        ElectoralOrganism eO = new ElectoralOrganismImpl();
        Party party = new Party("name1");
        Nif nif = new Nif("12345678A");

        votingKiosk.setElectoralOrganism(eO);
        votingKiosk.vote(party);
        assertFalse(eO.canVote(nif));
    }

    @Test
    public void DoubleVote(){
        VotingKiosk votingKiosk = new VotingKiosk();
        ElectoralOrganism eO = new ElectoralOrganismImpl();
        Party party = new Party("name1");

        votingKiosk.setElectoralOrganism(eO);
        votingKiosk.vote(party);
        assertThrows(IllegalStateException.class, ()-> votingKiosk.vote(party));
    }

    @Test
    public void nullSendReceipt(){
        VotingKiosk votingKiosk = new VotingKiosk();
        MailAddress address = new MailAddress("aaaa@aaaa.com");

        assertThrows(IllegalStateException.class, ()-> votingKiosk.sendeReceipt(address));
    }

    @Test
    public void correctSendReceipt(){
        VotingKiosk votingKiosk = new VotingKiosk();
        MailerService mService = new MailerServiceImpl();
        ElectoralOrganism eO = new correctDigitalSignature();
        MailAddress address = new MailAddress("aaaa@aaaa.com");
        Party party = new Party("name1");

        votingKiosk.setElectoralOrganism(eO);
        votingKiosk.setMailerService(mService);
        votingKiosk.vote(party);
        votingKiosk.sendeReceipt(address);
        assertTrue(((MailerServiceImpl) mService).sendOK);
    }
}