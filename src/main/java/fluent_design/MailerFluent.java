package fluent_design;

import java.util.function.Consumer;

public class MailerFluent {
    private String from;
    private String to;
    private String subject;
    private String body;

    private MailerFluent() {
    }

    public MailerFluent from(final String address) {
        this.from = address;
        return this;
    }

    public MailerFluent to(final String address) {
        this.to = address;
        return this;
    }

    public MailerFluent subject(final String line) {
        this.subject = line;
        return this;
    }

    public void body(final String message) {
        this.body = message;
    }

    public static void send(final Consumer<MailerFluent> block) {
        final MailerFluent mailerFluent = new MailerFluent();
        block.accept(mailerFluent);
        //some logic to send mail
        System.out.println("sending..."+ mailerFluent);
    }

    @Override
    public String toString() {
        return "Mailer{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}