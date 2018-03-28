package intern.appman.sirichai.appmanintern.pojo;

public class Description {

    private String th;
    private String en;

    public Description(String th, String en) {
        this.th = th;
        this.en = en;
    }

    public String getTh() {
        return th;
    }

    public void setTh(String th) {
        this.th = th;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    @Override
    public String toString() {
        return "th: " + th + " en: " + en;
    }
}
