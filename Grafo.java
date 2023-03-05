import java.util.ArrayList;
public class Grafo {
    private int matrizAdjacenia[][];
    private int numVertices;

    /**
    * Inicializa o grafo através da matriz de ajdacencia como estrutura de dados.
    * Para isso, ele inicia uma matriz com o tamanho numVertices x numVertices, em
    * que todas posições inicialemnte são igual a 0.
    * @param  numVertices  o número total de vértices do grafo.
    */
    public Grafo(int numVertices){
        this.numVertices = numVertices;
        matrizAdjacenia = new int[numVertices +1][numVertices +1];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizAdjacenia[i][j] = 0;
            }
        }
    }

    /**
    * Adiciona uma aresta ao grafo, alterando o valor da posição desjada
    * (matriz[v][w]) de 0 para 1. Por se tratar de um grafo direcionado, apenas a
    * a posição de (matriz[v][w]) será alterada. Tem complexidade O=1
    * @param  v  o vértice de origem.
    * @param  w  o vértice de entrada.
    */
    public void adicionaAresta(int v, int w){
        matrizAdjacenia[v][w] = 1;
    }

    /**
    * Remove uma aresta ao grafo, alterando o valor da posição desjada
    * (matriz[v][w]) de 1 para 0. Por se tratar de um grafo direcionado, apenas a
    * a posição de (matriz[v][w]) será alterada. Tem complexidade O=1
    * @param  v  o vértice de origem.
    * @param  w  o vértice de entrada.
    */
    public void removeAresta(int v, int w){
        matrizAdjacenia[v][w] = 0;
    }

    public int retornaGrauEntrada(int v){
        int contador = 0;
        for (int i = 0; i < numVertices; i++) {
            contador += matrizAdjacenia[i][v];
        }
        return contador;
    }

    public int retornaGrauSaida(int v){
        int contador = 0;
        for (int i = 0; i < numVertices; i++) {
            contador += matrizAdjacenia[v][i];
        }
        return contador;
    }

    public ArrayList<Integer> retornaSucessores(int v){
        ArrayList<Integer> listaDeSucessores = new ArrayList<Integer>();
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacenia[v][i] == 1){
                listaDeSucessores.add(i);
            }
        }

        return listaDeSucessores;
    }

    
    public ArrayList<Integer> retornaPredecessores(int v){
        ArrayList<Integer> listaDeAntecessores = new ArrayList<Integer>();
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacenia[i][v] == 1){
                listaDeAntecessores.add(i);
            }
        }       

        return listaDeAntecessores;
    }
}
