package crro.brown.us.todoapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class DisplayActivity extends ActionBarActivity {
    //Our arraylist will manage our todos
    private ArrayList<Todo> _todoList;
    private ListView _lView;
    private TodoListAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        _todoList = new ArrayList<Todo>();

        //action bar, always use the support version
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        //We are going to grab the icon.
        _adapter = new TodoListAdapter();
        _lView = (ListView) findViewById(R.id.todoList);
        _lView.setAdapter(_adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.new_todo) {
            Intent createTodo = new Intent(this, CreateTodoActivity.class);
            //If you were to launch multiple activities, the request code will be used to distinguish
            //between them
            startActivityForResult(createTodo, 0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            //Activity that created a todo
            if (resultCode == RESULT_OK) {
                //everything went fine
                Bundle bundle = data.getExtras();
                _todoList.add(new Todo(bundle.getString("Title"), bundle.getString("Notes")));
                _adapter.notifyDataSetChanged();
            }
        }
    }

    private class TodoListAdapter extends BaseAdapter {
        //If you were to have this in a sepearate class you would most likely send
        //_todoList to the constructor

        @Override
        public int getCount() {
            return _todoList.size();
        }

        @Override
        public Object getItem(int position) {
            return _todoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //TODO: implement the holder pattern

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = DisplayActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.todo_view, null);
            }
            CheckBox cBox = (CheckBox) convertView.findViewById(R.id.checkBoxTodo);
            cBox.setText(_todoList.get(position).getTitle());
            return convertView;
        }
    }
}
