package intern.appman.sirichai.appmanintern.model.pojo;

public class DataModel {

    private String docType;
    private DescriptionModel descriptionModel;

    public DataModel(String docType, DescriptionModel descriptionModel) {
        this.docType = docType;
        this.descriptionModel = descriptionModel;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public DescriptionModel getDescriptionModel() {
        return descriptionModel;
    }

    public void setDescriptionModel(DescriptionModel descriptionModel) {
        this.descriptionModel = descriptionModel;
    }

    @Override
    public String toString() {
        return "docType: " + docType + " descriptionModel " + descriptionModel.toString();
    }
}
