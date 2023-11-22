import java.lang.reflect.Array;
import java.util.Arrays;

public class Grafo {

    int [] vetorPointer;
    int [] vetorArcDestino;
    int vertices;
    int arestas;

    public Grafo (ArquivoGrafo arquivoGrafo){       
        vertices = arquivoGrafo.getVertices();
        arestas = arquivoGrafo.getArestas();
        vetorArcDestino = arquivoGrafo.getVerticesDestino();
        criaVetorPointer(arquivoGrafo.getVerticesOrigem());        
    }

    private void criaVetorPointer(int[] verticesOrigem) {

        vetorPointer = new int [vertices + 2];
        vetorPointer[1] = 1;
        vetorPointer[vertices + 1] = arestas + 1;

        int cont = 1;
        for (int i = 1; i< vetorPointer.length -2 ; i++ ){
            while (verticesOrigem [cont] == i){
                cont++;
            }    
            vetorPointer[i+1] = cont;
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
        int [] listaSucessores = criaListaSucessores(no);

        for (int i : listaSucessores) {
            if(vetorBuscaProfundidade[0][i] == 0){
                //visitarArestaArvore
                vetorBuscaProfundidade[2][i] = no;
                t = buscaProfundidade(vetorBuscaProfundidade,i,t);
            }
            else{
                if(vetorBuscaProfundidade[1][i] == 0){
                    //visitar aresta de retorno
                }
                else  if(vetorBuscaProfundidade[0][i] > t){
                    //visitar aresta de avanço
                }
                else{
                    //visitar aresta de cruzamento
                }
            }
        }
        vetorBuscaProfundidade[1][no] = t;
        return t;        
    }
    /**
     * Retorna um vetor ordenado com todos os vertirces vizinhos ao vertice informado.
     * @param vertice
     * @return
     */
    private int[] criaListaSucessores(int vertice){
        int posInicio = vetorPointer[vertice];
        int posFinal = vetorPointer[vertice + 1] -1;
        int [] listaSucessores = new int [posFinal - posInicio +1];

        for (int i = posInicio;i<=posFinal;i++ ){
            listaSucessores[i - posInicio] = vetorArcDestino [i];
        }
        Arrays.sort(listaSucessores);
        return listaSucessores;
    }
    
}
