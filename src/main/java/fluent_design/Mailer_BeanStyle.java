package fluent_design;

public class Mailer_BeanStyle {
    private String from;
    private String to;
    private String subject;
    private String body;

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void send() {
        // Some mail sending logic
        System.out.println("Sending Mail..."+ this);
    }

    @Override
    public String toString() {
        return "Mailer_BeanStyle{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
