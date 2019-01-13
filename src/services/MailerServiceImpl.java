package services;

import data.DigitalSignature;
import data.MailAddress;

public class MailerServiceImpl implements MailerService {
    public boolean sendOK = false;
    @Override
    public void send(MailAddress address, DigitalSignature signature) { this.sendOK = true; }
}
