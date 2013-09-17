package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
	
	public static void computePaths(Vertex source){
		//start condition - source minDistance=0
		source.minDistance=0;
		//visit each vertex u, always visiting vertex with smallest minDistance first
		PriorityQueue<Vertex> vertexQueue=new PriorityQueue<Vertex>();
		vertexQueue.add(source);
		while(!vertexQueue.isEmpty()){
			Vertex u = vertexQueue.poll();
			System.out.println("For: "+u);
			for (Edge e: u.adjacencies){
				Vertex v = e.target;
				System.out.println("Checking: "+u+" -> "+v);
				double weight=e.weight;
				//relax the edge (u,v)
				double distanceThroughU=u.minDistance+weight;
				if(distanceThroughU<v.minDistance){
					System.out.println("Updating minDistance to "+distanceThroughU);
					v.minDistance=distanceThroughU;
					v.previous=u;
					//move the vertex v to the top of the queue
					vertexQueue.remove(v);
					vertexQueue.add(v);
				}
			}
		}
	}
	
	public static List<Vertex> getShortestPathTo(Vertex target){
		List<Vertex> path=new ArrayList<Vertex>();
		for (Vertex vertex=target; vertex!=null; vertex=vertex.previous){
			path.add(vertex);
		}
		Collections.reverse(path);
		return path;
		
	}
	/**
	 * 	 /-10-- B --2-- D
	 *  /      | ^    ^ ^ | 
	 * A       1 4  /8  9 7
	 *  \      v |/     | v
	 *   \-3--- C --3--- E 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");

		A.adjacencies = new Edge[]{ new Edge(B, 10),	new Edge(C, 3) };
		B.adjacencies = new Edge[]{	new Edge(C, 1), 	new Edge(D, 2)};
		C.adjacencies = new Edge[]{ new Edge(B, 4), 	new Edge(D, 8),	new Edge(E, 2)};
		D.adjacencies = new Edge[]{ new Edge(E, 7)};
		E.adjacencies = new Edge[]{ new Edge(D, 9)};
		Vertex[] vertices = { A,B,C,D,E };
		
		computePaths(A);
		
		for (Vertex v : vertices)
		{
		    System.out.println("Distance to " + v + ": " + v.minDistance);
		    List<Vertex> path = getShortestPathTo(v);
		    System.out.println("Path: " + path);
		}
	}

}
