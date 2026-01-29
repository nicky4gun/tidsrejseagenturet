package com.example.tidsrejseagenturet;

public class Guide {
    private int id;
    private String guideName;
    private String Speciality;

    public Guide (int id, String guideName, String Speciality) {
        this.id = id;
        this.guideName = guideName;
        this.Speciality = Speciality;

    }
    public Guide (String timeMachineName, String Speciality) {
        this.guideName = timeMachineName;
        this.Speciality = Speciality;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuideName() {
        return guideName;
    }

    public String getSpeciality() {
        return Speciality;
    }
}
