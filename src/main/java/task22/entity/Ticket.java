package task22.entity;

public class Ticket {
    private int numberTicket;
    private String name;
    private String lastName;
    private String topic;
    private String text;
    private String status;

    public Ticket(int numberTicket, String name, String lastName, String topic, String text, String status) {
        this.numberTicket = numberTicket;
        this.name = name;
        this.lastName = lastName;
        this.topic = topic;
        this.text = text;
        this.status = status;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(int numberTicket) {
        this.numberTicket = numberTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nnumberTicket=" + numberTicket +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                ", status='" + status + '\'';
    }
}
