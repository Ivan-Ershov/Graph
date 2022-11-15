package Graph

class Graph {

    LinkedHashMap<String, TreeSet<String>> data = new LinkedHashMap<>()

    private LinkedHashMap<String, TreeSet<String>> getData() { data }

    private void setData(LinkedHashMap<String, TreeSet<String>> data) {}

    private void checkIsNode(String id) {
        if (!data.containsKey(id)) {
            throw new IllegalArgumentException("!Not found ${id}!")
        }
    }

    private void checkIsNotNode(String id) {
        if (data.containsKey(id)) {
            throw new IllegalArgumentException("!Node ${id} exists!")
        }
    }

    private void checkIsEdge(String id1, String id2) {
        if (!data[id1].contains(id2)) {
            throw new IllegalArgumentException("!Not found edge (${id1}, ${id2})!")
        }
    }

    private void checkIsNotEdge(String id1, String id2) {
        if (data[id1].contains(id2)) {
            throw new IllegalArgumentException("!Edge (${id1}, ${id2}) exists!")
        }
    }

    void putNode(String id) {

        checkIsNotNode(id)

        data.put(id, new TreeSet<String>())

    }

    void putEdge(String id1, String id2) {

        checkIsNode(id1)
        checkIsNode(id2)
        checkIsNotEdge(id1, id2)

        data[id1] << id2
        data[id2] << id1

    }

    void removeNode(String id) {

        checkIsNode(id)

        data.remove(id).each { data[it].remove(id) }

    }

    void removeEdge(String id1, String id2) {

        checkIsNode(id1)
        checkIsNode(id2)
        checkIsEdge(id1, id2)

        data[id1].remove(id2)
        data[id2].remove(id1)

    }

    void print() {
        for (entry in data) {
            println "${entry.key}: ${entry.value}"
        }
    }

    private void dfs_visit(String id, Set<String> visited) {

        if (visited.contains(id)) {
            return
        }

        visited << id

        data[id].each {dfs_visit(it, visited)}

    }

    void dfs(String id) {

        checkIsNode(id)

        Set<String> visited = new LinkedHashSet<>()

        dfs_visit(id, visited)

        println visited

    }

    void bfs(String id) {
        Set<String> visited = new LinkedHashSet<>()
        Queue<String> queue = new LinkedList<>()
        queue << id

        while (queue) {

            String cur = queue.remove()

            visited << cur

            data[cur].each {
                if(!visited.contains(it)) {
                    queue << it
                }
            }

        }

        println visited

    }

    @Override
    String toString() {
        data
    }

}
