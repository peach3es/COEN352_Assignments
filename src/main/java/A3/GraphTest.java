package A3;



// Graph operation main function.
// To use: java -ea GraphTest <graphfile>

import java.io.*;
import java.util.*;

public class GraphTest {

	static final int UNVISITED = 0;
	static final int VISITED = 1;
	
	// Create a graph from file
	static Graph createGraph(BufferedReader file, Graph G) 
	throws IOException 
	{
			  String line = null;
			  StringTokenizer token;
			  boolean undirected = false;
			  int i, v1, v2, weight;
			
			  assert (line = file.readLine()) != null :
			         "Unable to read number of vertices";
			  while(line.charAt(0) == '#')
			  assert (line = file.readLine()) != null :
			         "Unable to read number of vertices";
			  token = new StringTokenizer(line);
			  
			  int n = Integer.parseInt(token.nextToken());
			  G.Init(n);
			  
			  for (i=0; i<n; i++)
			    G.setMark(i, UNVISITED);
			  
			  assert (line = file.readLine()) != null :
			         "Unable to read graph type";
			  
			  if (line.charAt(0) == 'U')
			    undirected = true;
			  else if (line.charAt(0) == 'D')
			    undirected = false;
			  else assert false : "Bad graph type: " + line;
			
			  // Read in edges
			  while((line = file.readLine()) != null) {
				token = new StringTokenizer(line);
			    v1 = Integer.parseInt(token.nextToken());
			    v2 = Integer.parseInt(token.nextToken());
			    weight = v1;
			    G.setEdge(v1, v2, weight);
			    if (undirected) // Put in edge in other direction
			      G.setEdge(v2, v1, weight);
			  }
			  return G;
	}


}

