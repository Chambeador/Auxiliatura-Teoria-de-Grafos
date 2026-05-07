#include<bits/stdc++.h>

using namespace std;



vector<int>  topSort(vector<vector<int>> &g, vector<int>&gradoEntrada){
    queue<int> cola;
    for(int i = 0; i < g.size(); i++){
        if(gradoEntrada[i] == 0) cola.push(i);
    }
    vector<int> ans;
    while(!cola.empty()){
        int nodo = cola.front();
        ans.push_back(nodo);
        cola.pop();
        for(auto &v: g[nodo]){
            gradoEntrada[v]--;
            if(gradoEntrada[v] == 0){
                cola.push(v);
            }
        }
    }
    return ans;
}
signed main(){ //public static void main(String args)
    int n,m;
    cin>>n>>m; //Scanner.nextInt() Scanner.nextInt()
    vector<int> gradoEntrada(n, 0);
    vector<vector<int>> g(n); //ArrayList<Integer> []
    for(int i = 0; i < m; i++){
        int u,v; cin>>u>>v; u--,v--;
        gradoEntrada[v]++;
        g[u].push_back(v); //g[u].add(v)
    }
    //ya tengo el grafo construido  lo que tenemos que hacer 
    //es aplicar el algoritmo topSort

    vector<int> ans = topSort(g, gradoEntrada);
    if(ans.size() != n){
        cout<<"IMPOSSIBLE"<<endl;
    }else{
        for(int &x: ans){
            cout<<x+1<<" ";
        }
    }
}