package src.relatorios;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

// package algoritmo
import src.algoritmo.AlgoritmoOrdenacao;
import src.algoritmo.InsertionSort;
import src.algoritmo.QuickSort;


// package filtragem
import src.filtragem.CriterioFiltragem;
import src.filtragem.CriterioFiltroCategoriaIgual;
import src.filtragem.CriterioFiltroEstoqueMenorIgual;
import src.filtragem.CriterioFiltroTodos;


// package model
import src.model.Produto;
import src.model.ProdutoPadrao;

public class GeradorDeRelatorios {

    // Constantes para os critérios de ordenação
    public static final String CRIT_DESC_CRESC = "descricao_c";
    public static final String CRIT_PRECO_CRESC = "preco_c";
    public static final String CRIT_ESTOQUE_CRESC = "estoque_c";

    // Constantes para os filtros
    public static final String FILTRO_TODOS = "todos";
    public static final String FILTRO_ESTOQUE_MENOR_OU_IQUAL_A = "estoque_menor_igual";
    public static final String FILTRO_CATEGORIA_IGUAL_A = "categoria_igual";

    // Constantes para as opções de formatação
    public static final int FORMATO_PADRAO = 0b0000;
    public static final int FORMATO_NEGRITO = 0b0001;
    public static final int FORMATO_ITALICO = 0b0010;

    // Atributos da classe GeradorDeRelatorios
    private List<Produto> produtos;
    private AlgoritmoOrdenacao algoritmo;
    private String criterio;
    private String filtro;
    private String argFiltro;
    private int format_flags;
    private CriterioFiltragem estrategiaFiltragem;

    // Construtor da classe GeradorDeRelatorios
    public GeradorDeRelatorios(List<Produto> list, AlgoritmoOrdenacao algoritmo, String criterio, String filtro, String argFiltro, int format_flags) {
        this.produtos = list;
        this.algoritmo = algoritmo;
        this.criterio = criterio;
        this.format_flags = format_flags;
        this.filtro = filtro;
        this.argFiltro = argFiltro;
    }

    public void setEstrategiaFiltragem(CriterioFiltragem estrategiaFiltragem) {
        this.estrategiaFiltragem = estrategiaFiltragem;
    }

