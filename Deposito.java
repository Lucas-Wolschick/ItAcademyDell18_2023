import java.util.ArrayList;

public class Deposito {
    private ArrayList<Carga> depositos;
    private ArrayList<Carga> trajetos;

    // Construtor
    public Deposito() {
        depositos = new ArrayList<Carga>(10);
        trajetos = new ArrayList<Carga>(10);
    }

    // Create-Criar-Cadastrar
    public boolean cadastrarCarga(Carga f) {
        return depositos.add(f);
    }

    public boolean cadastrarTrajetos(Carga f) {
        return trajetos.add(f);
    }

    // Retrieve - Consultar
    // Retorna a quantidade de caminhoes com o tipo indicado ou null se nao existir
    public Carga consultarCargas() {
        for (int index = 0; index < depositos.size(); index++) {
            Carga aux = depositos.get(index);
            if (aux != null) {
                return aux;
            }

        }
        return null;
    }

    public Carga consultarTrajetos() {
        for (int index = 0; index < trajetos.size(); index++) {
            Carga aux = trajetos.get(index);
            if (aux != null) {
                return aux;
            }

        }
        return null;
    }

    public double somaPreco(int grande, int medio, int pequeno, int distancia) {
        double precoG = 0;
        double precoM = 0;
        double precoP = 0;
        double preco = 0;
        for (int i = 0; i < grande; i++) {
            precoG = precoG + (distancia * 27.44);
        }
        for (int i = 0; i < medio; i++) {
            precoM = precoM + (distancia * 11.92);
        }
        for (int i = 0; i < pequeno; i++) {
            precoP = precoP + (distancia * 4.87);
        }

        preco = precoG + precoM + precoP;

        return preco;

    }

}