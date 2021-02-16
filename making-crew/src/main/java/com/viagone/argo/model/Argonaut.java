package com.viagone.argo.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.viagone.argo.Exception.ArgoException;

public class Argonaut {
    
    private Integer id;
    private String fullname;

    public Argonaut() {
    }

    public Argonaut(Integer id, String fullname) {
        this.id = id;
        this.fullname = fullname;        
    }

    @Override
    public String toString() {
        return "Argonaut [fullname=" + fullname + ", id=" + id + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public void setFullname(String fullname) throws ArgoException{
        String fullnameRegex = "^[a-zA-Z-]+$";
        Pattern p = Pattern.compile(fullnameRegex);
        Matcher m = p.matcher(fullname);

        if (m.matches() == false) {
            throw new ArgoException("That's not a valid Argonaut name!");
        }
        if (fullname.isEmpty()) {
            throw new ArgoException("Ghosts are not allowed on board! Please provide a name");
        }

        else {
            this.fullname = fullname;
        }
        
    }

    



    
    
}
