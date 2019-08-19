package benjamin.gu.umbrella.presenter;

import com.example.rxjavatest.model.SimpsonCharacter;
import com.example.rxjavatest.view.ViewContract;

import java.util.ArrayList;

public interface PresenterContract {
    void onBindView(ViewContract view);
    void unBindView();
    void initNetworkCall();
    void onSuccessDataCharacter(ArrayList<SimpsonCharacter> data);
    void onErrorDataCharacter(String errorMessage);
}
