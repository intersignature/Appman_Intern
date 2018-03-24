package intern.appman.sirichai.appmanintern.model.pojo;

import java.util.List;

public class AllDataModel {

    private String id;
    private String firstname;
    private String lastname;
    private List<DataModel> dataModel;

    public AllDataModel(String id, String firstname, String lastname, List<DataModel> dataModel) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dataModel = dataModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<DataModel> getDataModel() {
        return dataModel;
    }

    public void setDataModel(List<DataModel> dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public String toString() {
        return "id: " + id + " firstname: " + firstname + " lastname: " + lastname + " dataModel: " + dataModel;
    }
}
