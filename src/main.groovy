Graph graph = new Graph()

graph.putNode("a")
graph.putNode("b")
graph.putNode("c")
graph.putNode("d")
graph.putNode("e")

graph.putEdge("a", "b")
graph.putEdge("b", "d")
graph.putEdge("a", "c")
graph.putEdge("d", "e")

graph.print()

graph.dfs("a")

graph.bfs("a")





