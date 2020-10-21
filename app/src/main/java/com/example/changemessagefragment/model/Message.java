package com.example.changemessagefragment.model;

import java.io.Serializable;

//Al ponerlo aqui como Serializable es la razon por la que en ViewMessageFragment se utiliza bundle.getSerializable()
public class Message implements Serializable {

    //Declaramos las variables y con la combinacion de teclas Alt+Insert añadimos lo que hay mas abajo
    private User user;
    private String message;
    private int size;
    private String timestamp;


    //region Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!user.equals(message.user)) return false;
        return timestamp.equals(message.timestamp);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + timestamp.hashCode();
        return result;
    }
    //endregion

    //region Getter and Setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    //endregion

    //region Constructor
    public Message(User user, String message,String timestamp, int size) {
        this.user = user;
        this.message = message;
        this.size = size;
        this.timestamp = timestamp;
    }
    //endregion

    //region ToString
    @Override
    public String toString() {
        return "Message{" +
                "user=" + user +
                ", message='" + message + '\'' +
                ", size=" + size +
                '}';
    }
    //endregion
}
