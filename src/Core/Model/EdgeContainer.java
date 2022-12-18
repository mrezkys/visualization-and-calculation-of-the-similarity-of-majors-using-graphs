package Core.Model;

public class EdgeContainer {
    public Edge head;
    Edge tail;

    public void  addLast(Vertex destination, double similiarity){
        Edge newEdge = new Edge(destination, similiarity);
        if (isEmpty()) head = tail = newEdge;
        else {
            Edge last = getLast();
            newEdge.prev = last;
            last.next = newEdge;
            tail = newEdge;
        }
    }

    private boolean isEmpty(){
        return (head == null);
    }

    private Edge getLast(){
        Edge current = head;
        while (current.next != null){
            current = current.next;
        }
        return current;
    }

    void printAll(){
        Edge edge = head;
        while (true){
            if(edge != null) {
                System.out.println(edge.destination.name + " with Similarity : " + edge.similiarity);
                edge = edge.next;
            }
            else break;
        }
    }
}
