package app.sample.styledotmesample.callback;

public interface OnItemClick {

    void onClick(int position, Object object);

    default void onMenuClick(int position, Object object) {
    }

}
