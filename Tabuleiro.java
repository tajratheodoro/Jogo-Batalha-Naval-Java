import java.util.Random;

public class Tabuleiro {
    private Celula[][] tabuleiro;
    private int tamanho = 20;

    public Tabuleiro() {
        tabuleiro = new Celula[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                tabuleiro[i][j] = new Celula();
            }
        }
        distribuirNavios(10);
    }

    private void distribuirNavios(int quantidade) {
        Random random = new Random();
        int naviosDistribuidos = 0;

        while (naviosDistribuidos < quantidade) {
            int x = random.nextInt(tamanho);
            int y = random.nextInt(tamanho);
            int tamanhoNavio = random.nextInt(3) + 1;
            boolean horizontal = random.nextBoolean();

            if (podeDistribuirNavio(x, y, tamanhoNavio, horizontal)) {
                for (int i = 0; i < tamanhoNavio; i++) {
                    if (horizontal) {
                        tabuleiro[x][y + i].setOcupada(true);
                    } else {
                        tabuleiro[x + i][y].setOcupada(true);
                    }
                               naviosDistribuidos++;
            }
        }
      }
    }

    private boolean podeDistribuirNavio(int x, int y, int tamanhoNavio, boolean horizontal) {
        for (int i = 0; i < tamanhoNavio; i++) {
            if (horizontal) {
                if (y + i >= tamanho || tabuleiro[x][y + i].isOcupada()) {
                    return false;
                }
            } else {
                if (x + i >= tamanho || tabuleiro[x + i][y].isOcupada()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean atirar(int x, int y) {
        if (!tabuleiro[x][y].isAtingida()) {
            tabuleiro[x][y].setAtingida(true);
            return tabuleiro[x][y].isOcupada();
        }
        return false;
    }

    public boolean vitoria(int naviosDestruidos) {
        return naviosDestruidos >= 8;
    }
}
