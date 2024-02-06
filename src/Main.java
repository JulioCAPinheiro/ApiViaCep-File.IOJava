import API.ConsultaCep;
import Arquivos.GeradorDeArquivo;
import endereco.Endereco;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();

        System.out.println("Digite um Cep: ");
        var cep = leitura.nextLine();

        try {
            Endereco meuEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(meuEndereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.arquivoJson(meuEndereco);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}