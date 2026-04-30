#include<bits/stdc++.h>
#define int long long
using namespace std;


struct DSU{
    int n; 
    vector<int> p;
    DSU(int n): n(n), p(n, -1){};

    int find(int u){
        if(p[u] == -1) return u;
        return p[u] = find(p[u]);
    }
    //path compression
    int join(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return 0;
        p[pv] = pu;
        return 1;
    }
};



struct Edge{
    int u,v,w;
    bool operator<(const Edge& other) const{
        return w < other.w;
    }
};


signed main(){
    int n,m;
    cin>>n>>m;
    vector<Edge> edges;
    for(int i=0;i<m;i++){
        int u,v,w;
        cin>>u>>v>>w;
        edges.push_back({u,v,w});
    }
    sort(edges.begin(), edges.end());
    DSU dsu(n+1);
    int cost = 0;
    int cant = 0;
    for(auto e: edges){
        if(dsu.join(e.u,e.v)){   
            cost += e.w;
            cant++;
        }
    }
    if(cant != n-1){
        cout<<"IMPOSSIBLE"<<endl;
    }else cout<<cost<<endl;

}