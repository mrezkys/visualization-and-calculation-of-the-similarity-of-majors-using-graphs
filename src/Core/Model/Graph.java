package Core.Model;


import java.util.ArrayList;
import java.util.List;

public  class Graph{
    public Vertex head;
    public int size = 0;
    public List<Vertex> getVertices() {
        List<Vertex> vertices = new ArrayList<>();
        Vertex current = head;
        while (current != null) {
            vertices.add(current);
            current = current.next;
        }
        return vertices;
    }



    public void insert(String name){
        Vertex newVertex = new Vertex(name);
        if (isEmpty()){
            head = newVertex;
        } else {
            Vertex lastVertex = head;
            while (lastVertex.next != null){
                lastVertex = lastVertex.next;
            }
            lastVertex.insert(newVertex);
        }
        size++;
    }

    public void insertEdge(String from, String to, double similiarity){
        Vertex fromGC = searchGraphContainer(from);
        Vertex toGC = searchGraphContainer(to);

        if (fromGC == null) {
            System.out.println("from tidak ditemukan");
        } else if(toGC == null){
            System.out.println("to tidak ditemukan");
        } else {
            fromGC.insertEdge(toGC, similiarity);
        }

    }

    public void insertTopics(String target, List<String> newTopics){
        Vertex targetVertex = searchGraphContainer(target);
        targetVertex.insertTopics(newTopics);
    }

    Vertex searchGraphContainer(String target){
        Vertex temp = head;
        while (temp != null){
            if (temp.name == target){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean isEmpty(){
        return  head == null;
    }

    public void printAll(){
        Vertex pivot = head;
        System.out.println("\nGRAPH DATA");
        while (pivot != null){
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Graph Container " + pivot.name + "\nEdge ( Relation ) will created if similarity > 0.0 : ");
            System.out.println("-------------------");
            System.out.println("List Edge : ");
            pivot.listEdge.printAll();
            System.out.println("---------------------------------------------------------------------------------\n");
            pivot = pivot.next;
        }
    }

}