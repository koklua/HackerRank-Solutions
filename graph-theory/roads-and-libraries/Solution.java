import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    //in order to provide library access for n cities, there must be l libraries and n-l roads
    //if the cost of a road is less than or equal to the cost of a road, simply build n libraries
    //if the cost of a road is more than the cost of a library, find number of connected components and build 1 library for each component
    //use array of linked lists to represent roads

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int set = 0; set < q; set++){
            int n = in.nextInt();
            int m = in.nextInt();
            long cost_lib = in.nextLong();
            long cost_road = in.nextLong();
            if(cost_lib <= cost_road || m == 0){
                while(m > 0){
                    in.nextInt();
                    in.nextInt();
                    m--;
                }
                System.out.println(cost_lib*n);
                continue;
            }
            int components = 0;
            Boolean[] visited = new Boolean[n+1];
            Arrays.fill(visited, false);
            LinkedList<Integer>[] adjacency = new LinkedList[n+1];
            for(int index = 1; index <= n; index++)
                adjacency[index] = new LinkedList<Integer>();
            for(int road = 0; road < m; road++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                adjacency[city_1].add(city_2);
                adjacency[city_2].add(city_1);
            }
            for (int city = 1; city <= n; city++){
                if (visited[city] == false){
                    componentSearch(city, visited, adjacency);
                    components++;
                }
            }
            long total = components * cost_lib + (n - components) * cost_road;
            System.out.println(total);
        }
    }
    
    //depth first graph search to find components
	//tag vertex as found, then call the method again for adjacent vertices
    public static void componentSearch(int vertex, Boolean[] found, LinkedList<Integer>[] edges){
        found[vertex] = true;
        for(Integer element : edges[vertex]){
            if(found[element] == false){
                componentSearch(element, found, edges);
            }
        }
    }
    
    
}
