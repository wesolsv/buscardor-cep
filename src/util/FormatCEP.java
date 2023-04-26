package util;

import excecoes.ErrorQuantidadeCaracteres;

public class FormatCEP {

    public static String formatarCEP(String cep){
        String cepFormatado = cep.replaceAll("-", "");
        cepFormatado = cep.replaceAll("/", "");

        if(cepFormatado.length() < 7){
            throw new ErrorQuantidadeCaracteres("O cep não contém a quantidade de caracteres necessários");
        }

        return  cepFormatado;
    }
}
