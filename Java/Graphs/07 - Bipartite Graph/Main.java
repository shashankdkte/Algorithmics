/**
 * u, v vertices forming edge will be in two seperate sets ->  Bipartite
 * 
 * BFS Based
 * -1 : no color
 * 0  : yellow
 * 1  : blue
 * 
 * 
 * Case 1: neighbour.color == true   neighbour.color == curr.color  return false
 * Case 2: neighbour.color == true  neighbour.color != curr.color  return true
 * Case 3: neighbout.color == false  neighbour.color = !curr.color   + push in Queue 
 * O(V) -> Space Complexity
 * 
 * Acyclic graph is bipartite
 * Even cycle graph -> True
 * Odd cycle graph -> False
 */