package rhythmgame;

public class Note {
    private int spawnTime; // Time in milliseconds since song start
    private int lane; // Lane index (0 to 3 for 4 lanes)
    private double yPosition; // Current y-coordinate (pixels)
    private int type; // tells if it's a standard or hold note

    public Note(int spawnTime, int lane, int type) {
        this.spawnTime = spawnTime;
        this.lane = lane;
        this.yPosition = 0; // Start at top
        this.type = type;
    }

    public long getSpawnTime() {
        return spawnTime;
    }

    public int getLane() {
        return lane;
    }

    public double getY() {
        return yPosition;
    }

    public void setYPosition(double yPosition) {
        this.yPosition = yPosition;
    }
    
    public int getType(){
        return type;
    }
    
    public boolean isOverlapping(int hitLineY, int margin) {
    return Math.abs(this.getY() - hitLineY) <= margin;
}
}