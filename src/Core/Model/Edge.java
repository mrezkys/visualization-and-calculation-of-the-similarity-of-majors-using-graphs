package Core.Model;

public class Edge{
    public Edge next;
    Edge prev;
    double similiarity = 0;
    public Vertex destination;
    public Edge(Vertex destination, double similiarity){
        this.destination = destination;
        this.similiarity = similiarity;
    }

    public String getSimilarityString() {
        return String.format("%.2f", similiarity);
    }


}