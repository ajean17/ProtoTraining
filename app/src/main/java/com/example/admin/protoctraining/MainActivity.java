package com.example.admin.protoctraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.protoctraining.protos.AddressBookProtos.Person;
import com.example.admin.protoctraining.protos.AddressBookProtos.AddressBook;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.protobuf.ProtoConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    //private ProtoConverterFactory proto = ProtoConverterFactory.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        protoPlay();
    }

    public void protoPlay() {
        Person john =
                Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhones(
                                Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(Person.PhoneType.HOME))
                        .build();

        Log.d(TAG, "protoPlay: Is John initialized?: " + john.isInitialized());
        Log.d(TAG, "protoPlay: " + john.toString());
        byte[] bbs = john.toByteArray();

        Person.PhoneNumber newNumber = Person.PhoneNumber.newBuilder()
                .setNumber("770-3432")
                .setType(Person.PhoneType.MOBILE)
                .build();
        Log.d(TAG, "protoPlay: " + newNumber.toString());
    }

}

/*public void useProtoConvert() {

        Retrofit retro = new Retrofit.Builder().baseUrl("www.google.com").addConverterFactory(proto).build();
    }

    interface Service {
        @GET("/user")
        Call<AddressBook> user();

        /*@GET("/friend")
        Call<Friends> friends();

    }*/

//C:\Users\Admin\AndroidStudioProjects\ProtocTraining\app\src\main\java
//protoc -I="C:\Users\Admin\AndroidStudioProjects\ProtocTraining\app\src\main\java" --java_out="C:\Users\Admin\AndroidStudioProjects\ProtocTraining\app\src\main\java" C:\Users\Admin\AndroidStudioProjects\ProtocTraining\app\src\main\java/addressbook.proto