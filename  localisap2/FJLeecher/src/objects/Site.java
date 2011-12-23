/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class Site implements Serializable{

    /**
     * @return the nome
     */
    public String getName() {
        return name;
    }

    /**
     * @param nome the nome to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the getString
     */
    public String getGetString() {
        return getString;
    }

    /**
     * @param getString the getString to set
     */
    public void setGetString(String getString) {
        this.getString = getString;
    }

    /**
     * @return the increment
     */
    public int getIncrement() {
        return increment;
    }

    /**
     * @param increment the increment to set
     */
    public void setIncrement(int increment) {
        this.increment = increment;
    }

    /**
     * @return the parseType
     */
    public Parse getParseType() {
        return parseType;
    }

    /**
     * @param parseType the parseType to set
     */
    public void setParseType(Parse parseType) {
        this.parseType = parseType;
    }

    /**
     * @return the fistParseA
     */
    public String getFistParseA() {
        return fistParseA;
    }

    /**
     * @param fistParseA the fistParseA to set
     */
    public void setFistParseA(String fistParseA) {
        this.fistParseA = fistParseA;
    }

    /**
     * @return the fistParseB
     */
    public String getFistParseB() {
        return fistParseB;
    }

    /**
     * @param fistParseB the fistParseB to set
     */
    public void setFistParseB(String fistParseB) {
        this.fistParseB = fistParseB;
    }

    /**
     * @return the secoundParseA
     */
    public String getSecoundParseA() {
        return secoundParseA;
    }

    /**
     * @param secoundParseA the secoundParseA to set
     */
    public void setSecoundParseA(String secoundParseA) {
        this.secoundParseA = secoundParseA;
    }

    /**
     * @return the secoundParseB
     */
    public String getSecoundParseB() {
        return secoundParseB;
    }

    /**
     * @param secoundParseB the secoundParseB to set
     */
    public void setSecoundParseB(String secoundParseB) {
        this.secoundParseB = secoundParseB;
    }

    /**
     * @return the pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * @return the login
     */
    public boolean isLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(boolean login) {
        this.login = login;
    }

    /**
     * @return the loginPostURL
     */
    public String getLoginPostURL() {
        return loginPostURL;
    }

    /**
     * @param loginPostURL the loginPostURL to set
     */
    public void setLoginPostURL(String loginPostURL) {
        this.loginPostURL = loginPostURL;
    }

    /**
     * @return the loginPostData
     */
    public String getLoginPostData() {
        return loginPostData;
    }

    /**
     * @param loginPostData the loginPostData to set
     */
    public void setLoginPostData(String loginPostData) {
        this.loginPostData = loginPostData;
    }

    /**
     * @return the loginUser
     */
    public String getLoginUser() {
        return loginUser;
    }

    /**
     * @param loginUser the loginUser to set
     */
    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    /**
     * @return the loginPass
     */
    public String getLoginPass() {
        return loginPass;
    }

    /**
     * @param loginPass the loginPass to set
     */
    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    /**
     * @return the loginSuccess
     */
    public String getLoginSuccess() {
        return loginSuccess;
    }

    /**
     * @param loginSuccess the loginSuccess to set
     */
    public void setLoginSuccess(String loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    /**
     * @return the firstPage
     */
    public int getFirstPage() {
        return firstPage;
    }

    /**
     * @param firstPage the firstPage to set
     */
    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }
    
    public enum Parse{
        SINGLE,DOUBLE;
    }

    public Site(String name, String host, String getString, int increment, Parse parseType, String fistParseA, String fistParseB, String secoundParseA, String secoundParseB, int pages, boolean login, String loginPostURL, String loginPostData, String loginUser, String loginPass, String loginSuccess, int firstPage) {
        this.name = name;
        this.host = host;
        this.getString = getString;
        this.increment = increment;
        this.parseType = parseType;
        this.fistParseA = fistParseA;
        this.fistParseB = fistParseB;
        this.secoundParseA = secoundParseA;
        this.secoundParseB = secoundParseB;
        this.pages = pages;
        this.login = login;
        this.loginPostURL = loginPostURL;
        this.loginPostData = loginPostData;
        this.loginUser = loginUser;
        this.loginPass = loginPass;
        this.loginSuccess = loginSuccess;
        this.firstPage = firstPage;
    }
    
    
    
    private String name;
    private String host;
    private String getString;
    private int increment;
    private Parse parseType;
    private String fistParseA;
    private String fistParseB;
    private String secoundParseA;
    private String secoundParseB;
    private int pages;
    private boolean login;
    private String loginPostURL;
    private String loginPostData;
    private String loginUser;
    private String loginPass;
    private String loginSuccess;
    private int firstPage;
}
