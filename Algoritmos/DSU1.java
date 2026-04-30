package Algoritmos;
public class DSU1 {
    private int n;
    int []padre;
    public DSU1(int n){
        this.n = n;
        padre = new int[n];
        for(int i = 0; i < n; i++){
            padre[i] = i;
        }
    }

    public int find(int u){
        if(padre[u] == u) return u;
        return find(padre[u]);
    }

    public int join(int u, int v){
        int padreU = find(u);
        int padreV = find(v);
        if(padreU != padreV){
            padre[padreU] = padreV;
            return 1;
        }
        return 0;   

    }

}
