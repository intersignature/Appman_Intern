package intern.appman.sirichai.appmanintern.pojo;

public class Data {

    private String docType;
    private Description description;

    public Data(String docType, Description description) {
        this.docType = docType;
        this.description = description;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "docType: " + docType + " description " + description.toString();
    }
}
