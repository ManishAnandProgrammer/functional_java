package fluent_design;

public class MailBuilder {
    private String from;
    private String to;
    private String subject;
    private String body;

    public MailBuilder setFrom(final String from) {
        this.from = from;
        return this;
    }

    public MailBuilder setTo(final String to) {
        this.to = to;
        return this;
    }

    public MailBuilder setSubject(final String subject) {
        this.subject = subject;
        return this;
    }

    public MailBuilder setBody(final String body) {
        this.body = body;
        return this;
    }

    public void send() {
        System.out.println("Sending Mail With Builder:: "+this);
    }

    @Override
    public String toString() {
        return "MailBuilder{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
