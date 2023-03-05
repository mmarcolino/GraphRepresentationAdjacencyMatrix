import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        String path;
        int numeroDeVertices = 0;
        int vertice = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o caminho do arquivo: ");
        path = scanner.nextLine();  
        try {
            File file = new File(path);
            Scanner leitor = new Scanner(file);
            numeroDeVertices = Integer.parseInt(leitor.nextLine().split("  ")[0]);
            Grafo grafo = new Grafo(numeroDeVertices);
            while (leitor.hasNextLine()) {
              String[] vertices = leitor.nextLine().strip().split("\\s+");
              grafo.adicionaAresta(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]));
            }
            leitor.close();
            while (Integer.parseInt(scanner.nextLine()) != 0) {
                System.out.print("Insira o vértice a ser consultado: ");
                vertice = Integer.parseInt(scanner.nextLine()); 
                System.out.println("grau de entrada: " + grafo.retornaGrauEntrada(vertice));
                System.out.println("grau de saída: " + grafo.retornaGrauSaida(vertice));
                System.out.println("conjunto de sucessores: " + grafo.retornaSucessores(vertice));
                System.out.println("conjunto de predecessores: " + grafo.retornaPredecessores(vertice));
            }
            scanner.close();
          } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
          }

    }
}
