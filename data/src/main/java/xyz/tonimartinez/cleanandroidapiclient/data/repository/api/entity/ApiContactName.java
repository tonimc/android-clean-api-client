package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public class ApiContactName {

    public static final String MALE = "male";
    public static final String FEMALE = "female";

    public static final String TITLE_MALE = "mr";
    public static final String TITLE_FEMALE = "ms";

    private String title;
    private String first;
    private String last;

    public ApiContactName() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
