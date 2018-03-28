package intern.appman.sirichai.appmanintern.pojo;

import java.util.List;

public class AppmanInternData {

    private String id;
    private String firstname;
    private String lastname;
    private List<Data> data;

    public AppmanInternData(String id, String firstname, String lastname, List<Data> data) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.data = data;
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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "id: " + id + " firstname: " + firstname + " lastname: " + lastname + " data: " + data;
    }
}
