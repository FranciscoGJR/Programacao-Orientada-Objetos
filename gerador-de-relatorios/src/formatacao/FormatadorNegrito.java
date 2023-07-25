package src.formatacao;

public class FormatadorNegrito implements FormatadorTexto {
    @Override
    public String formatar(String texto) {
        return "<span style=\"font-weight:bold\">" + texto + "</span>";
    }
}