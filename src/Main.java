import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] mapa;
    static boolean[][] visitado;

    static void buscar(int linha, int coluna) {
        if (linha < 0 || linha >= n || coluna < 0 || coluna >= m) {
            return;
        }

        if (visitado[linha][coluna] || mapa[linha][coluna] == '#') {
            return;
        }

        visitado[linha][coluna] = true;

        buscar(linha - 1, coluna);
        buscar(linha + 1, coluna);
        buscar(linha, coluna - 1);
        buscar(linha, coluna + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizador = new StringTokenizer(leitor.readLine());

        n = Integer.parseInt(tokenizador.nextToken());
        m = Integer.parseInt(tokenizador.nextToken());

        mapa = new char[n][m];
        visitado = new boolean[n][m];

        for (int linha = 0; linha < n; linha++) {
            mapa[linha] = leitor.readLine().toCharArray();
        }

        int quantidade = 0;

        for (int linha = 0; linha < n; linha++) {
            for (int coluna = 0; coluna < m; coluna++) {
                if (mapa[linha][coluna] == '.' && !visitado[linha][coluna]) {
                    quantidade++;
                    buscar(linha, coluna);
                }
            }
        }

        System.out.println(quantidade);
    }
}
