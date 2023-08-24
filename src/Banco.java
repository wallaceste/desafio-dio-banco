import java.util.Arrays;

public class Banco {
    private String nome;

    private int[] agencias;


    public Banco(String nome, int[] agencias) {
        this.nome = nome;
        this.agencias = agencias;
    }

    public String getNome() {
        return nome;
    }

    public int[] getAgencias() {
        return agencias;
    }

    public int escolheAgencia(int num){
        return agencias[num];
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", agencias= " + Arrays.toString(agencias) +
                '}';
    }
}
