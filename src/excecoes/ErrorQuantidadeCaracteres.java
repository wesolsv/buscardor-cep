package excecoes;

public class ErrorQuantidadeCaracteres extends RuntimeException {

    private String msg;
    public ErrorQuantidadeCaracteres(String s) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
