import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution{
	public List<Integer> toposort(int n,int[][] edges){
		List<Integer> res=new ArrayList<>();
		//ajacent list of node i will be put at pos i of graph
		List<List<Integer>> graph=new ArrayList<>();
		int[] indegree=new int[n];
		Deque<Integer> q=new LinkedList<>();
		
		//initialize graph with ajacent list representation, and fill the indegree array
		for(int i=0;i<n;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(int[] e:edges){
			graph.get(e[0]).add(e[1]);
			indegree[e[1]]++;
		}
		
		//those with indegree 0 enqueue
		for(int i=0;i<indegree.length;i++){
			if(indegree[i]==0){
				q.offer(i);
			}
		}
    
    
		while(!q.isEmpty()){
			Integer i=q.poll();
			res.add(i);
			List<Integer> tmp=graph.get(i);
			indegree[i]=-1;
			for(Integer j:tmp){
			  //update indegree of those ajacent to current node i
				indegree[j]--;
				if(indegree[j]==0){
				q.offer(j);
				}
			}
		}

		return res;
	}

	public static void main(String[] args){
		Solution s=new Solution();
		int[][] edges={{5,0},{4,0},{5,2},{4,1},{2,3},{3,1}};
		System.out.println(s.toposort(6,edges));
	}
}
