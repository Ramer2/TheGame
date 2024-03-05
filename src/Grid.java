public class Grid {
    private static final int DEFAULT_SIZE = 16;
    public static int alive_count = 0;
    public static int size;
    private static Grid instance;
    public static Cell[][] grid;

    private Grid(int size){
        grid = new Cell[size][size];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
        Grid.size = size;
    }

    private Grid(){
        grid = new Cell[DEFAULT_SIZE][DEFAULT_SIZE];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
        size = DEFAULT_SIZE;
    }

    public static Grid create(int size) {
        instance = new Grid(size);
        return instance;
    }

    public static Grid create() {
        instance = new Grid();
        return instance;
    }

    public static Grid getInstance() {
        return instance;
    }

    public static void cellCheck(){
        int[][] changeToOpposite = new int[alive_count][2];
        //first coordinate is an identifier for a pair of values x and y
        //for example: {{0, 0}, {0, 1}, {1, 0}, {1, 1}, ... };
        int ptr = 0; //pointer for the array

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell check = grid[i][j];

                int neighbor_count = 0;
                int x = check.x;
                int y = check.y;

                //counting neighbors
                if (y != 0 && grid[x][y - 1].alive) neighbor_count++;
                if (x != size - 1 && y != 0 && grid[x + 1][y - 1].alive) neighbor_count++;
                if (x != size - 1 && grid[x + 1][y].alive) neighbor_count++;
                if (x != size - 1 && y != size - 1 && grid[x + 1][y + 1].alive) neighbor_count++;
                if (y != size - 1 && grid[x][y + 1].alive) neighbor_count++;
                if (x != 0 && y != size - 1 && grid[x - 1][y + 1].alive) neighbor_count++;
                if (x != 0 && grid[x - 1][y].alive) neighbor_count++;
                if (x != 0 && y != 0 && grid[x - 1][y - 1].alive) neighbor_count++;


                //going through the rules
                //neighbors < 2 => dies (if alive) (underpopulation)
                if (check.alive && neighbor_count < 2) {
                    changeToOpposite[ptr][0] = x;
                    changeToOpposite[ptr][1] = y;
                    ptr++;
                }

                //neighbors == 2 or 3 => lives (no implementation is needed)

                //neighbors > 3 => dies (if alive) (overpopulation)
                if (check.alive && neighbor_count > 3) {
                    changeToOpposite[ptr][0] = x;
                    changeToOpposite[ptr][1] = y;
                    ptr++;
                }

                //neighbors == 3 => birth (if dead)
                if (!check.alive && neighbor_count == 3) {
                    changeToOpposite[ptr][0] = x;
                    changeToOpposite[ptr][1] = y;
                    ptr++;
                }
            }
        }
        //changing states
        for (int i = 0; i < changeToOpposite.length; i++) {
            int x = changeToOpposite[i][0];
            int y = changeToOpposite[i][1];

            if (grid[x][y].alive) {
                grid[x][y].makeDead();
            } else {
                grid[x][y].makeAlive();
            }
        }
    }

    @Override
    public String toString(){
        String s = "";
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                s += (cell.alive ? "1" : "0") + " ";
            }
            s += "\n";
        }
        return s;
    }
}
