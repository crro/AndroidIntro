package crro.brown.us.todoapplication;

/**
 * Created by David on 2/1/15.
 */
public class Todo {

    private String _title;
    private String _description;

    public Todo(String title, String description) {
        _title = title;
        _description = description;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }
}
