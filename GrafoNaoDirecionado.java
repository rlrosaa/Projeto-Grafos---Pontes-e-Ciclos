import java.util.ArrayList;
import java.util.List;

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

    /**
     * Retorna uma matriz com os resultados da busca, sendo:
     * linha 0 - TD
     * linha 1 - tt
     * linha 2 - pai
     */
    public int [][] realizaBuscaProfundidade(int raiz){

        int [][] vetorBuscaProfundidade = new int [3][vertices + 1];

        buscaProfundidade(vetorBuscaProfundidade, raiz,0);

        return vetorBuscaProfundidade;

    }

    private int buscaProfundidade (int [][] vetorBuscaProfundidade , int no, int t){
        t++;
        vetorBuscaProfundidade[0][no] = t;
        List<Integer> listaSucessores = criaListaSucessores(no);

        for (int i : listaSucessores) {
            if(vetorBuscaProfundidade[0][i] == 0){
                //visitarArestaArvore
                vetorBuscaProfundidade[2][i] = no;
                t = buscaProfundidade(vetorBuscaProfundidade,i,t);
            }
            else if(vetorBuscaProfundidade[1][i] == 0 && vetorBuscaProfundidade[2][i] != no ){
                //visitar aresta de retorno
            }               
        }
        t++;
        vetorBuscaProfundidade[1][no] = t;
        return t;        
    }

    private List<Integer> criaListaSucessores(int no) {
        List<Integer> listaSucesores = new ArrayList<Integer>();
        for (int i = 1;i<=vertices;i++){
            if(matrizAdjacencia[no][i] ==1)
                listaSucesores.add(i);
        }
        return listaSucesores;
    }

/**
 * Encontra a ponte do grafo por metodo naive. Caso o grafo não tenha ponte, o retorno será uma lista vazia.
 * @param raiz Deterina de qual vertice a busca será iniciada. Caso o grafo seja desconexo, a busca ocorrerá apenas no subgrafo da raiz escolhida.
 * @return Retorna uma lista de arrays de duas posições. Cada array é uma aresta ponte. Caso não haja pontes, retorna lista vazia.
 */
    public List<int[]> encontrarPonteGrafo(int raiz){
        
        int[][] matrizBuscaProfundidade;
        boolean conexo;
        List<int[]> listaPontes = new ArrayList<int[]>();

        for (int i = 1; i<=vertices;i++){
            for (int j = 1;j<=vertices;j++){
                if(matrizAdjacencia[i][j] == 1 && i<=j){
                    matrizAdjacencia[i][j] = 0;
                    matrizAdjacencia[j][i] = 0;
                    matrizBuscaProfundidade = realizaBuscaProfundidade(raiz);
                    conexo = testaGrafoConexo (matrizBuscaProfundidade);
                    matrizAdjacencia[i][j] = 1;
                    matrizAdjacencia[j][i] = 1;
                    if (!conexo){
                        int [] ponte = {i,j} ;
                        listaPontes.add(ponte);
                    }
                }
            }
        }
        return listaPontes;     

    }

    private boolean testaGrafoConexo(int[][] matrizBuscaProfundidade) {
        for(int i =1; i<matrizBuscaProfundidade[0].length;i++){
            if(matrizBuscaProfundidade[0][i] == 0){
                return false;
            }
        }
        return true;
    }
    
}