package ua.vitamin.mvp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.View {

    private final val TAG: String = this.javaClass.simpleName

    private val presenter: Contract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate()")
        listPeople.setHasFixedSize(true)
        listPeople.layoutManager = LinearLayoutManager(this)
        listPeople.adapter = PeopleListAdapter(listOf<User>())
    }


    override fun showList(listModels: List<User>) {
        listPeople.adapter = PeopleListAdapter(listModels)
    }

    override fun onResume() {
        super.onResume()
        presenter.onPeopleListLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
        Log.d(TAG, "onDestroy()")
    }
}