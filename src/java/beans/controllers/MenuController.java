package beans.controllers;

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
    boolean searchRender = false;
    String pageName;
    String pageLink = "reusable/post.xhtml";
    List<Screen> menuList = new ArrayList<>();

    List<Post> listOfHomePosts = new ArrayList<>();

    /**
     * Initialization method
     */
    public void init() {

    }

    /**
     * A method to navigate views and change the current view:
     *
     * @param view
     */
    public void navigateViews(String view) {
        switch (view) {
            case "":
                break;
//            case "":
//                break;
//            case "":
//                break;
//            case "":
//                break;
//            case "":
//                break;
        }
    }

    public void searchInputText() {
        searchRender = !searchRender;
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

    public boolean isSearchRender() {
        return searchRender;
    }

    public void setSearchRender(boolean searchRender) {
        this.searchRender = searchRender;
    }

    public List<Post> getListOfHomePosts() {
        return listOfHomePosts;
    }

    public void setListOfHomePosts(List<Post> listOfHomePosts) {
        this.listOfHomePosts = listOfHomePosts;
    }

}
