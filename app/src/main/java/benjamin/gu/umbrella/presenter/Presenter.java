package benjamin.gu.umbrella.presenter;

import android.util.Log;

import com.example.rxjavatest.model.ApiInterface;
import com.example.rxjavatest.model.SimpsonCharacter;
import com.example.rxjavatest.model.SimpsonResult;
import com.example.rxjavatest.view.ViewContract;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import benjamin.gu.umbrella.model.ApiInterface;
import benjamin.gu.umbrella.model.ListPojo;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterContract {
    private static final String TAG = "Presenter";
    private ViewContract view;

    @Override
    public void onBindView(ViewContract view) {
        this.view = view;
    }

    @Override
    public void unBindView() {
        view = null;
    }

    @Override
    public void initNetworkCall() {
        Log.d(TAG, "initNetworkCall: ");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.duckduckgo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        apiInterface.getWeatherResult(
                "simpsons characters",
                "json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SimpsonResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SimpsonResult simpsonResult) {
                        Log.d(TAG, "onNext: "+simpsonResult.RelatedTopics.size());
                        onSuccessDataCharacter(simpsonResult.RelatedTopics);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onErrorDataCharacter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onSuccessDataCharacter(ArrayList<ListPojo> data) {
        view.onDataPopulated(data);
    }

    @Override
    public void onErrorDataCharacter(String errorMessage) {
        view.onErrorMessage(errorMessage);
    }
}
