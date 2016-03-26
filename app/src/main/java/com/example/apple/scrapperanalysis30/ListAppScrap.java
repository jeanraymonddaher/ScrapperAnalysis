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

import java.util.*;
/*
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
*/
//@XmlRootElement(name="AppScraps")
public class ListAppScrap {
    
    private List<AppScrap> listAppScraps = new ArrayList<AppScrap>();

    // @XmlElement(name="App")
    public List<AppScrap> getListAppScraps() {
        return listAppScraps;
    }

    public void setListAppScraps(List<AppScrap> listAppScraps) {
        this.listAppScraps = listAppScraps;
    }

}
