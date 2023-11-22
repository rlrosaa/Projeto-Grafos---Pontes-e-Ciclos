import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArquivoGrafo{

    private int [] verticesOrigem;
    private int [] verticesDestino;
    private int vertices;
    private int arestas;

    /**
     * Cria um novo modelo do com os dados presente no arquivo selecionado.
     * @param diretorioArquivo Arquivo TXT com os dados do grafo.
     * @throws FileNotFoundException Retorna exceção se o arquivo não for encontrado.
     */
    public ArquivoGrafo (String  diretorioArquivo) throws FileNotFoundException{

        try{
        File txtGrafo = new File(diretorioArquivo);
        criaVetoresGrafo(txtGrafo);        
        }
        catch(Exception e ){
           new FileNotFoundException("Arquivo não encontrado.");
        }

    }
    
    private void criaVetoresGrafo(File txtGrafo) throws FileNotFoundException {

        Scanner esc = new Scanner(txtGrafo);
        String linha1Arquivo = esc.nextLine();
        vertices = Integer.parseInt(linha1Arquivo.split("\t")[0]);
        arestas = Integer.parseInt(linha1Arquivo.split("\t")[1]);

        //cria os vetores
        verticesOrigem = new int [arestas + 1];
        verticesDestino = new int[arestas + 1];

        int cont = 1;
        while (esc.hasNextLine()){
            String proxLinhaArquivo = esc.nextLine().trim();
            verticesOrigem[cont] = Integer.parseInt(proxLinhaArquivo.split("\t")[0]);
            verticesDestino[cont] = Integer.parseInt(proxLinhaArquivo.split("\t")[1]);
            cont++;
        }

        esc.close();        
    }

    public int [] getVerticesOrigem (){
        return verticesOrigem;
    }

    public int [] getVerticesDestino (){
        return verticesDestino;
    }

    public int getVertices (){
        return vertices;
    }

    public int getArestas() {
        return arestas;
    }

}