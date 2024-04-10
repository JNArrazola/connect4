package connect4;

import java.io.Serializable;

public class Register implements Serializable {
    private final String name;
    private final String time;

    public Register(String name, String time){
        this.name = name;
        this.time = time;
    }
    
    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + "\nTiempo: " + time + "\n\n";
    }
}
