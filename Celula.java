public class Celula{
    private boolean ocupada;
    private boolean atingida;

public Celula(){
    this.ocupada = false;
    this.atingida = false;
}

public void setOcupada(boolean ocupada) {
    this.ocupada = ocupada;
}

public void setAtingida(boolean atingida) {
    this.atingida = atingida;
}

public boolean isOcupada() {
    return ocupada;
}

public boolean isAtingida() {
    return atingida;
    }
}
