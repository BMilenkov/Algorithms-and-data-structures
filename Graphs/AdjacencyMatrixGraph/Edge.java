package Graphs.AdjacencyMatrixGraph;

public class Edge {
    private int fromVertex;
    private int toVertex;
    private int weight;

    public Edge(int from, int to, int weight) {
        this.fromVertex = from;
        this.toVertex = to;
        this.weight = weight;
    }

    public int getFrom() {
        return this.fromVertex;
    }

    public int getTo() {
        return this.toVertex;
    }

    public int getWeight() {
        return this.weight;
    }
}
