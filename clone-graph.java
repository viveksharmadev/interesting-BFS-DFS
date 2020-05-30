// https://leetcode.com/problems/clone-graph/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class clone-graph {
    // tc -> n, sc-> n
    Map<Node, Node> cache = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        if(cache.containsKey(node)){           
            return cache.get(node);
        }else{
            Node clone = new Node(node.val, new ArrayList<>());
            cache.put(node, clone);
            for(int i=0; i<node.neighbors.size(); i++){
                clone.neighbors.add(cloneGraph(node.neighbors.get(i)));
            }
            return clone;
        }
    }
}
