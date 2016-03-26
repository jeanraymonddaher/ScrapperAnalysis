package com.example.apple.scrapperanalysis30;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Apple
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.String;import java.lang.System;import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
*/
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class ScrapperConnector {

   static private File xml;
    static private String contents="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n";

    public File getXml(){
        if(xml!=null){
        return xml;}
        return null;
    }

    public String getXmlContents(){
        return  contents;
    }
    public void setXml(File a){
        ScrapperConnector.xml=a;
    }

    private static List getApplicationScratch(Element[] a, int count) {
        Element name;
        Element ratings;
        Element updated_date;
        Element downloads;
        Element requires_android;
        Element company;
        Element score;
        Element description;
        Element content;
        Element five_stars;
        Element four_stars;
        Element three_stars;
        Element two_stars;
        Element one_stars;
        List<AppScrap> apps = new ArrayList<AppScrap>();
        Serializer serializer = new Persister();
        //String contents="";
        //String display = "";
        Whitelist whitelist = Whitelist.none();
        for (int i = 0; i < count; i++) {
            //System.out.println(a[0]);
            //Length of App Description (e.g., in characters) versus user ranking (average star ranking)
            five_stars = a[i].select("span.bar-number").get(0);
            four_stars=a[i].select("span.bar-number").get(1);
            three_stars=a[i].select("span.bar-number").get(2);
            two_stars=a[i].select("span.bar-number").get(3);
            one_stars=a[i].select("span.bar-number").get(4);                   
            content = a[i].select("div[itemprop=contentRating]").first();
            description=a[i].select("div[jsname=C4s9Ed]").first();            
            company = a[i].select("span[itemprop=name]").first();//WORKING APP NAME          
            score=a[i].select("div.score").first();// working score rating            
            name = a[i].select("div.id-app-title").first();//inc /company
            ratings = a[i].select("div.id-app-title").first();//number of ratings


            updated_date = a[i].select("div.content").first(); //updated date
            downloads = a[i].select("div[itemprop=numDownloads]").first(); //number of downloads
            requires_android = a[i].select("div[itemprop=operatingSystems]").first(); //version of android needed
            
            String final_name = name.toString();
            String final_company= company.toString();
            String final_score= score.toString();
            String final_ratings = ratings.toString();
            String final_updated_date = updated_date.toString();
            String final_downloads = downloads.toString();
            String final_requires_android = requires_android.toString();
            String final_description= description.toString();
            String final_content=content.toString();
            String final_five_stars=five_stars.toString();
            String final_four_stars=four_stars.toString();
            String final_three_stars=three_stars.toString();
            String final_two_stars=two_stars.toString();
            String final_one_stars=one_stars.toString();
                    
            final_name = Jsoup.clean(final_name, whitelist);
            final_company=Jsoup.clean(final_company, whitelist);
            final_score=Jsoup.clean(final_score, whitelist);
            final_ratings = Jsoup.clean(final_ratings, whitelist);
            final_updated_date = Jsoup.clean(final_updated_date, whitelist);
            final_downloads = Jsoup.clean(final_downloads, whitelist);
            final_requires_android = Jsoup.clean(final_requires_android, whitelist);
            final_description= Jsoup.clean(final_description,whitelist);
            final_content=Jsoup.clean(final_content, whitelist);
            final_five_stars=Jsoup.clean(final_five_stars, whitelist);
            final_four_stars=Jsoup.clean(final_four_stars, whitelist);
            final_three_stars=Jsoup.clean(final_three_stars, whitelist);
            final_two_stars=Jsoup.clean(final_two_stars, whitelist);
            final_one_stars=Jsoup.clean(final_one_stars, whitelist);
            final_five_stars=final_five_stars.replace(",","");
            int o=Integer.parseInt(final_five_stars) +
                    Integer.parseInt(final_four_stars.replace(",",""))+
                    Integer.parseInt(final_three_stars.replace(",",""))+
                    Integer.parseInt(final_two_stars.replace(",",""))+
                    Integer.parseInt(final_one_stars.replace(",",""));
            final_ratings=o+"";

            AppScrap temp = new AppScrap();
            temp.setName(final_name);
            temp.setCompany(final_company);
            temp.setScore(final_score);
            temp.setRatings(final_ratings);
            temp.setUpdated_date(final_updated_date);
            temp.setDownloads(final_downloads);
            temp.setRequires_android(final_requires_android);
            temp.setDescription(final_description);
            temp.setContent(final_content);
            temp.setFive_stars(final_five_stars);
            temp.setFour_stars(final_four_stars);
            temp.setThree_stars(final_three_stars);
            temp.setTwo_stars(final_two_stars);
            temp.setOne_stars(final_one_stars);


            apps.add(temp);


            try {
                serializer.write(temp,xml);
                int length = (int) xml.length();

                byte[] bytes = new byte[length];

                FileInputStream in = new FileInputStream(xml);
                try {
                    in.read(bytes);
                } finally {
                    in.close();
                }

                contents += new String(bytes)+"\n";

            } catch (Exception e) {
                e.printStackTrace();

            }
            // File result = new File(getFilesDir().getPath()+"/Report.xml");


            }

        return apps;
    }


   public static String printAppScratch(OpenReadCsv a){
        if (a.extractUrl()!= null){
        String[] urls = a.extractUrl();
        int count = a.countUrl(urls);
        Element[] contents = new Element[50];
        String temp;
            temp = "";
            try {
            for (int i = 0; i < count; i++) {
                Document doc = Jsoup.connect(urls[i]).get();
                contents[i] = doc.body();
            }
        } catch (IOException ex) {
            Logger.getLogger(ScrapperConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        List temporary = getApplicationScratch(contents, count);
        //ScrapperConnector.xml=exportXml(temporary);
        for (int x = 0; x < count; x++) {
            temp=temp+temporary.get(x).toString();
            System.out.print(temporary.get(x).toString());
        }
        return temp;
        }
        else{
            return null;
        }
   }
    

}
