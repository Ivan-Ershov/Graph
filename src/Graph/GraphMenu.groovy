package Graph

import Menu.Menu

class GraphMenu extends Menu<Graph> {
    Scanner input = new Scanner(System.in)
    Graph graph = new Graph()
    boolean isRun = false

    private Scanner getInput() {input}
    private void setInput(Scanner input) {this.input = input}
    private Graph getGraph() {graph}
    private void setGraph(Graph graph) {this.graph = graph}
    private boolean getIsRun() {isRun}
    private void setIsRun(boolean isRun) {this.isRun = isRun}

    GraphMenu() {
        putAddNode()
        putAddEdge()
        putRemoveNode()
        putRemoveEdge()
        putPrint()
        putDFS()
        putBFS()
        putHelp()
        putExit()
    }

    private void putAddNode() {
        commands.put("add_node", {
            print "Please enter node id: "
            String id = input.nextLine()

            graph.putNode(id)

        })
    }

    private void putAddEdge() {
        commands.put("add_edge", {
            print "Please enter node id1: "
            String id1 = input.nextLine()
            print "Please enter node id2: "
            String id2 = input.nextLine()

            graph.putEdge(id1, id2)

        })
    }

    private void putRemoveNode() {
        commands.put("remove_node", {
            print "Please enter node id: "
            String id = input.nextLine()

            graph.removeNode(id)

        })
    }

    private void putRemoveEdge() {
        commands.put("remove_edge", {
            print "Please enter node id1: "
            String id1 = input.nextLine()
            print "Please enter node id2: "
            String id2 = input.nextLine()

            graph.removeEdge(id1, id2)

        })
    }

    private void putPrint() {
        commands.put("print", {
            graph.print()
        })
    }

    private void putDFS() {
        commands.put("dfs", {
            print "Please enter node id: "
            String id = input.nextLine()

            graph.dfs(id)

        })
    }

    private void putBFS() {
        commands.put("bfs", {
            print "Please enter node id: "
            String id = input.nextLine()

            graph.bfs(id)

        })
    }

    private void putHelp() {
        commands.put("help", {
            print "\"help\" - print all function with a description.\n\
                     |\"exit\" - terminate the program.\n\
                     |\"add_node\" - put node into graph.\n\
                     |\"add_edge\" - put edge into graph.\n\
                     |\"remove_node\" - remove node from graph.\n\
                     |\"remove_edge\" - remove edge from graph.\n\
                     |\"print\" - print graph.\n\
                     |\"dfs\" - run dfs.\n\
                     |\"bfs\" - run bfs.\n".stripMargin()
        })
    }

    private void putExit() {
        commands.put("exit", {isRun = false})
    }

    void run() {
        isRun = true

        while (isRun) {
            print "Please enter command: "
            String command = input.nextLine()

            try {
                this.commands[command](graph)
            } catch (any) {
                println any.message
            }

        }
    }


}
