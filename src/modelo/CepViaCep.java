package modelo;

public record CepViaCep(String cep, String logradouro,
                        String complemento, String bairro,
                        String localidade, String uf,
                        String ibge, String gia,
                        String ddd, String siafi) {
}
