package com.example.tidsrejseagenturet.models;

public class Guide {
    private int id;
    private String guideName;
    private String speciality;

    public Guide (int id, String guideName, String speciality) {
        this.id = id;
        this.guideName = guideName;
        this.speciality = speciality;
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
        return speciality;
    }

    @Override
    public String toString() {
        return guideName + ", Specialty: " + speciality;
    }
}
