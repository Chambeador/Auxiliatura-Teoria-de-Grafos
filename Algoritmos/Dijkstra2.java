package Algoritmos;

import java.util.*;

public class Dijkstra2{
    
     static class Arista{
         int nodo;
         int peso;
         public Arista(int n, int p){
             nodo = n;
             peso = p;
         }
     }
     
    static class NodoD implements Comparable<NodoD>{
        int peso;
        int nodo;
    
        public NodoD(int p, int n){
            peso = p;
            nodo = n;
        }
    
        @Override
        public int compareTo(NodoD otro){
            if(otro.peso == this.peso){
                return Integer.compare(this.nodo, otro.nodo);
            }
            return Integer.compare(this.peso, otro.peso);
        }
    }
      public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int m = sc.nextInt();
          ArrayList<Arista>[] g = new ArrayList[n];
          for(int i = 0; i < n; i++){
              g[i] = new ArrayList<>();    
          }
          
          for(int i = 0; i < m; i++){
              int u,v,w; 
              u = sc.nextInt();
              v = sc.nextInt();
              w = sc.nextInt();
              g[u].add(new Arista(v, w));
              g[v].add(new Arista(u,w));
          }
          
          
          //hacer dijkstra
          int INF = 10000000;
          TreeSet<NodoD> estruc = new TreeSet<NodoD>();
          int dist[] = new int[n];
          for(int i = 0;i < n; i++){
              dist[i] = INF;
          }
          int nodoInicial = 0;
          dist[nodoInicial] = 0;
          estruc.add(new NodoD(0, nodoInicial));
          while(estruc.isEmpty() == false){
                NodoD aux = estruc.first();
                estruc.remove(aux);
                int nodito = aux.nodo;
                int distancia = aux.peso;
                for(Arista a: g[nodito]){
                    int vecino = a.nodo;
                    int pesitoArista = a.peso;
                    if(distancia+pesitoArista < dist[vecino]){
                        estruc.remove(new NodoD(dist[vecino], vecino));
                        dist[vecino] = distancia+pesitoArista;
                        estruc.add(new NodoD(dist[vecino], vecino));
                    }
                }
          }
            
            
          for(int i = 0;i < n; i++){
              
                System.out.println("nodo: "+i+" su distancia es: "+dist[i]);
          }  
            
            
        }
}
