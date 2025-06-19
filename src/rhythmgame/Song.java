/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rhythmgame;

/**
 *
 * @author logan
 */
public class Song {
    private String title;
    private String difficulty;
    private String author; // Needed for credit
    private static String length;
    private int numNotes;
    private int bestAcc;
    private int bestScore;
    private String music; // File Path for music
    private String beatmap; // File Path for beatmap
    public Song(String t,String a,String d, int l, String m, String b){
        this(t,a,d,l,0,0,0, m, b);
    }
    public Song(String t, String a, String d, int l, int numN, int bAcc, int bS, String m, String b){
        title = t;
        difficulty = d;
        length = "" + (l / 60) + ":" + (l % 60);
        numNotes = numN;
        bestAcc = bAcc;
        bestScore = bS;
        music = m;
        beatmap = b;
        
    }

    public int getBestAcc() {
        return bestAcc;
    }
    
    public String getBeatmap(){
        return beatmap;
    }

    public void setBestAcc(int bestAcc) {
        this.bestAcc = bestAcc;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public String getTitle() {
        return title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public static String getLength() {
        return length;
    }

    public int getNumNotes() {
        return numNotes;
    }
    
    public String getMusic(){
        return music;
    }
    
    public String getAuthor(){
        return author;
    }
    
}
