package com.kina.model;

public class Account {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the roles
     */
    public int getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(int roles) {
        this.roles = roles;
    }

    private String id;
    private String pass;
    private int roles;
   

  
}
