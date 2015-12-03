package xyz.tonimartinez.cleanandroidapiclient.domain.interactor;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ErrorImpl implements Error {

    private String text;

    public ErrorImpl() {
    }

    public ErrorImpl(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
