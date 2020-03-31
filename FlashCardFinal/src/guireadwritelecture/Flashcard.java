/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guireadwritelecture;

/**
 *
 * @author Brad
 */
public class Flashcard {
    private int id;
    private String term, def;
    //setter,getters,both constructors,toString

    public Flashcard() {
    }

    public Flashcard(int id, String term, String def) {
        this.id = id;
        this.term = term;
        this.def = def;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    
    
}
