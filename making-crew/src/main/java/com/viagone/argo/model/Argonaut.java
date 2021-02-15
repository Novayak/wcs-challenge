package com.viagone.argo.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Argonaut {
    
    private Long id;
    private String fullname;

    public Argonaut() {
    }

    public Argonaut(Long id, String fullname) {
        this.id = id;
        this.fullname = fullname;        
    }

    @Override
    public String toString() {
        return "Argonaut [fullname=" + fullname + ", id=" + id + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    /**
     * 
     * @param fullname
     * @throws Exception if the parameter doesn't matchs the valid pattern (only letters and dashes)
     */
    public void setFullname(String fullname) throws Exception{
        String fullnameRegex = "^[a-zA-Z-]+$";
        Pattern p = Pattern.compile(fullnameRegex);
        Matcher m = p.matcher(fullname);

        if (m.matches() == false) {
            throw new Exception("That's not a valid Argonaut name!");
        }
        if (fullname.isEmpty()) {
            throw new Exception("Ghosts are not allowed on board! Please provide a name");
        }

        else {
            this.fullname = fullname;
        }
        
    }

    



    
    
}
