package dao;

// This allows for easy access to all your DAOs for the Prints page.
public class iPrintsDAOFactory {
    // public iInfo1DAO getInfo1DAO();

    // This is for AI pics to display on the website.
    public iShowcaseDAO getShowcaseDAO();

    // This is for links to print websites like redbubble, displate, a canvas printing website, etc.
    public iPrintLinksDAO getPrintLinksDAO();

    // This is for sign-ups for commisions. 
    public iCommisionsDAO getCommisionsDAO();

}
