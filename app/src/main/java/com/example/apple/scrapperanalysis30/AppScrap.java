package com.example.apple.scrapperanalysis30;

/*
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
*/

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.File;

//@XmlRootElement
//@RDFBean("http://xmlns.com/foaf/0.1/App")
@Root
public class AppScrap {

    @Element
    private String ratings;
    @Attribute
    private String name;
    @Element
    private String updated_date;
    @Element
    private String downloads;
    @Element
    private String requires_android;
    @Element
    private String score;
    @Element
    private String company;
    @Element
    private String description;
    @Element
    private String content;
    @Element
    private String five_stars;
    @Element
    private String four_stars;
    @Element
    private String three_stars;
    @Element
    private String two_stars;
    @Element
    private String one_stars;

    /* public AppScrap(String name,String ratings,String updated_date,String downloads,String requires_android){
     this.name=name;
     this.ratings=ratings;
     this.updated_date=updated_date;
     this.downloads=downloads;
     this.requires_android=requires_android;
     }
     */
    public String toString() {
        return "Name: " + this.name + "\n" + "Company: " + this.company + "\n------------------\n"
                + "Score: " + this.score + "\n" + "Ratings: " + this.ratings + "\n" + "Five Stars: "+this.five_stars+"\n"+ "Four Stars: "+this.four_stars+"\n"+"Three Stars: "+this.three_stars+"\n"+"Two Stars: "+this.two_stars+"\n"+"One Stars: "+this.one_stars+"\n------------------\n"
                + "Updated_date: " + this.updated_date + "\n" + "Downloads: " + this.downloads
                + "\n" + "Requires android version: " + this.requires_android + "\n" + "Content Rating: " + this.content + "\n" + "Description: "
                + this.description + "\n\n";

    }

    //@XmlAttribute //@RDFSubject
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@XmlElement
    //@RDF("http://xmlns.com/foaf/0.1/ratings")
    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    //@XmlElement
    //@RDF("http://xmlns.com/foaf/0.1/updated_date")

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    //@XmlElement
    // @RDF("http://xmlns.com/foaf/0.1/downloads")
    public String getDownloads() {
        return downloads;
    }

    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }

    //@XmlElement
    //@RDF("http://xmlns.com/foaf/0.1/requires_android")
    public String getRequires_android() {
        return requires_android;
    }

    public void setRequires_android(String requires_android) {
        this.requires_android = requires_android;
    }

    //@XmlElement
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    //@XmlElement
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    //@XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    //@XmlElement
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    //@XmlElement
    public String getFive_stars() {
        return five_stars;
    }

    public void setFive_stars(String five_stars) {
        this.five_stars = five_stars;
    }
    
    //@XmlElement
    public String getFour_stars() {
        return four_stars;
    }

    public void setFour_stars(String four_stars) {
        this.four_stars = four_stars;
    }
    
    //@XmlElement
    public String getThree_stars() {
        return three_stars;
    }

    public void setThree_stars(String three_stars) {
        this.three_stars = three_stars;
    }
    
    //@XmlElement
    public String getTwo_stars() {
        return two_stars;
    }

    public void setTwo_stars(String two_stars) {
        this.two_stars = two_stars;
    }
    
    //@XmlElement
    public String getOne_stars() {
        return one_stars;
    }

    public void setOne_stars(String one_stars) {
        this.one_stars = one_stars;
    }

}
