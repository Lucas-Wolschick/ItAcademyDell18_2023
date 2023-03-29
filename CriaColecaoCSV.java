
// Imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class CriaColecaoCSV {
    private Scanner entrada = null;
    private String[] nomeCidades;
    private int[][] matrizDistancias;

    public CriaColecaoCSV() {
        entrada = new Scanner(System.in);
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("DNIT-Distancias.csv"));
            entrada = new Scanner(streamEntrada); // Usa como entrada um arquivo
            Charset.forName("UTF-8");
        } catch (Exception e) {
            System.out.println(e);
        }
        nomeCidades = criaArrayCidade();
        matrizDistancias = criaMatriz();
    }

    public int[][] criaMatriz() {
        
        int[][] matrizDistancias = new int[24][24];
        for (int i = 0; i < 24; i++) {
            String a = entrada.nextLine();
            String controlaDistancia[] = a.split(";");
            for (int j = 0; j < 24; j++) {
                matrizDistancias[i][j] = Integer.parseInt(controlaDistancia[j]);
            }
        }
        return matrizDistancias;

    }

    public String getCidade(int cidade) {
        return nomeCidades[cidade-1];
    }

    public int getMatriz(int cidade1, int cidade2) {
        return matrizDistancias[cidade1-1][cidade2-1];
    }

    public String[] criaArrayCidade() {
        String a = entrada.nextLine();
        String cidades[] = a.split(";");
        return cidades;
    }
}