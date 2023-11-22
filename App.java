public class App {

    public static void main(String[] args) {
        try{
        ArquivoGrafo arquivo = new ArquivoGrafo("arquivo.txt");
        Grafo grafo = new Grafo(arquivo);
        int[][] buscaGrafo = grafo.realizaBuscaProfundidade(1);
        }
        catch (Exception ex){
            System.out.println("Erro no arquivo");
        }
    }
    
}
