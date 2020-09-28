package ua.vitamin.mvp_example

interface Contract {

    public interface View {
        public fun showList(listPeople: List<User>)
    }

    public interface Presenter {
        public fun onPeopleListLoading()
        public fun onDestroy()
    }

    public interface Model {
        public fun loadList(): List<User>
    }
}