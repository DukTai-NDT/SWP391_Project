/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Categories {
    private int CategoriesID;
	private String Name;
        private String Image;

    public Categories(int CategoriesID, String Name, String Image) {
        this.CategoriesID = CategoriesID;
        this.Name = Name;
        this.Image = Image;
    }

    

    public Categories(String Name, String Image) {
        this.Name = Name;
        this.Image = Image;
    }

    public Categories() {
    }

    public int getCategoriesID() {
        return CategoriesID;
    }

    public void setCategoriesID(int CategoriesID) {
        this.CategoriesID = CategoriesID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    
    

    @Override
    public String toString() {
        return "Categories{" + "CategoriesID=" + CategoriesID + ", Name=" + Name + '}';
    }
    
}
