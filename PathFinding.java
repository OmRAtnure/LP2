import java.util.*;

class Node{
    int row,col;
    int g;
    Node parent;

    public Node(int row, int col, int g, Node parent) {
        this.row = row;
        this.col = col;
        this.g = g;
        this.parent = parent;
    }



    int f() {
        return g+PathFinding.hueristic(row,col);
    }
}

public class PathFinding{
    static int [][] maze={
            {0,0,0,1,0},
            {1,1,0,1,1},
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,1,1,1,0}
    };
    static int goalRow=4;
    static int goalCol=4;
    static int rows = maze.length;
    static int cols = maze[0].length;


    public static int  hueristic(int row,int col) {
        return Math.abs(row-goalRow) + Math.abs(col-goalCol);
    }

    public static void main(String[] args) {
        PriorityQueue<Node> open=new PriorityQueue<>(Comparator.comparingInt(Node::f));

        boolean [][]visited=new boolean[rows][cols];

        Node start=new Node(0,0,0,null);
        open.add(start);
        while (!open.isEmpty()) {
            Node current=open.poll();
            int r=current.row;
            int c=current.col;

            if(visited[r][c]) {
                continue;
            }
            visited[r][c]=true;

            if(r==goalRow && c==goalCol) {
                System.out.println("Path found");
                printPath(current);
                return;
            }

            int [][]moves={
                    {1,0},
                    {-1,0},
                    {0,1},
                    {0,-1}
            };
            for(int[]move:moves) {
                int newRow=r+move[0];
                int newCol=c+move[1];

                if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols
                && maze[newRow][newCol]==0 && !visited[newRow][newCol]) {
                    int newG=current.g+1;
                    Node next=new Node(newRow,newCol,newG,current);
                    open.add(next);
                }
            }
        }
    }

    static void printPath(Node current) {
        List<Node> path=new ArrayList<>();
        Node temp=current;
        while (temp!=null) {
            path.add(temp);
            temp=temp.parent;
        }
        Collections.reverse(path);
        for(Node node:path) {
            System.out.println(
                    "(" + node.row + ", " + node.col + ")"
            );
        }
    }
}