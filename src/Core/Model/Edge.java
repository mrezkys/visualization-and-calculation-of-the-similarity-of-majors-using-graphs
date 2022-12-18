package Core.Model;

public class Edge{
    Edge next;
    Edge prev;
    double similiarity = 0;
    Vertex destination;
    public Edge(Vertex destination, double similiarity){
        this.destination = destination;
        this.similiarity = similiarity;
    }


}