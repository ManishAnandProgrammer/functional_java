package fluent_design;

import java.util.function.Consumer;

public class Mailer {
    private String from;
    private String to;
    private String subject;
    private String body;

    private Mailer() {
    }

    private Mailer from(final String address) {
        this.from = address;
        return this;
    }

    private Mailer to(final String address) {
        this.to = address;
        return this;
    }

    private Mailer subject(final String line) {
        this.subject = line;
        return this;
    }

    private void body(final String message) {
        this.body = message;
    }

    private static void send(final Consumer<Mailer> block) {
        final Mailer mailer = new Mailer();
        block.accept(mailer);
        //some logic to send mail
        System.out.println("sending..."+mailer);
    }

    public static void main(String[] args) {
        //loan design pattern..!
        Mailer.send(mailer ->
                mailer.from("example@gmail.com")
                        .to("anotherexample@gmail.com")
                        .subject("buildNotification")
                        .body("... TEXT ..."));
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