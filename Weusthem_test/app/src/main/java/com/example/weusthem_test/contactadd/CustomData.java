package com.example.weusthem_test.contactadd;
public class CustomData {
    private int imageID;
    private String contact;
    private String firstname;
    private String lastname;
    private String email;
    private int phonenumber;
    private int customView;


    public CustomData(int customView, String firstname, String email, int imageID,String contact,String lastname, int phonenumber){
        this.customView = customView;
        this.firstname = firstname;
        this.email = email;
        this.imageID = imageID;
        this.contact=contact;
        this.lastname=lastname;
        this.phonenumber=phonenumber;
    }

    public int getCustomView(){
        return customView;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getEmail() {
        return email;
    }
    public int getImageID() {
        return imageID;
    }
    public String getContact(){return contact;}
    public String getLastname() {
        return lastname;
    }
    public int getPhonenumber(){ return phonenumber;}
}
