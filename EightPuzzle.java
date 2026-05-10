import java.util.*;

class Node{
    int [][] state;
    int g,h;

    Node(int [][] state,int g,int h) {
        this.state=state;
        this.g=g;
        this.h=h;
    }

    int f() {
        return g+h;
    }

}

public class EightPuzzle{
    static int [][] goal ={
            {1,2,3},
            {4,5,6},
            {7,8,0}
    };

    static int huerisitc(int [][] state) {
        int misplaced=0;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(state[i][j]!=0 && state[i][j] != goal[i][j]) {
                    misplaced++;
                }
            }
        }
        return misplaced;
    }

    static void printState(int [][] state) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(state[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] start={
                {1,2,3},
                {4,0,5},
                {8,6,7}
        };

        PriorityQueue<Node> open=new PriorityQueue<>(Comparator.comparingInt(Node::f));
        Node startNode=new Node(start,0,huerisitc(start));

        open.add(startNode);

        int [][]moves={
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while(!open.isEmpty()) {
             Node current=open.poll();
            System.out.println("Current State:");
            printState(current.state);

            if(Arrays.deepEquals(current.state,goal)) {
                System.out.println("Goal reached");
                return;
            }
            int x=0;
            int y=0;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if(current.state[i][j]==0) {
                        x=i;
                        y=j;
                    }
                }
            }
            for(int []move:moves) {
                int newX=x+move[0];
                int newY=y+move[1];

                if(newX<3 && newX>=0 && newY<3 && newY>=0) {
                    int [][]newState=new int[3][3];

                    for(int i=0;i<3;i++) {
                        newState[i]=current.state[i].clone();
                    }

                    newState[x][y]=newState[newX][newY];
                    newState[newX][newY]=0;

                    Node newNode=new Node(newState,current.g+1,huerisitc(newState));
                    open.add(newNode);
                }
            }
        }

    }
}
