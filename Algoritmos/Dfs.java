package Algoritmos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Dfs {
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
        
        //DFS USANDO UNA PILA
        Stack<Integer> pila = new Stack<>();
        boolean [] vis = new boolean[n];
        int nodoInicial = 2;
        pila.push(nodoInicial);
        while(!pila.empty()){
            int nodo = pila.pop();
            if(vis[nodo] == false){
                System.out.print(nodo + " --> ");
            }
            vis[nodo] = true;
            for(int vecino: grafo[nodo]){
                if(vis[vecino] == false){
                    pila.push(vecino);
                }
            }
         
        }
    }
}
