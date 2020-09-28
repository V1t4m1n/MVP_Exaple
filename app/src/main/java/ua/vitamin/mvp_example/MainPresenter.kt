package ua.vitamin.mvp_example

import android.util.Log

class MainPresenter (view: Contract.View) : Contract.Presenter {

    private final val TAG: String = this.javaClass.simpleName

    private val view: Contract.View = view
    private val model: Contract.Model = MainModel()

    private var listPeople: List<User> = listOf()

    override fun onPeopleListLoading() {
        listPeople = model.loadList()
        view.showList(listPeople)
        Log.d(TAG, "onButtonWasClicked()")
    }

    override fun onDestroy() {

        Log.d(TAG, "onDestroy()")
    }
}