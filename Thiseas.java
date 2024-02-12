import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;



public class Thiseas {

    //tsekari ta akra gia eksodo
    static boolean solve(int i,int j,int n,int m,String [][] maze)
    {
        if(maze[i][j].equals("0"))  {
            if(i == 0) {return true;}
            if(i == n-1){return true;}
            if(j == 0){return true;}
            if(j == m-1){return true;}
        }


        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //create to stack for x and y coords
        StringStackImpl stackX = new StringStackImpl();
        StringStackImpl stackY = new StringStackImpl();


        int n, m;
        int s_x, s_y;
        String line;

        String maze[][];//create a 2d array
        Scanner scpath = new Scanner(System.in);

        String path = scpath.next();


        //eisagwgei txt file

        //file reader
        String filename = path;
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        Scanner scanner = new Scanner(file);

        //read the elements of txt file
        line = scanner.next();
        n = Integer.parseInt(line);
        line = scanner.next();
        m = Integer.parseInt(line);


        line = scanner.next();

        s_x = Integer.parseInt(line);

        line = scanner.next();

        s_y = Integer.parseInt(line);


        maze = new String[n][m];
        boolean visited[][] = new boolean[n][m];//create a visited 2d array with true and false.


        //check
        if ( ((s_x <= (n - 1)) && (s_x >= 0)) && ((s_y >= 0) && (s_y <= (m - 1)))) {
            for (int i = 0; i <= (n - 1); i++)//create a maze
            {
                for (int j = 0; j <= (m - 1); j++) {
                    line = scanner.next();
                    maze[i][j] = line;
                    visited[i][j] = false;

                }
            }



            visited[s_x][s_y] = true;


            stackX.push(String.valueOf(s_x));
            stackY.push(String.valueOf(s_y));





            int x, y;


            x = Integer.parseInt(stackX.peek());
            y = Integer.parseInt(stackY.peek());
            //System.out.println(x + " , " + y);
            boolean solved = false; //flag
            while (solved == false) {

                if(!stackY.isEmpty()&& !stackX.isEmpty()) {
                    //right
                    if (maze[x][y + 1].equals("0") && (!visited[x][y + 1]) && (y + 1 != n)) {
                        stackX.push(String.valueOf(x));
                        stackY.push(String.valueOf(y + 1));
                        maze[x][y] = "S";
                        visited[x][y + 1] = true;


                    }//down
                    else if (maze[x + 1][y].equals("0") && (!visited[x + 1][y]) && (x + 1 != n)) {
                        stackX.push(String.valueOf(x + 1));
                        stackY.push(String.valueOf(y));
                        maze[x][y] = "S";
                        visited[x + 1][y] = true;


                    } else if (maze[x][y - 1].equals("0") && (!visited[x][y - 1]) && (y - 1 != -1)) {
                        stackX.push(String.valueOf(x));
                        stackY.push(String.valueOf(y - 1));
                        maze[x][y] = "S";
                        visited[x][y - 1] = true;


                    } else if ((x - 1 != -1) && maze[x - 1][y].equals("0") && (!visited[x - 1][y])) {
                        stackX.push(String.valueOf(x - 1));
                        stackY.push(String.valueOf(y));
                        maze[x][y] = "S";
                        visited[x - 1][y] = true;


                    } else {
                        if (!maze[x][y].equals("E")) {
                            maze[x][y] = "X";

                            stackX.pop();
                            stackY.pop();
                        }
                    }
                }
//bimatismos
                if (!stackX.isEmpty() && (!stackY.isEmpty())){
                    x = Integer.parseInt(stackX.peek());
                    y = Integer.parseInt(stackY.peek());
                    //System.out.println(x + " , " + y);
                    solved = solve(x, y, n, m, maze);
                }
                if(maze[s_x][s_y].equals("X"))
                {
                    solved = true;
                }




            }

            if(x == s_x && y == s_y)
            {
                System.out.println("there is no exit");
            }else {



                System.out.println("coordinates of exit " + stackX.peek() + " , " + stackY.peek());



            }




        }else {
            System.out.println("Error .Elements are out of bounds!");
        }




    }










}

