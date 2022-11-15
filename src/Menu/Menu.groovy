package Menu

import Graph.Graph

abstract class Menu<T> {
    Map<String, MenuFunction<T>> commands = new HashMap<>()

    protected Map<String, MenuFunction<Graph>> getCommands() {
        commands as Map<String, MenuFunction<Graph>>
    }
    protected void setCommands(Map<String, MenuFunction<Graph>> commands) {
        this.commands = commands as Map<String, MenuFunction<T>>
    }

    abstract void run()

}
