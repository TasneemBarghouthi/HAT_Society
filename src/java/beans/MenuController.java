/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.Post;
import models.Screen;

/**
 *
 * @author Tasneem
 */
@ManagedBean
@SessionScoped
public class MenuController implements Serializable {

    String searhText;
    String pageName;
    String pageLink = "reusable/post.xhtml";
    List<Screen> menuList = new ArrayList<>();

    List<Post> listOfHomePosts = new ArrayList<>();

    /**
     * initialize method
     */
    public void init() {

    }

    public void changeIndex() {
        pageLink = "search-result.xhtml";
    }

    //Setters and Getters Methods
    public String getSearhText() {
        return searhText;
    }

    public void setSearhText(String searhText) {
        this.searhText = searhText;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }

    public List<Screen> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Screen> menuList) {
        this.menuList = menuList;
    }

}
