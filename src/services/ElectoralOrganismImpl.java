package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;

public class ElectoralOrganismImpl implements ElectoralOrganism {
    boolean canVoteOK = true;
    @Override
    public boolean canVote(Nif nif) {
        return canVoteOK;
    }

    @Override
    public void disableVoter(Nif nif) {
        canVoteOK = false;
    }

    @Override
    public DigitalSignature askForDigitalSignature(Party party) {
        throw new UnsupportedOperationException();
    }
}
