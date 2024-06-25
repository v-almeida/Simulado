
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();

        // Ler arquivos CSV e preencher listas
        try {
            // Leitura do arquivo Pessoas.csv
            List<String> linhasPessoas = Files.readAllLines(Paths.get("Pessoas.csv"));
            for (String linha : linhasPessoas) {
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0].trim()); // Convertendo para int e removendo espaços em branco
                String nome = partes[1].trim(); // Removendo espaços em branco
                pessoas.add(new Pessoa(id, nome));
            }
            System.out.println("Pessoas lidas do arquivo: " + pessoas.size());

            // Leitura do arquivo Endereco.csv
            List<String> linhasEnderecos = Files.readAllLines(Paths.get("Enderecos.csv"));
            for (String linha : linhasEnderecos) {
                String[] partes = linha.split(";");
                String rua = partes[0].trim(); // Removendo espaços em branco
                String cidade = partes[1].trim(); // Removendo espaços em branco
                int pessoaId = Integer.parseInt(partes[2].trim()); // Convertendo para int e removendo espaços em branco
                enderecos.add(new Endereco(rua, cidade, pessoaId));
            }
            System.out.println("Endereços lidos do arquivo: " + enderecos.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Gerar arquivo PessoasComEnderecos.csv
        try (FileWriter writer = new FileWriter("PessoasComEnderecos.csv")) {
            for (Pessoa pessoa : pessoas) {
                for (Endereco endereco : enderecos) {
                    if (endereco.getPessoaId() == pessoa.getId()) {
                        writer.write(pessoa.getId() + ";" + pessoa.getNome() + ";" +
                                endereco.getRua() + ";" + endereco.getCidade() + "\n");
                    }
                }
            }
            System.out.println("Arquivo PessoasComEnderecos.csv gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
