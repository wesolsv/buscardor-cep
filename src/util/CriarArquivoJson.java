package util;

import java.io.FileWriter;
import java.io.IOException;

public class CriarArquivoJson {
    static FileWriter escrita;

    static {
        try {
            escrita = new FileWriter("Ceps.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CriarArquivoJson() throws IOException {
    }

    public static void criarArquivo(String dados) throws IOException {
        escrita.write(dados);
        escrita.close();
    }
}
