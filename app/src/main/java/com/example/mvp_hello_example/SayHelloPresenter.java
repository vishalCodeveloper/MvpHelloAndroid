package com.example.mvp_hello_example;

public class SayHelloPresenter implements SayHelloContract.Presenter {
    private SayHelloContract.View view;
    private Person person;

    public SayHelloPresenter(SayHelloContract.View view) {
        this.view = view;
        person = new Person();
    }

    @Override
    public void loadMessage() {
        if(person.getFirstName()== null && person.getLastName() == null) {
            view.ShowError("No Person Name Found.");
            return;
        }
        String msg = "Hi "+person.getName() +" !";
        view.ShowMessage(msg);
    }

    @Override
    public void saveName(String firstName, String lastName) {
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }
}
