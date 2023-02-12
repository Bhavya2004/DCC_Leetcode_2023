import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Shortest {
    List<List<Integer>> buildGraph(int [][] roads,int V){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int [] road:roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        return adj;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        int V=roads.length+1;
        List<List<Integer>> adj=buildGraph(roads,V);
        Queue<Integer> q=new LinkedList<>();
        
		//Storing total edges of a node using which we will traverse the tree,
		//If a non zero node have 1 edge then that node is kind of a leaf and we can take it
        int [] edges=new int[V];
        for(int i=0;i<V;i++){
            edges[i]=adj.get(i).size();
            if(i!=0&&edges[i]==1)
                q.add(i);
        }
    
        long fuel=0;
		//Storing total person on each node initially 1 person is at every node
        int [] totalMen=new int[V];
        Arrays.fill(totalMen,1);
        while(!q.isEmpty()){
            int u=q.remove();
			//Travelling from u to v,
			//There will be only 1 valid node wich will satisfy edges[v]>0 as u has only 1 valid edge
            for(int v:adj.get(u)){
			   // A visited node will have 0 edges as we are decreasing no of nodes for both src and dest,
			   //after visiting each node
                if(edges[v]>0){
                    int cars=totalMen[u]/seats;
                    if(totalMen[u]%seats!=0)
                        cars++;
				   // From node u to node v we need " petrol equal to no. of cars required
                    fuel+=cars;
					//All people from node u now have reached to node v, so to remember that we are 
					//incrementing it
                    totalMen[v]+=totalMen[u];
                    edges[v]--;
                    edges[u]--;
					//Only add those nodes which are non-root and have become leaf now i.e., 
					//only on one way they can go(That path will eventually make it meet root node)
                    if(v!=0&&edges[v]==1)
                        q.add(v);
                }
            }
        }
        
        return fuel;
    }
}