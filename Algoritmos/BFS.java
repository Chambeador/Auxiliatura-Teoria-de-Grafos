package Algoritmos;

import java.util.*;
public class BFS{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> []grafo = new ArrayList[n];
        for(int i = 0; i < n; i++){
            grafo[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++){
            int nodo1 = sc.nextInt();
            int nodo2 = sc.nextInt();
            grafo[nodo1].add(nodo2);
            grafo[nodo2].add(nodo1);
        }
        
        boolean [] vis = new boolean[n];
        int [] distancia = new int[n];
        for(int i = 0; i < n; i++){
            distancia[i] = 0;
            vis[i] = false;
        }
        
        Queue<Integer> cola = new LinkedList<>();
        int nodoInicial = 0;
        cola.add(nodoInicial);
        while(!cola.isEmpty()){
            int nodo = cola.poll();
            vis[nodo] = true;
            for(int vecino: grafo[nodo]){
                if(vis[vecino] == false){
                    vis[vecino] = true;
                    distancia[vecino] = distancia[nodo]+1;
                    cola.add(vecino);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            System.out.println("la distancia al nodo "+i+" es igual a "+distancia[i]);
        }
        
    }
    
    public static void dfs(int nodoU, ArrayList<Integer>[] grafo, boolean [] vis){
        if(vis[nodoU] == false){
            System.out.print(nodoU+" --> ");
        }
        vis[nodoU] = true;
        for(int vecino: grafo[nodoU]){
            if(vis[vecino] == false){
                dfs(vecino, grafo, vis);
            }
        }
    }
}