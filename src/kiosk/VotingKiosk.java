package kiosk;
import data.MailAddress;
import data.Nif;
import data.Party;
import services.ElectoralOrganism;
import services.MailerService;

/**
 * Implements a simplification of Use Case: Emit eVote
 */

public class VotingKiosk {
    private ElectoralOrganism eO;
    private MailerService mService;
    Party party;
    Nif nif;


    public VotingKiosk(){
        this.eO = null;
        this.mService = null;
        party = null;
        nif = null;
    }
    public void setElectoralOrganism(ElectoralOrganism eO) {
        this.eO = eO;
    }
    public void setMailerService(MailerService mService){
        this.mService = mService;
    }
    public void vote(Party party) throws IllegalStateException {
        if(!eO.canVote(nif)){
            throw new IllegalStateException();
        }else{
            this.party = party;
            eO.disableVoter(nif);
        }
    }
    public void sendeReceipt(MailAddress address) throws IllegalStateException{
        if (party == null){
            throw new IllegalStateException();
        }else{
        mService.send(address, eO.askForDigitalSignature(party));
        }
    }
}
