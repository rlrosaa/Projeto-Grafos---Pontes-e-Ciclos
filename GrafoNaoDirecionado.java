
public class GrafoNaoDirecionado {

    int [][] matrizAdjacencia;    
    int vertices;
    int arestas;

    public GrafoNaoDirecionado(ArquivoGrafo arquivoGrafo){       
        vertices = arquivoGrafo.getVertices();
        arestas = arquivoGrafo.getArestas();
        criaMatrizAdjacencia(arquivoGrafo);        
    }

    private void criaMatrizAdjacencia(ArquivoGrafo arquivoGrafo) {
        
        matrizAdjacencia = new int [vertices+1][vertices+1];
        int [] vertices1 = arquivoGrafo.getVerticesOrigem();
        int [] vertices2 = arquivoGrafo.getVerticesDestino();

        for (int i = 1; i <= arestas;i++){
            int v1 = vertices1[i];
            int v2 = vertices2[i];
            matrizAdjacencia[v1][v2] = 1;
            matrizAdjacencia[v2][v1] = 1;
        }       
        
    }
    
}