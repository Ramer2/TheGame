public class Cell {
    boolean alive;
    int x;
    int y;

    public Cell(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.alive = false;
    }

    public void makeAlive(){
        alive = true;
        Grid.alive_count++;
    }

    public void makeDead(){
        alive = false;
        Grid.alive_count--;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "alive=" + alive +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
