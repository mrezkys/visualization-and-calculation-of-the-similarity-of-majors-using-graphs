package BasicGraph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    String name;
    Vertex next;
    ArrayList<String> topics = new ArrayList<>();
    EdgeContainer listEdge = new EdgeContainer();

    Vertex(String name){
        this.name = name;
    }

    public void insert(Vertex vertex){
       next = vertex;
    }
    public void insertTopics(String[] newTopics){
        topics.addAll(List.of(newTopics));
    }
    public void insertEdge(Vertex targetVertex, double similiarity){
        listEdge.addLast(targetVertex, similiarity);
    }

    public String getTopicString() {
        return String.join(" ", topics);
    }

    public void addEdge(Edge edge) {
        listEdge.addLast(edge.destination, edge.similiarity);
    }





}