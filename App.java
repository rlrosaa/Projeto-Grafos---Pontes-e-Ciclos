public class App {

    public static void main(String[] args) {
        try{
        ArquivoGrafo arquivo = new ArquivoGrafo("arquivo.txt");
        GrafoNaoDirecionado grafoNaoDirecionado = new GrafoNaoDirecionado(arquivo);
        int [][] busca = grafoNaoDirecionado.realizaBuscaProfundidade(5);
        String ponte = grafoNaoDirecionado.encontrarPonteGrafo();
        int a = 1;
        }
        catch (Exception ex){
            System.out.println("Erro no arquivo");
        }
    }
    
}
