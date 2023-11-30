public class App {

    public static void main(String[] args) {
        try{
        ArquivoGrafo arquivo = new ArquivoGrafo("arquivo.txt");
        GrafoNaoDirecionado grafoNaoDirecionado = new GrafoNaoDirecionado(arquivo);
        }
        catch (Exception ex){
            System.out.println("Erro no arquivo");
        }
    }
    
}