    // Método para geração de relatórios
    public void geraRelatorio(String arquivoSaida) throws IOException {
        debug();
        algoritmo.ordenar(produtos, criterio);

        PrintWriter out = new PrintWriter(arquivoSaida);
        out.println("<!DOCTYPE html><html>");
        out.println("<head><title>Relatorio de produtos</title></head>");
        out.println("<body>");
        out.println("Relatorio de Produtos:");
        out.println("<ul>");

        int count = 0;

        for (Produto p : produtos) {
            boolean selecionado = estrategiaFiltragem.selecionado(p, argFiltro);

            if (selecionado) {
                out.print("<li>");

                if ((format_flags & FORMATO_ITALICO) > 0) {
                    out.print("<span style=\"font-style:italic\">");
                }

                if ((format_flags & FORMATO_NEGRITO) > 0) {
                    out.print("<span style=\"font-weight:bold\">");
                }

                out.print(p.formataParaImpressao());

                if ((format_flags & FORMATO_NEGRITO) > 0) {
                    out.print("</span>");
                }

                if ((format_flags & FORMATO_ITALICO) > 0) {
                    out.print("</span>");
                }

                out.println("</li>");
                count++;
            }
        }

        out.println("</ul>");
        out.println(count + " produtos listados, de um total de " + produtos.size() + ".");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    // Métodos auxiliares
    public void debug() {
        System.out.println("Gerando relatório para array contendo " + produtos.size() + " produto(s)");
        System.out.println("parametro filtro = '" + argFiltro + "'");
    }
    public static List<Produto> carregaProdutos() {
        return Arrays.asList(
            new ProdutoPadrao( 1, "O Hobbit", "Livros", 2, 34.90),
			new ProdutoPadrao( 2, "Notebook Core i7", "Informatica", 5, 1999.90),
			new ProdutoPadrao( 3, "Resident Evil 4", "Games", 7, 79.90),
			new ProdutoPadrao( 4, "iPhone", "Telefonia", 8, 4999.90),
			new ProdutoPadrao( 5, "Calculo I", "Livros", 20, 55.00),
			new ProdutoPadrao( 6, "Power Glove", "Games", 3, 499.90),
			new ProdutoPadrao( 7, "Microsoft HoloLens", "Informatica", 1, 19900.00),
			new ProdutoPadrao( 8, "OpenGL Programming Guide", "Livros", 4, 89.90),
			new ProdutoPadrao( 9, "Vectrex", "Games", 1, 799.90),
			new ProdutoPadrao(10, "Carregador iPhone", "Telefonia", 15, 499.90),
			new ProdutoPadrao(11, "Introduction to Algorithms", "Livros", 7, 315.00),
			new ProdutoPadrao(12, "Daytona USA (Arcade)", "Games", 1, 12000.00),
			new ProdutoPadrao(13, "Neuromancer", "Livros", 5, 45.00),
			new ProdutoPadrao(14, "Nokia 3100", "Telefonia", 4, 249.99),
			new ProdutoPadrao(15, "Oculus Rift", "Games", 1, 3600.00),
			new ProdutoPadrao(16, "Trackball Logitech", "Informatica", 1, 250.00),
			new ProdutoPadrao(17, "After Burner II (Arcade)", "Games", 2, 8900.0),
			new ProdutoPadrao(18, "Assembly for Dummies", "Livros", 30, 129.90),
			new ProdutoPadrao(19, "iPhone (usado)", "Telefonia", 3, 3999.90),
			new ProdutoPadrao(20, "Game Programming Patterns", "Livros", 1, 299.90),
			new ProdutoPadrao(21, "Playstation 2", "Games", 10, 499.90),
			new ProdutoPadrao(22, "Carregador Nokia", "Telefonia", 14, 89.00),
			new ProdutoPadrao(23, "Placa Aceleradora Voodoo 2", "Informatica", 4, 189.00),
			new ProdutoPadrao(24, "Stunts", "Games", 3, 19.90),
			new ProdutoPadrao(25, "Carregador Generico", "Telefonia", 9, 30.00),
			new ProdutoPadrao(26, "Monitor VGA 14 polegadas", "Informatica", 2, 199.90),
			new ProdutoPadrao(27, "Nokia N-Gage", "Telefonia", 9, 699.00),
			new ProdutoPadrao(28, "Disquetes Maxell 5.25 polegadas (caixa com 10 unidades)", "Informatica", 23, 49.00),
			new ProdutoPadrao(29, "Alone in The Dark", "Games", 11, 59.00),
			new ProdutoPadrao(30, "The Art of Computer Programming Vol. 1", "Livros", 3, 240.00),
			new ProdutoPadrao(31, "The Art of Computer Programming Vol. 2", "Livros", 2, 200.00),
			new ProdutoPadrao(32, "The Art of Computer Programming Vol. 3", "Livros", 4, 270.00)
        );
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Uso:");
            System.out.println("\tjava " + GeradorDeRelatorios.class.getName() + " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <opções de formatação>");
            System.out.println("Onde:");
            System.out.println("\talgoritmo: 'quick' ou 'insertion'");
            System.out.println("\tcriterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c'");
            System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual'");
            System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem");
            System.out.println("\topções de formatação: 'negrito' e/ou 'italico'");
            System.out.println();
            System.exit(1);
        }

        String opcao_algoritmo = args[0];
        String opcao_criterio_ord = args[1];
        String opcao_criterio_filtro = args[2];
        String opcao_parametro_filtro = args[3];

        String[] opcoes_formatacao = new String[2];
        opcoes_formatacao[0] = args.length > 4 ? args[4] : null;
        opcoes_formatacao[1] = args.length > 5 ? args[5] : null;
        int formato = FORMATO_PADRAO;

        for (String op : opcoes_formatacao) {
            formato |= (op != null ? op.equals("negrito") ? FORMATO_NEGRITO : (op.equals("italico") ? FORMATO_ITALICO : 0) : 0);
        }

        AlgoritmoOrdenacao algoritmo;
        if (opcao_algoritmo.equals("quick")) {
            algoritmo = new QuickSort();
        } else if (opcao_algoritmo.equals("insertion")) {
            algoritmo = new InsertionSort();
        } else {
            throw new IllegalArgumentException("Algoritmo inválido!");
        }

        GeradorDeRelatorios gdr = new GeradorDeRelatorios(carregaProdutos(), algoritmo, opcao_criterio_ord, opcao_criterio_filtro, opcao_parametro_filtro, formato);

        // Definir a estratégia de filtragem conforme a opção escolhida pelo usuário
        CriterioFiltragem estrategiaFiltragem;
        if (opcao_criterio_filtro.equals(FILTRO_TODOS)) {
            estrategiaFiltragem = new CriterioFiltroTodos();
        } else if (opcao_criterio_filtro.equals(FILTRO_ESTOQUE_MENOR_OU_IQUAL_A)) {
            estrategiaFiltragem = new CriterioFiltroEstoqueMenorIgual();
        } else if (opcao_criterio_filtro.equals(FILTRO_CATEGORIA_IGUAL_A)) {
            estrategiaFiltragem = new CriterioFiltroCategoriaIgual();
        } else {
            throw new IllegalArgumentException("Critério de filtragem inválido!");
        }

        gdr.setEstrategiaFiltragem(estrategiaFiltragem);

        try {
            gdr.geraRelatorio("saida.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
