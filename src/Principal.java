import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Cep;
import modelo.CepViaCep;
import util.CriarArquivoJson;
import util.FormatCEP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<Cep> ceps = new ArrayList<>();
        Scanner leitura = new Scanner(System.in);
        var busca = "";

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Digite um CEP: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){break;}

            FormatCEP.formatarCEP(busca);

            String endereco = "https://viacep.com.br/ws/"+busca+"/json/";

            String json = BuscaCEP.requisicao(endereco);

            System.out.println(json);

            CepViaCep cepViaCep = gson.fromJson(json, CepViaCep.class);

            System.out.println(cepViaCep);

            Cep cep = new Cep(cepViaCep);
            ceps.add(cep);

            System.out.println(ceps);
        }

        CriarArquivoJson.criarArquivo(gson.toJson(ceps));

    }
}
