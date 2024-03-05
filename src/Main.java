import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the grid size (input one number - the side of the grid): ");
        int size = scan.nextInt();

        Grid grid = Grid.create(size);
        System.out.println("Congrats! Setup is successful.");
        System.out.println(grid);



        while (true) {
            while(true) {
                System.out.println("What cell do you want to change? Input its coordinates. (Input negative to continue)");
                int x = scan.nextInt(), y = scan.nextInt();
                if (x < 0 || y < 0) break;
                if (x > Grid.size || y > Grid.size) {
                    throw new Exception("The coordinates are out of bounds.");
                }
                System.out.println("This cell is " + (Grid.grid[y][x].alive ? "alive" : "dead") + ". " +
                        "What state do you want to put it in? (1 - alive, 0 - dead): ");
                int input = scan.nextInt();
                if (input == 1) {
                    Grid.grid[x][y].makeAlive();
                } else {
                    Grid.grid[x][y].makeDead();
                }
                System.out.println("Cell's state has been changed: ");
                System.out.println(grid);
            }
            System.out.println("How many steps you want this system to play for?");
            int steps = scan.nextInt();
            for (int s = 1; s <= steps; s++) {
                Grid.cellCheck();
                System.out.println(grid);
            }
            System.out.println("Do you want to continue (1) or close the app? (0)");
            int input = scan.nextInt();
            if (input == 0) break;
        }
        scan.close();
    }
}