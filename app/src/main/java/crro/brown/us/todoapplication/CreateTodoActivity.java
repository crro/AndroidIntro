package crro.brown.us.todoapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;


public class CreateTodoActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_todo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_done) {
            //terminate the activity and return the fields

            String title = ((EditText) findViewById(R.id.todoTitleET)).getText().toString();
            String notes = ((EditText) findViewById(R.id.todoTitleET)).getText().toString();

            //Now we create the package that we will send back to the activity
            Intent todo = new Intent();
            Bundle content = new Bundle();
            content.putString("Title", title);
            content.putString("Notes", notes);
            todo.putExtras(content);
            setResult(RESULT_OK, todo);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
