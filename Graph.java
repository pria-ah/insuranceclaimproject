
import java.util.*;

class Graph {

    static Map<String, List<String>> graph = new HashMap<>();

    static void addEdge(String a, String b) {
        graph.putIfAbsent(a, new ArrayList<>());
        graph.putIfAbsent(b, new ArrayList<>());
        graph.get(a).add(b);
    }

    static void bfs(String start, String end) {

        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();

        q.add(start);
        parent.put(start, null);

        while (!q.isEmpty()) {

            String node = q.poll();

            if (node.equals(end)) {
                List<String> path = new ArrayList<>();

                while (node != null) {
                    path.add(node);
                    node = parent.get(node);
                }

                Collections.reverse(path);
                System.out.println("Shortest Path: " + path);
                return;
            }

            for (String next : graph.get(node)) {
                if (!parent.containsKey(next)) {
                    parent.put(next, node);
                    q.add(next);
                }
            }
        }

        System.out.println("Path Not Found");
    }

    static boolean dfs(String node, Set<String> visited,
                       Set<String> path) {

        visited.add(node);
        path.add(node);

        for (String next : graph.get(node)) {

            if (path.contains(next))
                return true;

            if (!visited.contains(next) &&
                dfs(next, visited, path))
                return true;
        }

        path.remove(node);
        return false;
    }

    public static void main(String[] args) {

        addEdge("Registration", "Assessment");
        addEdge("Assessment", "Surveyor");
        addEdge("Surveyor", "Settlement");

        bfs("Registration", "Settlement");

        boolean cycle = dfs("Registration",
                            new HashSet<>(),
                            new HashSet<>());

        System.out.println("Cycle Found: " + cycle);
    }
}
