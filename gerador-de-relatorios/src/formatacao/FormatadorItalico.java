package src.formatacao;

public class FormatadorItalico implements FormatadorTexto {
    @Override
    public String formatar(String texto) {
        return "<span style=\"font-style:italic\">" + texto + "</span>";
    }
}