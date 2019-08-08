package com.example.mvp_hello_example;

public interface SayHelloContract {

    interface View {

        void ShowMessage(String msg);

        void ShowError(String Error);
    }

    interface Presenter {
        void loadMessage();

        void saveName(String firstName , String lastName);
    }


}
