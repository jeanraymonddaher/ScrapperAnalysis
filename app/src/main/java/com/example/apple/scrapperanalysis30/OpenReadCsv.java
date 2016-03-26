package com.example.apple.scrapperanalysis30;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;import java.lang.System;import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Apple on 3/14/16.
 */
public class OpenReadCsv {



    /**
     *
     * @author Apple
     */

        private File file;

        public OpenReadCsv(File f) {
            this.file = f;
        }

        public int countUrl(String[] a) {
            int i = 0;
            while (a[i] != null) {
                i++;
            }
            return i;
        }

        public String viewCsv() {
            if (this.file == null) {
                return "invalid file";
            }

            String reading = "";
            try {
                CSVReader reader = new CSVReader(new FileReader(this.file));

//must replace by file chosen from gui name
                if (reader != null) {
                    String[] nextLine;
                    while ((nextLine = reader.readNext()) != null) {
                        // nextLine[] is an array of values from the line
                        //  System.out.println(nextLine[0]);
                        reading = reading + nextLine[0] + "\n";
                        System.out.println(nextLine[0]);
                    }
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(OpenReadCsv.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OpenReadCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
            return reading;

        }
        //method to open and view csv file

        public String printUrl() {
            if (this.file == null) {
                return "invalid file";
            }
            String[] a = extractUrl();
            String temp = "";
            for (int i = 0; i < a.length; i++) {
                if (a[i] != null) {
                    temp = temp + a[i] + "\n";
                }
            }
            return temp;
        }

        public String[] extractUrl() {
            if (this.file == null) {
                return null;
            }

            String[] urls = new String[50];
            try {
                CSVReader reader = new CSVReader(new FileReader(this.file));
                String[] nextLine;
                String[] temp = new String[50];
                int i = 0;

                while ((nextLine = reader.readNext()) != null) {
                    // nextLine[] is an array of values from the line
                    //  System.out.println(nextLine[0]);
                    temp[i] = nextLine[0];
                    i++;
                }
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] != null) {
                        int split = temp[j].indexOf(";");
                        temp[j] = temp[j].substring(0, split);
                        //System.out.println(temp[j]);
                    }
                }
                //remove first element and get final urls from CSV

                for (int x = 0; x < urls.length; x++) {
                    if (temp[x] != null && temp[x + 1] != null) {
                        urls[x] = temp[x + 1];
                        //System.out.println(urls[x]);
                    }
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(OpenReadCsv.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OpenReadCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
            return urls;
        }

    }


